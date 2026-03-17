package mk.ukim.finki.emt.emtlab.service.application;

import mk.ukim.finki.emt.emtlab.model.Accommodation;
import mk.ukim.finki.emt.emtlab.model.Host;
import mk.ukim.finki.emt.emtlab.model.dto.AccommodationDto;
import mk.ukim.finki.emt.emtlab.model.enumerations.Category;
import mk.ukim.finki.emt.emtlab.model.enumerations.Condition;
import mk.ukim.finki.emt.emtlab.model.exceptions.AccommodationNotFoundException;
import mk.ukim.finki.emt.emtlab.model.exceptions.HostNotFoundException;
import mk.ukim.finki.emt.emtlab.repository.AccommodationRepository;
import mk.ukim.finki.emt.emtlab.repository.HostRepository;
import mk.ukim.finki.emt.emtlab.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostRepository hostRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Accommodation> findAll() {
        return this.accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return this.accommodationRepository.findById(id);
    }

    @Override
    public Optional<Accommodation> save(AccommodationDto dto) {
        Host host = this.hostRepository.findById(dto.getHostId())
                .orElseThrow(() -> new HostNotFoundException(dto.getHostId()));

        Accommodation accommodation = new Accommodation(dto.getName(), dto.getNumRooms(), dto.getCategory(), host);

        return Optional.of(this.accommodationRepository.save(accommodation));
    }

    @Override
    public Optional<Accommodation> edit(Long id, AccommodationDto dto) {
        Accommodation accommodation = this.accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));

        Host host = this.hostRepository.findById(dto.getHostId())
                .orElseThrow(() -> new HostNotFoundException(dto.getHostId()));

        accommodation.setName(dto.getName());
        accommodation.setNumRooms(dto.getNumRooms());
        accommodation.setCategory(dto.getCategory());
        accommodation.setHost(host);

        return Optional.of(this.accommodationRepository.save(accommodation));
    }

    @Override
    public void delete(Long id) {
        Accommodation accommodation = this.accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));

        if (accommodation.getConditionStatus().equals(Condition.BAD)) {
            this.accommodationRepository.delete(accommodation);
        } else {
            throw new RuntimeException("Може да се бришат само сместувања со состојба BAD.");
        }
    }

    @Override
    public void markAsRented(Long id) {
        Accommodation accommodation = this.accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));

        accommodation.setRented(true);
        this.accommodationRepository.save(accommodation);
    }
}