package p.lodz.teamproject_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private EventEnum type;
    private String name;
    private String description;
    private Date date;
    private String startTime;
    private String endTime;
    private String place;
    private String category;
    private Boolean isRepeated;
    private Boolean isActive;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    private List<User> participantsList;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "organizer_id")
    private User organizer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    @JsonManagedReference
    private Schedule schedule;

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

    public Date getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPlace() {
        return place;
    }

    public String getCategory() {
        return category;
    }


    public EventEnum getType() {
        return type;
    }

    public User getOrganizer() {
        return organizer;
    }

    public List<User> getParticipantsList() {
        return participantsList;
    }

    public Boolean getIsActive(){
        return isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRepeated(Boolean repeated) {
        isRepeated = repeated;
    }

    public Boolean getRepeated() {
        return isRepeated;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setType(EventEnum type) {
        this.type = type;
    }

    public void setIsActive(Boolean isActive){
        this.isActive = isActive;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public void setParticipantsList(List<User> participantsList) {
        this.participantsList = participantsList;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
