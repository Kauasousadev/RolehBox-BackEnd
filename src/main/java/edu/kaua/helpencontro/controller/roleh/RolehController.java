package edu.kaua.helpencontro.controller.roleh;

import edu.kaua.helpencontro.controller.Valid;
import edu.kaua.helpencontro.dto.ApiResponse;
import edu.kaua.helpencontro.dto.request.roleh.RolehRequestDTO;
import edu.kaua.helpencontro.dto.request.rolehsearch.SearchRequest;
import edu.kaua.helpencontro.dto.response.roleh.RolehResponseDTO;
import edu.kaua.helpencontro.dto.response.review.ReviewResponseDTO;
import edu.kaua.helpencontro.models.roleh.Roleh;
import edu.kaua.helpencontro.repositories.roleh.RolehRepository;
import edu.kaua.helpencontro.services.mappers.mapperresponsedto.RolehResponseMapper;
import edu.kaua.helpencontro.services.review.ReviewService;
import edu.kaua.helpencontro.services.roleh.RolehService;
import edu.kaua.helpencontro.services.search.RolehSpecification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roleh")
@Tag(name = "Rolês", description = "Gerenciador de Rolês")
public class RolehController {

    private final RolehService rolehService;
    private final ReviewService reviewService;
    private final RolehRepository rolehRepository;
    private final RolehResponseMapper rolehResponseMapper;

    public RolehController(RolehService rolehService, ReviewService reviewService, RolehRepository rolehRepository, RolehResponseMapper rolehResponseMapper) {
        this.rolehService = rolehService;
        this.reviewService = reviewService;
        this.rolehRepository = rolehRepository;
        this.rolehResponseMapper = rolehResponseMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolehResponseDTO> getRoleById(@PathVariable Long id) {
        return rolehService.getRoleh(id);
    }

    //get all rolês com paginação
    @GetMapping
    public ResponseEntity<List<RolehResponseDTO>> getAllRoles(Pageable pageable) {
        return rolehService.getAllRoleh(pageable);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RolehResponseDTO>> search(@RequestBody SearchRequest searchRequest) {
        Specification<Roleh> spec = Specification.where(
                RolehSpecification.comNome(searchRequest.getName()))
                .and(RolehSpecification.comTipoComida(searchRequest.getTiposComida()))
                .and(RolehSpecification.comTipoMusica(searchRequest.getTiposMusica()))
                .and(RolehSpecification.comTipoAcessibilidade(searchRequest.getTiposAcessibilidade()))
                .and(RolehSpecification.comOutrasTags(searchRequest.getOutrasTags()))
                .and(RolehSpecification.comTipoLocal(searchRequest.getTipoLocal()))
                .and(RolehSpecification.comPrecoEntre(searchRequest.getMinPrice(), searchRequest.getMaxPrice()));

        List<Roleh> resultados = rolehRepository.findAll(spec);
        List<RolehResponseDTO> resultadosDTO = resultados.stream()
                .map(rolehResponseMapper)
                .toList();

        return ResponseEntity.ok(resultadosDTO);
    }

    @PostMapping
    @Operation(summary = "Cadastrar rolês", description = "Utilizando o rolerequest, cadastra um novo role")
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
