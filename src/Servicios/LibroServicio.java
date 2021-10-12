
package Servicios;


import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import Persistencia.Autor_DAOExt;
import Persistencia.Editorial_DAOExt;
import Persistencia.Libro_DAOExt;
import java.util.List;
import java.util.Scanner;


public class LibroServicio {

    private final Scanner leer;
    private final Libro_DAOExt dao;
    private final Autor_DAOExt daoau;
    private final Editorial_DAOExt edao;

    public LibroServicio() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.dao = new Libro_DAOExt();
        this.daoau = new Autor_DAOExt();
        this.edao = new Editorial_DAOExt();
    }

    public void menuLibro() throws Exception {

        //PublicarLibro();
        //ModificarLibro();
        //BuscarPorId();
        //BuscarPorNombre();
        BuscarPorAutor();
    }

    public Libro PublicarLibro() throws Exception {  //Ver como meter autor y editorial en el objeto
        try {
            Libro libro = new Libro();
            System.out.println("Ingrese el titulo del libro");
            String titulo = leer.next();
            libro.setTitulo(titulo);
            System.out.println("Ingrese el año de publicacion");
            Integer anio = leer.nextInt();
            libro.setAnio(anio);
            System.out.println("Ingrese los ejemplares");
            Integer ejemplares = leer.nextInt();
            libro.setEjemplares(ejemplares);
            System.out.println("Ingrese los ejemplares prestados");
            Integer prestados = leer.nextInt();
            libro.setEjemplaresPrestados(prestados);
            Integer restantes = ejemplares - prestados;
            System.out.println("Ejemplares restantes: " + restantes);
            libro.setEjemplaresRestantes(restantes);
            
            //Ingresamos el autor
            Autor autor=new Autor();
            
            System.out.println("Ingrese el nombre de un autor");
            String nombreautor=leer.next();
            autor=daoau.BuscarPorNombre(nombreautor);
            
            libro.setAutor(autor);
            
            //Ingresamos la editorial
            Editorial editorial = new Editorial();
            
            System.out.println("Ingrese el nombre de la editorial");
            String nombreditorial = leer.next();
            editorial = edao.BuscarPorNombre(nombreditorial);
            
            libro.setEditorial(editorial);
            
            dao.Guardar(libro);

            return libro;
        } catch (Exception e) {
            throw e;
        }
    }

    public void ModificarLibro() throws Exception {      //Falta autor y entidad
        try {
            Libro libro = new Libro();
            System.out.println("Ingrese el id del libro a modificar");
            Long id = leer.nextLong();
            libro = dao.BuscarPorId(id);
            Integer option;
            do {
                System.out.println("¿Que desea modificar de " + libro.getTitulo() + "?");
                System.out.println("1)Titulo\n2)Año de publicacion\n3)Ejemplares prestados\n4)Ejemplares\n5)Salir");
                option = leer.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Ingrese el titulo del libro");
                        String titulo = leer.next();
                        libro.setTitulo(titulo);
                        break;
                    case 2:
                        System.out.println("Ingrese el año de publicacion");
                        Integer anio = leer.nextInt();
                        libro.setAnio(anio);
                        break;
                    case 3:
                        System.out.println("Ingrese los ejemplares prestados");
                        Integer prestados = leer.nextInt();
                        libro.setEjemplaresPrestados(prestados);
                        Integer restantes = libro.getEjemplares() - prestados;
                        System.out.println("Ejemplares restantes: " + restantes);
                        libro.setEjemplaresRestantes(restantes);
                        break;
                    case 4:
                        System.out.println("Ingrese los ejemplares");
                        Integer ejemplares = leer.nextInt();
                        libro.setEjemplares(ejemplares);
                        break;
                    case 5:
                        System.out.println("Adios");
                        break;
                }
            } while (option != 5);

            dao.modificar(libro);
        } catch (Exception e) {
            throw e;
        }

    }

    public void BuscarPorId() throws Exception {
        try {
            Libro libro = new Libro();
            System.out.println("Ingrese el id del libro para buscar");
            Long id = leer.nextLong();
            libro = dao.BuscarPorId(id);
            System.out.println(libro.toString());
        } catch (Exception e) {
            throw e;
        }
    }

    public void BuscarPorNombre() throws Exception {
        try {
            Libro libro = new Libro();
            System.out.println("Ingrese el nombre del libro a buscar");
            String nombre = leer.next();
            libro = dao.BuscaPorNombre(nombre);
            System.out.println(libro.toString());
        } catch (Exception e) {
            throw e;
        }

    }
    
    
    public void BuscarPorAutor() throws Exception{
        try {
            System.out.println("Ingrese el nombre del autor");
            
            String nombre = leer.next();
            Autor autor = new Autor();
            autor= daoau.BuscarPorNombre(nombre);
            System.out.println(autor.getId());
            List<Libro> libros = dao.BuscarPorAutor(autor.getId());
            
            
            for (Libro aux : libros) {
                System.out.println(aux.toString());
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
}
