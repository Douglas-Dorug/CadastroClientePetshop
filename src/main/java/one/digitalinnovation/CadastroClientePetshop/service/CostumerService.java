package one.digitalinnovation.CadastroClientePetshop.service;

import one.digitalinnovation.CadastroClientePetshop.dto.MessageResponseDTO;
import one.digitalinnovation.CadastroClientePetshop.dto.request.CostumerDTO;
import one.digitalinnovation.CadastroClientePetshop.entity.Costumer;
import one.digitalinnovation.CadastroClientePetshop.mapper.CostumerMapper;
import one.digitalinnovation.CadastroClientePetshop.repository.CostumerRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CostumerService {
    private CostumerRepository costumerRepository;

    private final CostumerMapper costumerMapper = CostumerMapper.INSTANCE;

    public CostumerService(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }
    public MessageResponseDTO createCostumer(one.digitalinnovation.CadastroClientePetshop.dto.request.@Valid CostumerDTO costumerDTO){
        Costumer costumerToSave = costumerMapper.toModel(costumerDTO);
        Costumer savedPerson = costumerRepository.save(costumerToSave);
        return MessageResponseDTO
                .builder()
                .message("Created costumer with ID" + savedPerson.getId())
                .build();
    }

    public List<CostumerDTO> listALL(){
        List<Costumer> allCostumer = costumerRepository.findAll();
        return allCostumer.stream()
                .map(costumerMapper::toDTO)
                .collect(Collectors.toList());
    }

}
