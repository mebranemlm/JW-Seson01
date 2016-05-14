package interfaz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.jpa.Usuario;

public class EliminarUsuario
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Seson01");
		EntityManager em=emf.createEntityManager();
		try 
		{
			Usuario objusu=new Usuario();
			objusu=em.find(Usuario.class, JOptionPane.showInputDialog("Ingrese ID a eliminar"));
			em.getTransaction().begin();
			em.remove(objusu);
			em.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Se elimino correctamente");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			em.getTransaction().rollback();
		}
	}
}
