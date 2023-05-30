package p.lodz.teamproject_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.text.DateFormat;
import java.time.temporal.WeekFields;
import java.util.List;

@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;
    private DateFormat Date;
/*
    @OneToOne(mappedBy = "User", cascade = CascadeType.ALL)
    private String User;
*/
    @ManyToMany(mappedBy = "scheduleList")
    private List<Event> eventList;


    public Schedule() {
    }

    public Long getId() {
        return id;
    }

    public DateFormat getDate() {
        return Date;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(DateFormat Date) {
        this.Date = Date;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
