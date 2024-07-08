package bean;

import utility.Menssagens;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Ministrante;
import org.primefaces.event.SelectEvent;
import servicos.MinistranteServicos;

@Named(value = "beanMinistrante")
@SessionScoped
public class MinistranteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Ministrante ministrante;

    @Inject
    private MinistranteServicos servicos;

    private List<Ministrante> lista;

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
        return "lista_ministrante.xhtml";
    }

     public String adicionar() {
        try {
            servicos.salvar(ministrante);
            lista.add(ministrante);
            ministrante = new Ministrante();
            carregar();
            Menssagens.info("Registro gravado!");
        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
        return this.irLista();
    }

    public void excluir() {
        try {
            servicos.remover(ministrante);
            carregar();
            Menssagens.info(ministrante.getNome() + " foi removido!...");

        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
    }

    public void editar() {
        try {
            servicos.salvar(ministrante);
            carregar();
            limpar();
            Menssagens.info("Dados alterados!");
        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
    }

    public void limpar() {
        ministrante = new Ministrante();
    }

    public Ministrante getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(Ministrante ministrante) {
        this.ministrante = ministrante;
    }

    public MinistranteServicos getServicos() {
        return servicos;
    }

    public void setServicos(MinistranteServicos servicos) {
        this.servicos = servicos;
    }

    public List<Ministrante> getLista() {
        return lista;
    }

    public void setLista(List<Ministrante> lista) {
        this.lista = lista;
    }
}
