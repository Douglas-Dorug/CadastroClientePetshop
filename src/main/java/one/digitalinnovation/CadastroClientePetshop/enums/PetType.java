package one.digitalinnovation.CadastroClientePetshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PetType {

    DOG("Dog"),
    CAT("Cat"),
    OTHERS("Others");


    private final String description;
}
