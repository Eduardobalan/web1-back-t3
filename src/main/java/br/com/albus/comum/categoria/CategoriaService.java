package br.com.albus.comum.categoria;

import br.com.albus.generic.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/albus/categoria")
public class CategoriaService extends GenericService<CategoriaController, Categoria, CategoriaRepository, Long> {

}
