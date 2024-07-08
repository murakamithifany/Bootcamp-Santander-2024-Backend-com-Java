package servicos;

import dao.DAO;
import utility.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import modelo.Semana;

public class SemanaServicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private DAO<Semana> dao;

    public void salvar(Semana s) throws NegocioException {
        dao.salvar(s);
    }

    public void remover(Semana s) throws NegocioException {
        dao.remover(Semana.class, s.getIdLong());
    }

    public List<Semana> listarTodos() {
        return dao.buscarTodos("SELECT s FROM Semana s order by s.nome");
    }
}
