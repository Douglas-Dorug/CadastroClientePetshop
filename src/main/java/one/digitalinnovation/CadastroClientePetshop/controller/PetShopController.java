package one.digitalinnovation.CadastroClientePetshop.controller;

import one.digitalinnovation.CadastroClientePetshop.dto.MessageResponseDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.CostumerDTO;
import one.digitalinnovation.CadastroClientePetshop.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/petshop")
public class PetShopController {

    private CostumerService costumerService;

    @Autowired
    public void setCostumerService(CostumerService costumerService){
        this.costumerService = costumerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCostumer(@RequestBody @Valid CostumerDTO costumerDTO){
        return costumerService.createCostumer(costumerDTO);
    }

    public List<CostumerDTO> listAll(){
        return costumerService.listALL();

    }

}
