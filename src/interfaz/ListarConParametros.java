package interfaz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import model.jpa.Usuario;

public class ListarConParametros 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Seson01");
		EntityManager em=emf.createEntityManager();
		
		Query q1=em.createQuery("select a from Usuario a where a.usuario=:p1");
		q1.setParameter("p1", JOptionPane.showInputDialog(null,"Ingrese el ID a buscar"));
		List<Usuario>lista1=q1.getResultList();
		for (int i = 0; i < lista1.size(); i++) {
			JOptionPane.showMessageDialog(null, lista1.get(i).getUsuario()+"-"+lista1.get(i).getContrasena()+"-"+lista1.get(i).getDireccion());
		}
	}
}
