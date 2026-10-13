package br.com.baozistore.controller;
import br.com.baozistore.model.Produto; import br.com.baozistore.repository.ProdutoRepository;
import jakarta.validation.Valid; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException; import java.util.List;
@RestController @RequestMapping("/api/produtos") public class ProdutoController {
 private final ProdutoRepository repository;
 public ProdutoController(ProdutoRepository repository) { this.repository=repository; }
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Produto criar(@Valid @RequestBody Produto item) { item.setId(null); return repository.save(item); }
 @GetMapping public List<Produto> listar() { return repository.findAll(); }
 @GetMapping("/{id}") public Produto buscar(@PathVariable Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")); }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluir(@PathVariable Long id) { if (!repository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"); repository.deleteById(id); }
}