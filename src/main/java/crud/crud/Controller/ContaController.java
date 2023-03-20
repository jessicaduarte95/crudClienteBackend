package crud.crud.Controller;

import crud.crud.Repository.ContaRepository;
import crud.crud.models.Conta;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
