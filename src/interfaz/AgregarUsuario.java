package interfaz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import javax.swing.JOptionPane;

import model.jpa.Usuario;

public class AgregarUsuario 
{
	public static void main(String[] args) 
	{
		//try{
			//System.out.println("test");
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("Seson01");
			//JOptionPane.showMessageDialog(null, emf);
			System.out.println(emf);
			EntityManager em=emf.createEntityManager();
			//JOptionPane.showMessageDialog(null, em);
			try
			{
				Usuario objusu=new Usuario();
				objusu.setUsuario(JOptionPane.showInputDialog("Ingresar Usuario"));
				objusu.setContrasena(JOptionPane.showInputDialog("Ingrese Clave"));
				objusu.setDireccion(JOptionPane.showInputDialog("Ingrese direccion"));
				em.getTransaction().begin();
				em.persist(objusu);
				em.getTransaction().commit();
			}
			catch(Exception e)
			{
				em.getTransaction().rollback();
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		/*}catch(Exception f){
			JOptionPane.showMessageDialog(null, f.getMessage());
		}*/
	}
}