package mk.ukim.finki.emt.emtlab.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @ManyToOne
    private Country country;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 1. Празен конструктор (Задолжителен за JPA/Jackson)
    public Host() {
    }

    // 2. Конструктор со параметри
    public Host(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
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

    // 3. РАЧНИ ГЕТЕРИ И СЕТЕРИ (Без нив Swagger ќе покажува {})
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}