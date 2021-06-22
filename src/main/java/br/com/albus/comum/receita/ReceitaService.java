package br.com.albus.comum.receita;

import br.com.albus.generic.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/albus/receita")
public class ReceitaService extends GenericService<ReceitaController, Receita, ReceitaRepository, Long> {

}
