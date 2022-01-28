package one.digitalinnovation.CadastroClientePetshop.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.CadastroClientePetshop.dto.MessageResponseDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.CostumerDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.PetDTO;
import one.digitalinnovation.CadastroClientePetshop.exception.CostumerNotFoundException;
import one.digitalinnovation.CadastroClientePetshop.exception.PetNotFoundException;
import one.digitalinnovation.CadastroClientePetshop.service.CostumerService;
import one.digitalinnovation.CadastroClientePetshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/petshop")
public class PetsController {

    private CostumerService costumerService;

    private PetService petService;

    @PostMapping("/pets")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPet(@RequestBody @Valid PetDTO petDTO) throws CostumerNotFoundException {
        return petService.createPet(petDTO);
    }

    @GetMapping("/pets/{id}")
    public PetDTO findById(@PathVariable Long id) throws PetNotFoundException {
        return petService.findById(id);
    }


}