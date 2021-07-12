package one.digitalinnovation.CadastroClientePetshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String street;

    @NotEmpty
    @Size(min = 1, max = 10)
    private String number;

    @Size(min = 1, max = 150)
    private String reference;
}
