package p.lodz.teamproject_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import p.lodz.teamproject_back.model.Event;
import p.lodz.teamproject_back.repository.EventRepository;

import java.util.List;

@Controller
@RequestMapping
public class EventController {
<<<<<<< HEAD
   private EventRepository eventRepository;

   @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/event")
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/event/{id}")
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @DeleteMapping("/event")
    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }

    @DeleteMapping("/event/{id}")
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    @PutMapping
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @PatchMapping("/event/{id}")
    public Event updateEventById(Long id, Event event) {
        Event eventToUpdate = eventRepository.findById(id).orElseThrow();
        eventToUpdate.setName(event.getName());
        eventToUpdate.setDescription(event.getDescription());
        eventToUpdate.setDate(event.getDate());
        eventToUpdate.setTime(event.getTime());
        eventToUpdate.setPlace(event.getPlace());
        eventToUpdate.setCategory(event.getCategory());
        eventToUpdate.setOrganizer(event.getOrganizer());
        eventToUpdate.setOrganizerEmail(event.getOrganizerEmail());
        eventToUpdate.setOrganizerPhone(event.getOrganizerPhone());
        eventToUpdate.setOrganizerWebsite(event.getOrganizerWebsite());
        return eventRepository.save(eventToUpdate);
    }
=======
//    branch test
>>>>>>> main
}
