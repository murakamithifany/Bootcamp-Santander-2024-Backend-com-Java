package servicos;

import dao.DAO;
import utility.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import modelo.Alunos;

public class AlunoServicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private DAO<Alunos> dao;

    public void salvar(Alunos a) throws NegocioException {
        dao.salvar(a);
    }

    public void remover(Alunos a) throws NegocioException {
        dao.remover(Alunos.class, a.getIdLong());
    }

    public List<Alunos> listarTodos() {
        return dao.buscarTodos("SELECT a FROM Alunos a order by a.nome");
    }
}
