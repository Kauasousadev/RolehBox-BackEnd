package edu.kaua.helpencontro.services.mappers.mapperresponsedto;

import edu.kaua.helpencontro.dto.response.roleh.RolehResponseDTO;
import edu.kaua.helpencontro.models.roleh.Roleh;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class RolehResponseMapper implements Function<Roleh, RolehResponseDTO> {


    private final CaracteristicasResponseMapper caracteristicasResponseMapper;

    public RolehResponseMapper(CaracteristicasResponseMapper caracteristicasMapper) {
        this.caracteristicasResponseMapper = caracteristicasMapper;
    }


    @Override
    public RolehResponseDTO apply(Roleh roleh) {
        RolehResponseDTO rolehResponseDTO = new RolehResponseDTO();

        rolehResponseDTO.setName(roleh.getName());
        rolehResponseDTO.setDescription(roleh.getDescription());
        rolehResponseDTO.setAddress(roleh.getAddress());
        rolehResponseDTO.setPhoneNumber(roleh.getPhoneNumber());

        rolehResponseDTO.setCaracteristicas(caracteristicasResponseMapper.apply(roleh.getCaracteristicas()));

        return rolehResponseDTO;
    }
}
