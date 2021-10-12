/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Autor;
import Persistencia.Autor_DAOExt;
import java.util.Scanner;

/**
 *
 * @author Emma
 */
public class AutorServicio {

    private Autor_DAOExt dao;
    private Scanner leer;

    public AutorServicio() {
        this.dao = new Autor_DAOExt();
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public void menuAutor() throws Exception{
        
        //Guardar();
        BuscarPorNombre();
    }

    public void Guardar() {
        try {
            Autor autor = new Autor();
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.next();
            autor.setNombre(nombre);
            dao.Guardar(autor);
        } catch (Exception e) {
            throw e;
        }

    }
    public void BuscarPorNombre() throws Exception{
        try {
            Autor autor = new Autor();
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.next();
            autor=dao.BuscarPorNombre(nombre);
            System.out.println(autor.toString());
        } catch (Exception e) {
            throw e;
        }
    }
}
