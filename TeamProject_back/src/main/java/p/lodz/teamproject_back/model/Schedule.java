package p.lodz.teamproject_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Event> eventList = new ArrayList<>();

    public Schedule() {
    }

    public Long getId() {
        return id;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void addEvent(Event event) {
        eventList.add(event);
        event.setSchedule(this);
    }

    public void removeEvent(Event event) {
        eventList.remove(event);
        event.setSchedule(null);
    }
}
