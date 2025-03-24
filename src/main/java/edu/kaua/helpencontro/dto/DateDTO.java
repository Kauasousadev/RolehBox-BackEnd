package edu.kaua.helpencontro.dto;

import edu.kaua.helpencontro.models.enums.Price;

public class DateDTO {
    private String name;
    private String description;
    private Price price;
    private Boolean alcoholic;
    private Boolean food;
    private Boolean placeToSit;
    private Boolean ambientMusic;
    private Boolean exercise;

    public DateDTO(String name, String description, Price price, Boolean alcoholic,
                   Boolean food, Boolean placeToSit, Boolean ambientMusic, Boolean exercise) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.alcoholic = alcoholic;
        this.food = food;
        this.placeToSit = placeToSit;
        this.ambientMusic = ambientMusic;
        this.exercise = exercise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Boolean getAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(Boolean alcoholic) {
        this.alcoholic = alcoholic;
    }

    public Boolean getFood() {
        return food;
    }

    public void setFood(Boolean food) {
        this.food = food;
    }

    public Boolean getPlaceToSit() {
        return placeToSit;
    }

    public void setPlaceToSit(Boolean placeToSit) {
        this.placeToSit = placeToSit;
    }

    public Boolean getAmbientMusic() {
        return ambientMusic;
    }

    public void setAmbientMusic(Boolean ambientMusic) {
        this.ambientMusic = ambientMusic;
    }

    public Boolean getExercise() {
        return exercise;
    }

    public void setExercise(Boolean exercise) {
        this.exercise = exercise;
    }
}
