/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Autor;

/**
 *
 * @author Emma
 */
public class Autor_DAOExt extends DAO {
    
    public void Guardar(Autor autor){
        try {
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }
    public void modificar(Autor autor){
        try{
            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();
        }catch(Exception e){
            throw e;
        }
    }
    public Autor BuscarPorNombre(String nombre) throws Exception{   //Usamos la query porque find solo funciona con la clave primaria
        try {
            if(nombre==null){
                throw new Exception ("No ha ingresado ningun nombre");
            }else{
                return em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE '%" + nombre + "%'", Autor.class).getSingleResult();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    /*
    public List<Autor> listar (){
        Query q = em.createQuery("SELECT a FROM Autor a");
        List<Autor> au = (List<Autor>) q.getResultList();
        return au; 
    } 
    Para retornar todos los autores
    */
}
