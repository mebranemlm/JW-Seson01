package interfaz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.jpa.Usuario;

public class ModificarUsuario 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Seson01");
		EntityManager em=emf.createEntityManager();
		try 
		{
			Usuario objusu=new Usuario();
			objusu=em.find(Usuario.class, JOptionPane.showInputDialog("Ingrese Id a modificar"));
			objusu.setContrasena(JOptionPane.showInputDialog("Ingrese nueva clave"));
			objusu.setDireccion(JOptionPane.showInputDialog("Ingrese nueva direccion"));
			em.getTransaction().begin();
			em.merge(objusu);
			em.getTransaction().commit();
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			em.getTransaction().rollback();
		}
	}
}
