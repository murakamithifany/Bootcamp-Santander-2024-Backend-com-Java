
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *   Esta classe tem por objetivo criar um EntityManagerFactory que seja global
 *   para todas as outras classes do projeto e a partir desse EntityManagerFactory
 *   gerar várias EntityManager
 * 
 *   @author Andre
 */
public class GerenciadorConexao {
    
    // definindo um EntityManagerFactoty "Global" (static)
    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getFabrica()
    {
        // verifica se a fábrica não existe
        if(emf == null)
        {
            // cria uma EntityManagerFactory e associa a emf
            emf = Persistence.createEntityManagerFactory("projeto_2PU");
        }
        return emf;
    }
    
    public static EntityManager getGerente()
    {
        // retorna uma entitmanager a partir da fábrica existente
        return getFabrica().createEntityManager();
    }
    
}