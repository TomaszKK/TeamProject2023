package p.lodz.teamproject_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import p.lodz.teamproject_back.model.Schedule;
import p.lodz.teamproject_back.repository.ScheduleRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping
    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
        scheduleRepository.save(schedule);
        return new ResponseEntity<Schedule>(schedule, HttpStatus.CREATED);
    }

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
            // Update the relevant fields of the schedule
            schedule.setDate(updatedSchedule.getDate());
            // Set other fields as needed

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
            // Set the fields of the updated schedule
            updatedSchedule.setDate(newSchedule.getDate());
            // Set other fields as needed

            // Save the updated schedule
            scheduleRepository.save(updatedSchedule);

            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
