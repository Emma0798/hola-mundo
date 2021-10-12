/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Editorial;
import Persistencia.Editorial_DAOExt;
import java.util.Scanner;

/**
 *
 * @author Emma
 */
public class EditorialServicio {
    
    private Editorial_DAOExt dao;
    private Scanner leer;

    public EditorialServicio() {
        this.dao = new Editorial_DAOExt();
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public void menueditorial(){
        Guardar();
    }
    
    public void Guardar() {
        try {
            Editorial editorial = new Editorial();
            System.out.println("Ingrese el nombre de la editorial");
            String nombre = leer.next();
            editorial.setNombre(nombre);
            dao.Guardar(editorial);
        } catch (Exception e) {
            throw e;
        }

    }
    public void BuscarPorNombre() throws Exception{
        try {
            Editorial editorial = new Editorial();
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.next();
            editorial=dao.BuscarPorNombre(nombre);
            System.out.println(editorial.toString());
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
