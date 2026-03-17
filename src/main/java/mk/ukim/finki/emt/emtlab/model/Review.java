package mk.ukim.finki.emt.emtlab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    public Review(String comment, Integer rating, Accommodation accommodation) {
        this.comment = comment;
        this.rating = rating;
        this.accommodation = accommodation;
    }
    //public Review(){}
}
