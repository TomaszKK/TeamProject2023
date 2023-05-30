package p.lodz.teamproject_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.lodz.teamproject_back.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findById(String name);
}
