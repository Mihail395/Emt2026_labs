package mk.ukim.finki.emt.emtlab.web;

import mk.ukim.finki.emt.emtlab.model.Accommodation;
import mk.ukim.finki.emt.emtlab.model.Review;
import mk.ukim.finki.emt.emtlab.model.dto.AccommodationDto;
import mk.ukim.finki.emt.emtlab.service.domain.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public List<Accommodation> findAll() {
        return this.accommodationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id) {
        return this.accommodationService.findById(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Accommodation> save(@RequestBody AccommodationDto accommodationDto) {
        return this.accommodationService.save(accommodationDto)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Accommodation> edit(@PathVariable Long id, @RequestBody AccommodationDto accommodationDto) {
        return this.accommodationService.edit(id, accommodationDto)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.accommodationService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rent/{id}")
    public ResponseEntity<Void> markAsRented(@PathVariable Long id) {
        this.accommodationService.markAsRented(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<Review> addReview(@PathVariable Long id,
                                            @RequestParam String comment,
                                            @RequestParam Integer rating) {
        return ResponseEntity.ok(
                this.accommodationService.addReview(id, comment, rating)
        );
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long id) {
        return ResponseEntity.ok(
                this.accommodationService.getReviewsForAccommodation(id)
        );
    }

    @GetMapping("/{id}/average-rating")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long id){
        return ResponseEntity.ok(
                this.accommodationService.getAverageRating(id)
        );
    }
 }