package bean;

import utility.Menssagens;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Administadores;
import servicos.AdmServicos;

@Named(value = "beanAdms")
@SessionScoped
public class AdministradorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Administadores adm;

    private Administadores admAutenticado;

    @Inject
    private AdmServicos servicos;

    private List<Administadores> lista;

    @PostConstruct
    public void carregar() {
        lista = servicos.listarTodos();
    }

    public String autenticar() {
        String user = adm.getLogin();
        String password = adm.getSenha();
        boolean autenticado = false;
        carregar();

        for (Administadores a :lista) {
            if (a.getLogin().equals(user) && a.getSenha().equals(password)) {
                autenticado = true;
                this.admAutenticado = a; 
                break; 
            }
        }

        if (autenticado) {
            Menssagens.info("Usuário autenticado!");
             this.admAutenticado = new Administadores();
            return "inicial_adm.xhtml";       
        } else {
            Menssagens.erro("Usuário ou senha inválido!");
            return null; 
        }
    }

    public String irInicial() {
        limpar();
        return "inicial_adm.xhtml";
    }

    public String irVoltar() {
        limpar();
        return "principal.xhtml";
    }

    public void limpar() {
        adm = new Administadores();
    }

    public Administadores getAdm() {
        return adm;
    }

    public void setAdm(Administadores adm) {
        this.adm = adm;
    }

    public Administadores getAdmAutenticado() {
        return admAutenticado;
    }

    public void setAdmAutenticado(Administadores admAutenticado) {
        this.admAutenticado = admAutenticado;
    }

    public AdmServicos getServicos() {
        return servicos;
    }

    public void setServicos(AdmServicos servicos) {
        this.servicos = servicos;
    }

    public List<Administadores> getLista() {
        return lista;
    }

    public void setLista(List<Administadores> lista) {
        this.lista = lista;
    }



}
