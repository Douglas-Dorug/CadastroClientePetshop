package one.digitalinnovation.CadastroClientePetshop.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.CadastroClientePetshop.dto.MessageResponseDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.CostumerDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.PetDTO;
import one.digitalinnovation.CadastroClientePetshop.entity.Costumer;
import one.digitalinnovation.CadastroClientePetshop.entity.Pet;
import one.digitalinnovation.CadastroClientePetshop.exception.CostumerNotFoundException;
import one.digitalinnovation.CadastroClientePetshop.exception.PetNotFoundException;
import one.digitalinnovation.CadastroClientePetshop.mapper.PetMapper;
import one.digitalinnovation.CadastroClientePetshop.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetService {

    private PetRepository petRepository;

    private final PetMapper petMapper = PetMapper.INSTANCE;

    public MessageResponseDTO createPet(one.digitalinnovation.CadastroClientePetshop.dto.request.@Valid PetDTO petDTO){
        Pet petToSave = petMapper.toModel(petDTO);
        Pet savedPet = petRepository.save(petToSave);
        return createMessageResponse(savedPet.getId(),"Created pet with ID ");
    }

    public PetDTO findById(Long id) throws PetNotFoundException {
        Pet pet = verifyIfExists(id);
        return petMapper.toDTO(pet);
    }


    private Pet verifyIfExists(Long id) throws  PetNotFoundException{
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}