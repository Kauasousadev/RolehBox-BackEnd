package edu.kaua.helpencontro.controller;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.models.Roleh;
import edu.kaua.helpencontro.services.RolehService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roleh")
public class RolehController {

    @Autowired
    private RolehService rolehService;

    @PostMapping("/add")
    public ResponseEntity<?> addRoleh(@RequestBody @Valid RolehRequestDTO rolehRequestDTO) {
        try {
            Roleh savedRoleh = rolehService.addRoleh(rolehRequestDTO);
            return ResponseEntity.ok(savedRoleh);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
