package mk.ukim.finki.emt.emtlab.model.dto;

import mk.ukim.finki.emt.emtlab.model.enumerations.Category;

public class AccommodationDto {
    private String name;
    private Integer numRooms;
    private Category category;
    private Long hostId;

    public AccommodationDto() {}

    // Рачно генерирани (Alt + Insert -> Getter and Setter)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getNumRooms() { return numRooms; }
    public void setNumRooms(Integer numRooms) { this.numRooms = numRooms; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public Long getHostId() { return hostId; }
    public void setHostId(Long hostId) { this.hostId = hostId; }
}