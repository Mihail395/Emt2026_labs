package mk.ukim.finki.emt.emtlab.service.domain;

import mk.ukim.finki.emt.emtlab.model.Accommodation;
import mk.ukim.finki.emt.emtlab.model.Review;
import mk.ukim.finki.emt.emtlab.model.dto.AccommodationDto;
import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> findAll();
    Optional<Accommodation> findById(Long id);
    Optional<Accommodation> save(AccommodationDto accommodationDto);
    Optional<Accommodation> edit(Long id, AccommodationDto accommodationDto);
    void delete(Long id);
    void markAsRented(Long id);
    Double getAverageRating(Long accommodationId);
    List<Review> getReviewsForAccommodation(Long accommodationId);
    Review addReview(Long accommodationId, String comment, Integer rating);
}