package p.lodz.teamproject_back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String date;
    private String time;
    private String place;
    private String category;
    private String organizer;
    private String organizerEmail;
    private String organizerPhone;
    private String organizerWebsite;

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getCategory() {
        return category;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public String getOrganizerPhone() {
        return organizerPhone;
    }

    public String getOrganizerWebsite() {
        return organizerWebsite;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        this.description = description;
    }

    public void setDate(String date) {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException("Date cannot be empty");
        }
        this.date = date;
    }

    public void setTime(String time) {
        if (time == null || time.isEmpty()) {
            throw new IllegalArgumentException("Time cannot be empty");
        }
        this.time = time;
    }

    public void setPlace(String place) {
        if (place == null || place.isEmpty()) {
            throw new IllegalArgumentException("Place cannot be empty");
        }
        this.place = place;
    }

    public void setCategory(String category) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.category = category;
    }

    public void setOrganizer(String organizer) {
        if (organizer == null || organizer.isEmpty()) {
            throw new IllegalArgumentException("Organizer cannot be empty");
        }
        this.organizer = organizer;
    }

    public void setOrganizerEmail(String organizerEmail) {
        if (organizerEmail == null || organizerEmail.isEmpty()) {
            throw new IllegalArgumentException("Organizer email cannot be empty");
        }
        this.organizerEmail = organizerEmail;
    }

    public void setOrganizerPhone(String organizerPhone) {
        if (organizerPhone == null || organizerPhone.isEmpty()) {
            throw new IllegalArgumentException("Organizer phone cannot be empty");
        }
        this.organizerPhone = organizerPhone;
    }

    public void setOrganizerWebsite(String organizerWebsite) {
        if (organizerWebsite == null || organizerWebsite.isEmpty()) {
            throw new IllegalArgumentException("Organizer website cannot be empty");
        }
        this.organizerWebsite = organizerWebsite;
    }
}
