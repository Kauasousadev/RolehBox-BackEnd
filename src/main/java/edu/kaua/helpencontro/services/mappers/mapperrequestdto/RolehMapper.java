package edu.kaua.helpencontro.services.mappers.mapperrequestdto;

import edu.kaua.helpencontro.dto.request.roleh.RolehRequestDTO;
import edu.kaua.helpencontro.models.roleh.Roleh;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class RolehMapper implements Function<RolehRequestDTO, Roleh> {
    private final CaracteristicasMapper caracteristicasMapper;

    public RolehMapper(CaracteristicasMapper caracteristicasMapper) {
        this.caracteristicasMapper = caracteristicasMapper;
    }

    @Override
    public Roleh apply(RolehRequestDTO rolehRequestDTO) {
        Roleh roleh = new Roleh();

        roleh.setName(rolehRequestDTO.getName());
        roleh.setDescription(rolehRequestDTO.getDescription());
        roleh.setAddress(rolehRequestDTO.getAddress());
        roleh.setPhoneNumber(rolehRequestDTO.getPhoneNumber());
        roleh.setCaracteristicas(caracteristicasMapper.apply(rolehRequestDTO.getCaracteristicas(), roleh));

        return roleh;
    }
}