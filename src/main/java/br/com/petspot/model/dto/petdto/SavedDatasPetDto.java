package br.com.petspot.model.dto.petdto;

import br.com.petspot.model.entity.Pet.Pet;

import java.util.Date;

public record SavedDatasPetDto(
        String id,
        String name,
        int gender,
        String age
) {
    public SavedDatasPetDto(Pet pet){
        this(pet.getId(), pet.getPetName(), pet.getGender(), pet.getPetBirthday());
    }
}
