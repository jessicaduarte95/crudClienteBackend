package crud.crud.Controller;

import crud.crud.Repository.ClienteRepository;
import crud.crud.models.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public List<Cliente> listaClientes(){
        return clienteRepository.findAll();
    }

    @PostMapping("/cliente")
    public Cliente inserirCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @PutMapping("/cliente/{idCliente}")
    public ResponseEntity<Cliente> alterarCliente(@PathVariable("idCliente") Long idCliente, @RequestBody Cliente cliente){
        Cliente mudarCliente = clienteRepository.getReferenceById(idCliente);

        mudarCliente.setCpf(cliente.getCpf());
        mudarCliente.setNome(cliente.getNome());
        mudarCliente.setEndereco(cliente.getEndereco());

        clienteRepository.save(mudarCliente);

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/cliente/{idCliente}")
    public void excluirCliente(@PathVariable("idCliente") Long idCliente){
        clienteRepository.deleteById(idCliente);
    }
}
