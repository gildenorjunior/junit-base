package integracao.bancodedados.contatos;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import integracao.bancodedados.ContatoModel;
import integracao.bancodedados.ContatoRepository;

//run with rodará com o spring runner, que suporta testes de integração de interfaces

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContatosRepositoryIntegrationTest {

	@Autowired
	private ContatoRepository contatoRepository;
	
	private ContatoModel contato;
	
	@Before
	public void start() {
		 contato = new ContatoModel("Gabriel", "011y", "9xxxxxxxx9");
	}
	
	//regra, não aceita exceções
	@Rule
	public ExpectedException esperadaExcecao = ExpectedException.none();
	
	
	@Test
	public void salvarComTelNulo() throws Exception{
		esperadaExcecao.expect(ConstraintViolationException.class);
		esperadaExcecao.expectMessage("O Telefone deve ser preenchido");
		
		//forçando vazio para testar
		contato.setTelefone(null);
		//tetando salvar o vazio
		contatoRepository.save(contato);
	}
}