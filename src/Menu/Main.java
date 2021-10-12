
/*
4) Generar las tablas con JPA
5) Crear servicios previamente mencionados.
6) Crear los métodos para persistir entidades en la base de datos librería
7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
8) Búsqueda de un Autor por nombre.
9) Búsqueda de un libro por ISBN.
10) Búsqueda de un libro por Título.
11) Búsqueda de un libro/s por nombre de Autor.
12) Búsqueda de un libro/s por nombre de Editorial.
13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.
*/
package Menu;

import Servicios.AutorServicio;
import Servicios.EditorialServicio;
import Servicios.LibroServicio;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        LibroServicio ls = new LibroServicio();
        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        
        System.out.println("Con que tabla desea trabajar");
        System.out.println("1)Libros\n2)Autores\n3)Editoriales");
        Integer option=leer.nextInt();
        switch(option){
            case 1: ls.menuLibro();
                break;
            case 2: as.menuAutor();
                break;
            case 3: es.menueditorial();
                break;
                        
        }
    }
    
}
