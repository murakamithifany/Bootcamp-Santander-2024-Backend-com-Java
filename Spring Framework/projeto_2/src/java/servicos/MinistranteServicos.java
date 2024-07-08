package servicos;

import dao.DAO;
import utility.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import modelo.Ministrante;

public class MinistranteServicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private DAO<Ministrante> dao;

    public void salvar(Ministrante a) throws NegocioException {
        dao.salvar(a);
    }

    public void remover(Ministrante a) throws NegocioException {
        dao.remover(Ministrante.class, a.getIdLong());
    }

    public List<Ministrante> listarTodos() {
        return dao.buscarTodos("SELECT m FROM Ministrante m order by m.nome");
    }
}
