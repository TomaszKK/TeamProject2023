package p.lodz.teamproject_back.model;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class Schedule {
    private Long id;
    private String Date;
    private String Week;

    @OneToOne
    private String User;

    @ManyToOne
    private Event Event;

    public Schedule() {
    }

    public Long getId() {
        return id;
    }

}
