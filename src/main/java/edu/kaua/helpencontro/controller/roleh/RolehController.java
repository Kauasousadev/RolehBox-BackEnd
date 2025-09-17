package edu.kaua.helpencontro.controller.roleh;

import edu.kaua.helpencontro.controller.Valid;
import edu.kaua.helpencontro.dto.ApiResponse;
import edu.kaua.helpencontro.dto.request.roleh.RolehRequestDTO;
import edu.kaua.helpencontro.dto.response.roleh.RolehResponseDTO;
import edu.kaua.helpencontro.dto.response.review.ReviewResponseDTO;
import edu.kaua.helpencontro.services.review.ReviewService;
import edu.kaua.helpencontro.services.roleh.RolehService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roleh")
public class RolehController {

    @Autowired
    private RolehService rolehService;
    @Autowired
    private ReviewService reviewService;

    public RolehController(RolehService rolehService) {
        this.rolehService = rolehService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolehResponseDTO> getRoleById(@PathVariable Long id) {
        return rolehService.getRoleh(id);
    }

    //get all rolês com paginação

    @PostMapping
    public ResponseEntity<RolehResponseDTO> createRoleh(@RequestBody @Valid RolehRequestDTO roleRequestDTO) {
        return rolehService.addRoleh(roleRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        return rolehService.deleteRoleh(id);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<List<ReviewResponseDTO>> reviewsRole(@PathVariable Long id) {
        return reviewService.getAllReviewsByRoleh(id);
    }
}
