package br.com.soften.crud.controller;

import br.com.soften.crud.models.entities.Client;
import br.com.soften.crud.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    // Basicamente esse trecho de código serve para que mais informações sejam entreguem no header,
    // levando de maneira muito mais ordenada o endpoint e cód status por exemplo, resolvi implementar
    // por curiosidade e pretendo continuar trabalhando no projeto
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Client data, @RequestParam long user) {
        Client cad = clientService.save(data, user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/save").buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).body(cad);
    }
    // Pretendia passar essa lógica para o service, mas vou deixar aqui por enquanto por falta de tempo
    @GetMapping("/find")
    public ResponseEntity<?> find(@RequestParam(required = false) Long id, @RequestParam(required = false) String name) {
        if (id != null) {
            Client obj = clientService.find(id);
            return ResponseEntity.ok(obj);
        } else if(name != null) {
            List<Client> obj = clientService.find(name);
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.badRequest().body("not found");
    }

    // ainda tenho dúvida se realmente devo retornar uma mensagem e não um cód https
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.ok("Client id " + id + " erased");
    }

    @GetMapping("findbyname/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        List<Client> obj = clientService.findByName(name);
        return ResponseEntity.ok(obj);
    }

    // muito útil no postman, pensei em remover mas acho que pode não tem problema usar
    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }
}
