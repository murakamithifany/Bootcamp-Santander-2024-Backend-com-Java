package bean;

import utility.Menssagens;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Programacao;
import org.primefaces.event.SelectEvent;
import servicos.ProgramacaoServicos;

@Named(value = "beanProgramacao")
@SessionScoped
public class ProgramacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Programacao programacao;

    @Inject
    private ProgramacaoServicos servicos;

    private List<Programacao> lista;
    private List<Programacao> listaAtiva;

    @PostConstruct
    public void carregar() {
        lista = servicos.listarTodos();
//        listaAtiva = servicos.listarSemanaAtiva();
    }

    public String irInicial() {
        limpar();
        return "inicial_adm.xhtml";
    }

    public String irLista() {
        limpar();
        return "lista_programacao.xhtml";
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Selecionado", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String adicionar() {
        try {
            servicos.salvar(programacao);
            lista.add(programacao);
            listaAtiva.add(programacao);
            programacao = new Programacao();
            carregar();
            Menssagens.info("Registro gravado!");
        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
        return this.irLista();
    }

    public void excluir() {
        try {
            servicos.remover(programacao);
            carregar();
            Menssagens.info(programacao.getNome() + " foi removido!...");

        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
    }

    public void editar() {
        try {
            servicos.salvar(programacao);
            carregar();
            limpar();
            Menssagens.info("Dados alterados!");
        } catch (Exception e) {
            Menssagens.erro(e.getMessage());
        }
    }

    public void limpar() {
        programacao = new Programacao();
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    public ProgramacaoServicos getServicos() {
        return servicos;
    }

    public void setServicos(ProgramacaoServicos servicos) {
        this.servicos = servicos;
    }

    public List<Programacao> getLista() {
        return lista;
    }

    public void setLista(List<Programacao> lista) {
        this.lista = lista;
    }

    public List<Programacao> getListaAtiva() {
        return listaAtiva;
    }

    public void setListaAtiva(List<Programacao> listaAtiva) {
        this.listaAtiva = listaAtiva;
    }


    
    
}
