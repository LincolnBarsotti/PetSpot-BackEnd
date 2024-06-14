package br.com.petspot.service.pet;

import br.com.petspot.model.dto.petdto.AllDatasPetDto;
import br.com.petspot.model.dto.petdto.RegisterPetDto;
import br.com.petspot.model.dto.petdto.SavedDatasPetDto;

import br.com.petspot.model.messages.pet.MessageAllDatasPetDto;
import br.com.petspot.model.messages.pet.MessageListPageablePetDto;
import br.com.petspot.model.messages.pet.MessageRegisterPetDto;

import br.com.petspot.model.entity.Pet.Pet;
import br.com.petspot.repository.PersonRepository;
import br.com.petspot.repository.PetRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity<MessageListPageablePetDto> listPetByOwner(String tutor, Pageable page){
        return ResponseEntity.ok(
                new MessageListPageablePetDto(
                        petRepository.findAllByPersonIdPerson(tutor,page).map(AllDatasPetDto::new)
                )
        );
    }

    public ResponseEntity<MessageAllDatasPetDto> specificDataOfPetByID(String param){
        Pet pet = petRepository.getReferenceById(param);
        return ResponseEntity.ok(new MessageAllDatasPetDto(new AllDatasPetDto(pet)));
    }

    public ResponseEntity<MessageRegisterPetDto> registerPet(@Valid RegisterPetDto petDto, String tutor, UriComponentsBuilder uriBuilder){

        var owner =  personRepository.getReferenceById(tutor);

        Pet pet = new Pet(petDto);
        petRepository.save(pet);

        owner.getPet().add(pet);
        personRepository.save(owner);

        var uri = uriBuilder.path("pet/{id}").buildAndExpand(pet.getId()).toUri();

        return ResponseEntity.created(uri).body(new MessageRegisterPetDto(new SavedDatasPetDto(pet)));
    }

}
