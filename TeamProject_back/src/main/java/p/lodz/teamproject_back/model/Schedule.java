package p.lodz.teamproject_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.text.DateFormat;
import java.time.temporal.WeekFields;
import java.util.List;

@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonManagedReference
    @JsonIgnore
    private List<Event> eventList;

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
}
