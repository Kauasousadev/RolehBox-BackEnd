package edu.kaua.helpencontro.services;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.dto.RolehResponseDTO;
import edu.kaua.helpencontro.models.Roleh;
import edu.kaua.helpencontro.repositories.RolehRepository;
import edu.kaua.helpencontro.services.mapperrequestdto.RolehMapper;
import edu.kaua.helpencontro.services.mapperresponsedto.RolehResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RolehService {

    @Autowired
    private RolehRepository rolehRepository;
    @Qualifier("rolehMapper")
    @Autowired
    private RolehMapper rolehMapper;
    @Autowired
    private RolehResponseMapper rolehResponseMapper;

    public RolehResponseDTO addRoleh(RolehRequestDTO roleh) {
        Roleh newRoleh = rolehMapper.apply(roleh);
        rolehRepository.save(newRoleh);
        RolehResponseDTO rolehResponseDTO = rolehResponseMapper.apply(newRoleh);
        return rolehResponseDTO;
    }

    public boolean deleteRoleh(Long id) {
        if (rolehRepository.existsById(id)) {
            rolehRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
