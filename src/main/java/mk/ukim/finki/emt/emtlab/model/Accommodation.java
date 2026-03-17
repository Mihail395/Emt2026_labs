package mk.ukim.finki.emt.emtlab.model;

import jakarta.persistence.*;
import mk.ukim.finki.emt.emtlab.model.enumerations.Category;
import mk.ukim.finki.emt.emtlab.model.enumerations.Condition;
import java.time.LocalDateTime;

@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer numRooms;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Condition conditionStatus = Condition.GOOD;

    private boolean rented = false;

    @ManyToOne
    private Host host;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Accommodation() {}

    public Accommodation(String name, Integer numRooms, Category category, Host host) {
        this.name = name;
        this.numRooms = numRooms;
        this.category = category;
        this.host = host;
        this.conditionStatus = Condition.GOOD;
        this.rented = false;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // РАЧНО ГЕНЕРИРАНИ МЕТОДИ (Alt + Insert -> Getter and Setter)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getNumRooms() { return numRooms; }
    public void setNumRooms(Integer numRooms) { this.numRooms = numRooms; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Condition getConditionStatus() { return conditionStatus; }
    public void setConditionStatus(Condition conditionStatus) { this.conditionStatus = conditionStatus; }

    public boolean isRented() { return rented; }
    public void setRented(boolean rented) { this.rented = rented; }

    public Host getHost() { return host; }
    public void setHost(Host host) { this.host = host; }
}