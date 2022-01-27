package one.digitalinnovation.CadastroClientePetshop.repository;

import one.digitalinnovation.CadastroClientePetshop.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PetRepository extends JpaRepository<Pet, Long> {


}
