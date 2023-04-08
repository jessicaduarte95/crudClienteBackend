package crud.crud.Controller;


import crud.crud.Repository.MovimentacaoRepository;
import crud.crud.models.Movimentacao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class MovimentacaoController {

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @PostMapping("/movimentacao")
    public Movimentacao inserirMovimentacao(@RequestBody Movimentacao movimentacao){return movimentacaoRepository.save(movimentacao);}

    @GetMapping("/movimentacao/filtro/{conta}")
    public List<Movimentacao> listarMovimentacao(@PathVariable Long conta){
        return movimentacaoRepository.findByContaIdConta(conta);
    }

}
