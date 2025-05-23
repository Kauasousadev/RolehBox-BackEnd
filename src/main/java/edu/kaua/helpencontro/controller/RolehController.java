package edu.kaua.helpencontro.controller;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.Roleh;
import edu.kaua.helpencontro.services.RolehService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roleh")
public class RolehController {

    @Autowired
    private RolehService rolehService;

    @GetMapping("/{id}")
    public ResponseEntity<RolehResponseDTO> getRoleh(@PathVariable Long id) {
        return ResponseEntity.ok(rolehService.getRoleh(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRoleh(@RequestBody @Valid RolehRequestDTO rolehRequestDTO) {
        try {
            RolehResponseDTO savedRoleh = rolehService.addRoleh(rolehRequestDTO);
            return ResponseEntity.ok(savedRoleh);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> delRoleh(@PathVariable Long id) {
        if (rolehService.deleteRoleh(id)){
            return ResponseEntity.ok().body("Roleh deletado com sucesso");
        }else{
            return ResponseEntity.badRequest().body("Erro ao deletar roleh");
        }
    }
}
