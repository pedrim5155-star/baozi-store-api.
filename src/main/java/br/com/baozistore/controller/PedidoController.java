package br.com.baozistore.controller;
import br.com.baozistore.model.Pedido; import br.com.baozistore.repository.PedidoRepository;
import jakarta.validation.Valid; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException; import java.util.List;
@RestController @RequestMapping("/api/pedidos") public class PedidoController {
 private final PedidoRepository repository;
 public PedidoController(PedidoRepository repository) { this.repository=repository; }
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Pedido criar(@Valid @RequestBody Pedido item) { item.setId(null); return repository.save(item); }
 @GetMapping public List<Pedido> listar() { return repository.findAll(); }
 @GetMapping("/{id}") public Pedido buscar(@PathVariable Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado")); }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluir(@PathVariable Long id) { if (!repository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"); repository.deleteById(id); }
}