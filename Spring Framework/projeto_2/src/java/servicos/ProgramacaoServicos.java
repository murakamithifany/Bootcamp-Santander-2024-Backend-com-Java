package servicos;

import dao.DAO;
import utility.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import modelo.Programacao;

public class ProgramacaoServicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private DAO<Programacao> dao;

    public void salvar(Programacao p) throws NegocioException {
        dao.salvar(p);
    }

    public void remover(Programacao p) throws NegocioException {
//        dao.excluir(p.getIdprogramacao());
    }

    public List<Programacao> listarTodos() {
        return dao.buscarTodos("SELECT p FROM Programacao p");
    }

//    public List<Programacao> listarSemanaAtiva() {
//        return dao.buscarTodos("SELECT  *  FROM Programacao p WHERE p.status = 'S'");
//    }
}
