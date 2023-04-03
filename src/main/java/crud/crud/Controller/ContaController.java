package crud.crud.Controller;

import crud.crud.Repository.ContaRepository;
import crud.crud.models.Conta;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class ContaController {

    @Autowired
    ContaRepository contaRepository;

    @PostMapping("/conta")
    public Conta inserirConta(@RequestBody Conta conta){
        return contaRepository.save(conta);
    }
    
    @GetMapping("/conta")
    public List<Conta> listarContas(){return contaRepository.findAll();}

    @GetMapping("/conta/filtro/{cliente}")
    public List<Conta> listarContaPorCliente(@PathVariable Long cliente) {
        return contaRepository.findByClienteIdCliente(cliente);
    }

    @GetMapping("/conta/{idConta}")
    public ResponseEntity<Conta> contaCliente(@PathVariable("idConta") Long idConta){
        Optional<Conta> contaCliente = contaRepository.findById(idConta);

        return new ResponseEntity<Conta>(contaCliente.get(), HttpStatus.OK);
    }

    @DeleteMapping("/conta/{idConta}")
    public void excluirConta(@PathVariable("idConta") Long idConta){
        contaRepository.deleteById(idConta);
    }

    @PutMapping("/conta/{idConta}")
    public ResponseEntity<Conta> alterarConta(@PathVariable("idConta") Long idConta, @RequestBody Conta conta){
        Conta mudarConta = contaRepository.getReferenceById(idConta);

        mudarConta.setNumConta(conta.getNumConta());

        contaRepository.save(mudarConta);

        return new ResponseEntity<Conta>(conta, HttpStatus.OK);
    }
}
