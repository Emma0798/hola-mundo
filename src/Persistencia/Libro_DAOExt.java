/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Libro;

import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Emma
 */
public class Libro_DAOExt extends DAO {

    public void Guardar(Libro libro) {
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar(Libro libro) {
        try {
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    public Libro BuscarPorId(Long isbn) throws Exception {
        try {
            if (isbn == null) {
                throw new Exception("No se ha ingresado ningun id");
            }
            em.getTransaction().begin();
            Libro libro = em.find(Libro.class, isbn);  //Asignamos un objeto tipo libro al registro recuperado por id
            em.getTransaction().commit();
            return libro;
        } catch (Exception e) {
            throw e;
        }
    }

    public Libro BuscaPorNombre(String nombre) throws Exception {
        try {
            if (nombre == null) {
                throw new Exception("No se ha ingresado ningun nombre");

            } else {
                return em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE '%" + nombre + "%'", Libro.class).getSingleResult();
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Libro> BuscarPorAutor(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("No se ha ingresado ningun autor");
            } else {
                Query query = em.createQuery("SELECT l FROM Libro l WHERE l.autor.id = "+id);
                List<Libro> listlibro = (List<Libro>) query.getResultList();
                return listlibro;
            }
 
        } catch (Exception e){
            throw e;
        }
        
    }
    
    
}
