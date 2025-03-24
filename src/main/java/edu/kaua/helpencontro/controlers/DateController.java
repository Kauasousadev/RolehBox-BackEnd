package edu.kaua.helpencontro.controlers;

import edu.kaua.helpencontro.dto.DateDTO;
import edu.kaua.helpencontro.models.Date;
import edu.kaua.helpencontro.services.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/date")
public class DateController {

    @Autowired
    DateService dateService;

    @PostMapping("/addDate")
    public ResponseEntity<String> addDate(@RequestBody DateDTO date) {
        Date newDate = dateService.addDate(date);
        if (newDate != null) {
            return ResponseEntity.ok("Date added successfully");
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Date>> getAllDate() {
        List<Date> dates = dateService.getAllDates();
        if (dates != null) {
            return ResponseEntity.ok(dates);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDate(@PathVariable int id) {
        if (dateService.deleteDate(id)) {
            return ResponseEntity.ok("Date deleted successfully");
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
