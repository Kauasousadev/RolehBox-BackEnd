package edu.kaua.helpencontro.services;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.dto.exceptions.ResourceNotFoundException;
import edu.kaua.helpencontro.models.Roleh;
import edu.kaua.helpencontro.repositories.roleh.RolehRepository;
import edu.kaua.helpencontro.services.mapperrequestdto.RolehMapper;
import edu.kaua.helpencontro.services.mapperresponsedto.RolehResponseMapper;
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

    public RolehResponseDTO getRoleh(Long id) {
        return rolehRepository.findById(id)
                .map(rolehResponseMapper::apply)
                .orElseThrow(() -> new ResourceNotFoundException("Role não encontrada com id: " + id));
    }

    public RolehResponseDTO addRoleh(RolehRequestDTO roleh) {
        Roleh role = rolehMapper.apply(roleh);
        Roleh savedRole = rolehRepository.save(role);
        return rolehResponseMapper.apply(savedRole);
    }

    public void deleteRoleh(Long id) {
        Roleh role = rolehRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role não encontrada com id: " + id));
        rolehRepository.delete(role);
    }
}
