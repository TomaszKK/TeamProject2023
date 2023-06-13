package p.lodz.teamproject_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import p.lodz.teamproject_back.message.response.ResponseMessage;
import p.lodz.teamproject_back.model.Event;
import p.lodz.teamproject_back.model.Schedule;
import p.lodz.teamproject_back.model.User;
import p.lodz.teamproject_back.repository.EventRepository;
import p.lodz.teamproject_back.repository.ScheduleRepository;
import p.lodz.teamproject_back.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private ScheduleRepository scheduleRepository;
    private UserRepository userRepository;
    private EventRepository eventRepository;

    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepository, UserRepository userRepository, EventRepository eventRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow();
    }

//    @PostMapping
//    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule, @RequestParam Long userId, @RequestParam Long eventId) {
//        schedule.setUser(userRepository.findById(userId).orElseThrow());
//        schedule.setEventList((List<Event>) eventRepository.findById(eventId).orElseThrow());
//        scheduleRepository.save(schedule);
//        return new ResponseEntity<Schedule>(schedule, HttpStatus.CREATED);
//    }

    @DeleteMapping
    public ResponseEntity<Schedule> deleteAllSchedules() {
        scheduleRepository.deleteAll();
        return new ResponseEntity<Schedule>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Schedule> deleteScheduleById(@PathVariable("id") long id) {
        scheduleRepository.deleteById(id);
        return new ResponseEntity<Schedule>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule updatedSchedule) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            scheduleRepository.save(schedule);
            return new ResponseEntity<>(schedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> replaceSchedule(@PathVariable Long id, @RequestBody Schedule newSchedule) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            // Delete the existing schedule
            scheduleRepository.delete(schedule);

            // Create a new schedule with the same ID
            Schedule updatedSchedule = new Schedule();
            updatedSchedule.setId(id);

            // Save the updated schedule
            scheduleRepository.save(updatedSchedule);

            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/{id}/events/{eventId}")
    public ResponseEntity<?> addEvent(@RequestBody Event event, @PathVariable("id") long userId, @PathVariable("eventId") long eventId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> User not found"), HttpStatus.NOT_FOUND);
        }

        User user = userOptional.get();
        Schedule schedule = user.getSchedule();

        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (eventOptional.isEmpty()) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Event not found"), HttpStatus.NOT_FOUND);
        }

        Event foundEvent = eventOptional.get();
        schedule.addEvent(foundEvent);

        scheduleRepository.save(schedule);

        return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
    }

}
