package edu.kaua.helpencontro.services;

import edu.kaua.helpencontro.dto.DateDTO;
import edu.kaua.helpencontro.models.Roleh;
import edu.kaua.helpencontro.repositories.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateService {

    @Autowired
    private DateRepository dateRepository;

    public Roleh addDate(DateDTO dateDTO) {
        Roleh roleh = new Roleh();

        roleh.setName(dateDTO.getName());
        roleh.setDescription(dateDTO.getDescription());
        roleh.setPrice(dateDTO.getPrice());
        roleh.setAlcoholic(dateDTO.getAlcoholic() != null && dateDTO.getAlcoholic());
        roleh.setFood(dateDTO.getFood() != null && dateDTO.getFood());
        roleh.setPlaceToSit(dateDTO.getPlaceToSit() != null && dateDTO.getPlaceToSit());
        roleh.setAmbientMusic(dateDTO.getAmbientMusic() != null && dateDTO.getAmbientMusic());
        roleh.setExercise(dateDTO.getExercise() != null && dateDTO.getExercise());

        dateRepository.save(roleh);
        if (dateRepository.existsById(roleh.getId())) {
            return roleh;
        }else {
            return null;
        }
    }

    public List<Roleh> getAllDates() {
        List<Roleh> rolehs = dateRepository.findAll();

        if (rolehs.isEmpty()) {
            return null;
        }else {
            return rolehs;
        }
    }

    public boolean deleteDate(int dateId) {
        if (dateRepository.existsById(dateId)) {
            dateRepository.deleteById(dateId);
            return true;
        }else {
            return false;
        }
    }
}
