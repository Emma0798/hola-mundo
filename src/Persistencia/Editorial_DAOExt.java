/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Editorial;

/**
 *
 * @author Emma
 */
public class Editorial_DAOExt extends DAO{
    
    public void Guardar(Editorial editorial){
        try {
            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }
    public void modificar(Editorial editorial){
        try{
            em.getTransaction().begin();
            em.merge(editorial);
            em.getTransaction().commit();
        }catch(Exception e){
            throw e;
        }
    }
    public void BuscarPorId(Integer id){
        try {
            em.getTransaction().begin();
            em.find(Editorial.class,id);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Editorial BuscarPorNombre(String nombre) throws Exception{   //Usamos la query porque find solo funciona con la clave primaria
        try {
            if(nombre==null){
                throw new Exception ("No ha ingresado ningun nombre");
            }else{
                return em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE '%" + nombre + "%'", Editorial.class).getSingleResult();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
