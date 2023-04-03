package crud.crud.Repository;

import crud.crud.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    List<Conta> findByClienteIdCliente(Long cliente);
}
