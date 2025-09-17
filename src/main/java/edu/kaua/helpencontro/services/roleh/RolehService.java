package edu.kaua.helpencontro.services.roleh;

import edu.kaua.helpencontro.dto.request.roleh.RolehRequestDTO;
import edu.kaua.helpencontro.dto.response.roleh.RolehResponseDTO;
import edu.kaua.helpencontro.exceptions.ResourceNotFoundException;
import edu.kaua.helpencontro.models.roleh.Roleh;
import edu.kaua.helpencontro.repositories.roleh.RolehRepository;
import edu.kaua.helpencontro.services.mappers.mapperrequestdto.RolehMapper;
import edu.kaua.helpencontro.services.mappers.mapperresponsedto.RolehResponseMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RolehService {

    private RolehRepository rolehRepository;
    private RolehMapper rolehMapper;
    private RolehResponseMapper rolehResponseMapper;

    public RolehService(RolehRepository rolehRepository, RolehMapper rolehMapper, RolehResponseMapper rolehResponseMapper) {
        this.rolehRepository = rolehRepository;
        this.rolehMapper = rolehMapper;
        this.rolehResponseMapper = rolehResponseMapper;
    }

    public ResponseEntity<RolehResponseDTO> getRoleh(Long id) {
        RolehResponseDTO rolehReponseDTO =
                rolehRepository.findById(id)
                .map(rolehResponseMapper::apply)
                .orElseThrow(() -> new ResourceNotFoundException("Rolê não encontrado com id: " + id));
        return ResponseEntity.ok(rolehReponseDTO);
    }

    public ResponseEntity<RolehResponseDTO> addRoleh(RolehRequestDTO rolehRequestDTO) {
        Roleh role = rolehMapper.apply(rolehRequestDTO);
        return ResponseEntity.ok(rolehResponseMapper.apply(rolehRepository.save(role)));
    }

    public ResponseEntity<String> deleteRoleh(Long id) {
        rolehRepository.delete(
                rolehRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rolê não encontrado com id: " + id)));
        return ResponseEntity.ok("Rolê deletado com id: " + id);
    }
}
