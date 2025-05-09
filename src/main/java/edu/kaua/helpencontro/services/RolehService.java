package edu.kaua.helpencontro.services;

import edu.kaua.helpencontro.dto.RolehRequestDTO;
import edu.kaua.helpencontro.models.Roleh;
import edu.kaua.helpencontro.models.tagsrole.CaracteristicaRole;
import edu.kaua.helpencontro.repositories.RolehRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RolehService {

    @Autowired
    private RolehRepository rolehRepository;

    public ResponseEntity<String> addRoleh(RolehRequestDTO roleh) {
        Roleh newRoleh = new Roleh();

        newRoleh.setName(roleh.getName());
        newRoleh.setDesc(roleh.getDesc());
        newRoleh.setAddress(roleh.getAddress());
        newRoleh.setPhoneNumber(roleh.getPhoneNumber());

        CaracteristicaRole caracteristicaRole = new CaracteristicaRole();
        RolehRequestDTO.CaracteristicaRequestDTO caracteristicaRequestDTO = new RolehRequestDTO.CaracteristicaRequestDTO();

        caracteristicaRole.setgMapsLink(caracteristicaRequestDTO.getgMapsLink());
        caracteristicaRole.setInstaUser(caracteristicaRequestDTO.getInstaUser());

    }
}
