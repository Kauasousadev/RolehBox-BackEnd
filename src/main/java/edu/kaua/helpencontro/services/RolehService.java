package edu.kaua.helpencontro.services;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.models.Roleh;
import edu.kaua.helpencontro.models.tagsrole.CaracteristicaRole;
import edu.kaua.helpencontro.repositories.RolehRepository;
import edu.kaua.helpencontro.services.mapperdto.RolehMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Optional;

@Service
public class RolehService {

    @Autowired
    private RolehRepository rolehRepository;
    @Qualifier("rolehMapper")
    @Autowired
    private RolehMapper rolehMapper;

    public Roleh addRoleh(RolehRequestDTO roleh) {
        Roleh newRoleh = rolehMapper.apply(roleh);
        rolehRepository.save(newRoleh);
        return newRoleh;
    }
}
