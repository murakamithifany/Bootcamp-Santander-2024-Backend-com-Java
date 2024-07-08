package servicos;

import dao.MatriculaDAO;
import utility.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import modelo.Matriculas;

public class Matriculaservicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private MatriculaDAO dao;

    public void salvar(Matriculas s) throws NegocioException {
        dao.salvar(s);
    }

//    public void remover(Matriculas s) throws NegocioException {
//        dao.remover(Matriculas.class, s.getMatriculasPK().getIdalunos());
//    }

    public List<Matriculas> listarTodos() {
        return dao.buscarTodos("SELECT s FROM Semana s order by s.nome");
    }
}
