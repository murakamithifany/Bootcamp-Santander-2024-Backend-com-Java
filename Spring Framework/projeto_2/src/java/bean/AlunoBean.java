package bean;

import utility.Menssagens;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Alunos;
import servicos.AlunoServicos;

@Named(value = "beanAlunos")
@SessionScoped
public class AlunoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Alunos aluno;

    private Alunos alunoAutenticado;

//    @Inject
//    private Alunos logado;
    @Inject
    private AlunoServicos servicos;

    private List<Alunos> lista;

    @PostConstruct
    public void carregar() {
        lista = servicos.listarTodos();
        //alunoAutenticado = new Alunos();
        aluno = new Alunos();
    }

    public String autenticarLogin() {
        String usuario = aluno.getEmail();
        String senha = aluno.getSenha();
        boolean autenticado = false;

        for (Alunos a : lista) {
            if (a.getEmail().equals(usuario) && a.getSenha().equals(senha)) {
                autenticado = true;
                this.alunoAutenticado = a;
                break;
            }
        }

        if (autenticado) {
            Menssagens.info("Usuário autenticado!");
            return "inicial_aluno.xhtml";
        } else {
            Menssagens.erro("Usuário ou senha inválido!");
            return null;
        }
    }

    public String irInicial() {
        limpar();
        return "inicial_aluno.xhtml";
    }

    public String irVoltar() {
        limpar();
        return "principal.xhtml";
    }

    public String irSair() {
        alunoAutenticado = new Alunos();
        return "principal.xhtml";
    }

    public String adicionar() {
        try {
            servicos.salvar(aluno);
            lista.add(aluno);
//            aluno = new Alunos();
            carregar();
            Menssagens.info("Registro gravado!");
        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
        return this.irInicial();
    }

    public void excluir() {
        try {
            servicos.remover(aluno);
            carregar();
            Menssagens.info(aluno.getNome() + " foi removido!...");

        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
    }

    public void editar() {
        try {
            servicos.salvar(alunoAutenticado);
            carregar();
            limpar();
            Menssagens.info("Dados alterados!");
        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
    }

    public void limpar() {
        aluno = new Alunos();
    }

    public Alunos getAluno() {
        return aluno;
    }

    public void setAluno(Alunos aluno) {
        this.aluno = aluno;
    }

    public Alunos getAlunoAutenticado() {
        return alunoAutenticado;
    }

    public void setAlunoAutenticado(Alunos alunoAutenticado) {
        this.alunoAutenticado = alunoAutenticado;
    }

//    public Alunos getLogando() {
//        return logando;
//    }
//
//    public void setLogando(Alunos logando) {
//        this.logando = logando;
//    }
    public AlunoServicos getServicos() {
        return servicos;
    }

    public void setServicos(AlunoServicos servicos) {
        this.servicos = servicos;
    }

    public List<Alunos> getLista() {
        return lista;
    }

    public void setLista(List<Alunos> lista) {
        this.lista = lista;
    }

}
