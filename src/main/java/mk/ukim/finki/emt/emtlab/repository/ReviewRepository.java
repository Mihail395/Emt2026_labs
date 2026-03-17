package mk.ukim.finki.emt.emtlab.repository;

import mk.ukim.finki.emt.emtlab.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByAccommodationId(Long accommodationId);
}
