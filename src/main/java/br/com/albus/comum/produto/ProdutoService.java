package br.com.albus.comum.produto;

import br.com.albus.generic.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/albus/produto")
public class ProdutoService extends GenericService<ProdutoController, Produto, ProdutoRepository, Long> {

}
