package edu.kaua.helpencontro.services;

import edu.kaua.helpencontro.dto.DateDTO;
import edu.kaua.helpencontro.models.Date;
import edu.kaua.helpencontro.repositories.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateService {

    @Autowired
    private DateRepository dateRepository;

    public Date addDate(DateDTO dateDTO) {
        Date date = new Date();

        date.setName(dateDTO.getName());
        date.setDescription(dateDTO.getDescription());
        date.setPrice(dateDTO.getPrice());
        date.setAlcoholic(dateDTO.getAlcoholic() != null && dateDTO.getAlcoholic());
        date.setFood(dateDTO.getFood() != null && dateDTO.getFood());
        date.setPlaceToSit(dateDTO.getPlaceToSit() != null && dateDTO.getPlaceToSit());
        date.setAmbientMusic(dateDTO.getAmbientMusic() != null && dateDTO.getAmbientMusic());
        date.setExercise(dateDTO.getExercise() != null && dateDTO.getExercise());

        dateRepository.save(date);
        if (dateRepository.existsById(date.getId())) {
            return date;
        }else {
            return null;
        }
    }

    public List<Date> getAllDates() {
        List<Date> dates = dateRepository.findAll();

        if (dates.isEmpty()) {
            return null;
        }else {
            return dates;
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
