package bean;

import utility.Menssagens;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Semana;
import servicos.SemanaServicos;

@Named(value = "beanSemana")
@SessionScoped
public class SemanaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Semana semana;

    @Inject
    private SemanaServicos servicos;

    private List<Semana> lista;

    @PostConstruct
    public void carregar() {
        lista = servicos.listarTodos();
    }

    public String irInicial() {
        limpar();
        return "inicial_adm.xhtml";
    }

    public String irLista() {
        limpar();
        return "lista_semana.xhtml";
    }

    public String adicionar() {
        try {
            servicos.salvar(semana);
            lista.add(semana);
            semana = new Semana();
            carregar();
            Menssagens.info("Registro gravado!");
        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
        return this.irLista();
    }

    public void excluir() {
        try {
            servicos.remover(semana);
            carregar();
            Menssagens.info(semana.getNome() + " foi removido!...");

        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
    }

    public void editar() {
        try {
            servicos.salvar(semana);
            carregar();
            limpar();
            Menssagens.info("Dados alterados!");
        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
    }

    public void limpar() {
        semana = new Semana();
    }

    public Semana getSemana() {
        return semana;
    }

    public void setSemana(Semana semana) {
        this.semana = semana;
    }

    public SemanaServicos getServicos() {
        return servicos;
    }

    public void setServicos(SemanaServicos servicos) {
        this.servicos = servicos;
    }

    public List<Semana> getLista() {
        return lista;
    }

    public void setLista(List<Semana> lista) {
        this.lista = lista;
    }

}
