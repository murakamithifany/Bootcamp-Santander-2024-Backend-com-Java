package servicos;

import dao.DAO;
import dao.GerenciadorConexao;
import utility.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import modelo.Administadores;

public class AdmServicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private DAO<Administadores> dao;

    public void salvar(Administadores a) throws NegocioException {
        dao.salvar(a);
    }

    public void remover(Administadores a) throws NegocioException {
        dao.remover(Administadores.class, a.getIdLong());
    }

    public List<Administadores> listarTodos() {
        return dao.buscarTodos("SELECT a FROM Administadores a");
    }

}
