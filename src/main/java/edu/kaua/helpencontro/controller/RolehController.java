package edu.kaua.helpencontro.controller;

import edu.kaua.helpencontro.dto.ApiResponse;
import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.Roleh;
import edu.kaua.helpencontro.services.RolehService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roleh")
public class RolehController {

    private RolehService rolehService;

    public RolehController(RolehService rolehService) {
        this.rolehService = rolehService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RolehResponseDTO>> getRoleById(@PathVariable Long id) {
        RolehResponseDTO rolehResponse = rolehService.getRoleh(id);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Rolê encontrado com sucesso", rolehResponse)
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RolehResponseDTO>> createRoleh(@RequestBody @Valid RolehRequestDTO roleRequestDTO) {
        RolehResponseDTO newRole = rolehService.addRoleh(roleRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>(true, "Rolê criado com sucesso", newRole)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRole(@PathVariable Long id) {
        rolehService.deleteRoleh(id);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Rolê deletado com sucesso", null)
        );
    }
}
