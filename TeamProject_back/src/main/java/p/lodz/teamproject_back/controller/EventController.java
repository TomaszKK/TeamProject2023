package p.lodz.teamproject_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import p.lodz.teamproject_back.model.Event;
import p.lodz.teamproject_back.model.Schedule;
import p.lodz.teamproject_back.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventController {
   private EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/{id}")
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        eventRepository.save(event);
        return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Event> deleteAllEvents() {
        eventRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Event> deleteEventById(@PathVariable("id") long id) {
        eventRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> replaceEvent(@PathVariable Long id, @RequestBody Event newEvent) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            // Set the fields of the existing event with the fields from the new event
            event.setName(newEvent.getName());
            event.setDescription(newEvent.getDescription());
            // Set other fields as needed

            // Save the updated event
            eventRepository.save(event);

            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            // Update the fields of the existing event with the non-null fields from the updated event
            if (updatedEvent.getName() != null) {
                event.setName(updatedEvent.getName());
            }
            if (updatedEvent.getDescription() != null) {
                event.setDescription(updatedEvent.getDescription());
            }
            if (updatedEvent.getDate() != null) {
                event.setDate(updatedEvent.getDate());
            }
            if(updatedEvent.getStartTime() != null) {
                event.setStartTime(updatedEvent.getStartTime());
            }
            if(updatedEvent.getEndTime() != null) {
                event.setEndTime(updatedEvent.getEndTime());
            }
            if(updatedEvent.getPlace() != null) {
                event.setPlace(updatedEvent.getPlace());
            }
            if(updatedEvent.getCategory() != null) {
                event.setCategory(updatedEvent.getCategory());
            }
            if(updatedEvent.getOrganizer() != null) {
                event.setOrganizer(updatedEvent.getOrganizer());
            }
            eventRepository.save(event);

            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
