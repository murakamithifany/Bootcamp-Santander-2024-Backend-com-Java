package bean;

import dao.MatriculaDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Matriculas;
import modelo.Programacao;
import servicos.Matriculaservicos;
import utility.Menssagens;

@Named(value = "beanMatricula")
@SessionScoped
public class MatriculaBean implements Serializable {

    @Inject
    private AlunoBean aluno;

    @Inject
    private Matriculas matricula;

    @Inject
    private Programacao eventoSelecionado;

    @Inject
    private MatriculaDAO dao;

    @Inject
    private Matriculaservicos servicos;

    private List<Matriculas> lista;

    @PostConstruct
    public void carregar() {
        lista = servicos.listarTodos();
    }

    public String realizarInscricao() {
        try {
            
            matricula.setAlunos(aluno.getAlunoAutenticado());
            matricula.setProgramacao(eventoSelecionado);
            matricula.setPresentemanha("N");
            matricula.setPresentetarde("N");
            dao.salvar(matricula);
            lista.add(matricula);
            matricula = new Matriculas();
            carregar();
            Menssagens.info("Registro gravado!");
        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
        return "inicial_aluno.xhtml";

    }

    public AlunoBean getAluno() {
        return aluno;
    }

    public void setAluno(AlunoBean aluno) {
        this.aluno = aluno;
    }


    public Programacao getEventoSelecionado() {
        return eventoSelecionado;
    }

    public void setEventoSelecionado(Programacao eventoSelecionado) {
        this.eventoSelecionado = eventoSelecionado;
    }

    public MatriculaDAO getDao() {
        return dao;
    }

    public void setDao(MatriculaDAO dao) {
        this.dao = dao;
    }

    public List<Matriculas> getLista() {
        return lista;
    }

    public void setLista(List<Matriculas> lista) {
        this.lista = lista;
    }

    public Matriculas getMatricula() {
        return matricula;
    }

    public void setMatricula(Matriculas matricula) {
        this.matricula = matricula;
    }

    public Matriculaservicos getServicos() {
        return servicos;
    }

    public void setServicos(Matriculaservicos servicos) {
        this.servicos = servicos;
    }

    
}
