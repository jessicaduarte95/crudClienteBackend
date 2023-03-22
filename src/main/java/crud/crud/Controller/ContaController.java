package crud.crud.Controller;

import crud.crud.Repository.ContaRepository;
import crud.crud.models.Conta;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/conta/{idConta}")
    public void excluirConta(@PathVariable("idConta") Long idConta){
        contaRepository.deleteById(idConta);
    }

}
