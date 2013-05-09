package net.gregio.hibernate;

import java.util.List;

import net.gregio.hibernate.model.Pessoa;

import org.hibernate.Session;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
@Path("/pessoas")
public class PessoaController {

	private Session session;

	public PessoaController(Session session) {
		this.session = session;
	}

	public void lista() {
		List<Pessoa> pessoas = session.createCriteria(Pessoa.class).list();

		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}

	}

	@Path("salva")
	public void adiciona() {
		Pessoa p = new Pessoa();
		p.setNome("Guilherme");

		session.save(p);

	}
}