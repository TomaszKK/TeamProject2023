package p.lodz.teamproject_back.model;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleEnum name;

    public Role() {
    }

    public Role(RoleEnum name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}
