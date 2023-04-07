package crud.crud.Controller;


import crud.crud.Repository.MovimentacaoRepository;
import crud.crud.models.Movimentacao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class MovimentacaoController {

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @PostMapping("/movimentacao")
    public Movimentacao inserirMovimentacao(@RequestBody Movimentacao movimentacao){return movimentacaoRepository.save(movimentacao);}

}
