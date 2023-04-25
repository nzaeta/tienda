/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jdbc_tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import java_jdbc_tienda.entidades.Producto;
import java_jdbc_tienda.persistencia.ProductoDAO;

/**
 *
 * @author NICO
 */
public class ProductoService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private ProductoDAO dao;

    public ProductoService() {
        this.dao = new ProductoDAO();
    }
    
    public void menu(){
        FabricanteService fs = new FabricanteService();
        
        System.out.println("");
        System.out.println("----- MENU -----");
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Listar nombres de productos");
        System.out.println("2. Listar nombres y precios de productos");
        System.out.println("3. Listar productos con precio entre 120 y 202");
        System.out.println("4. Listar portátiles ");
        System.out.println("5. Ver producto más barato");
        System.out.println("6. Ingresar Producto");
        System.out.println("7. Ingresar Fabricante");        
        System.out.println("8. Editar un Producto");       
        System.out.println("9. Salir del programa");
        System.out.println("");
        String opc = leer.next();
        switch (opc) {
            case "1":
                System.out.println("LISTADO DE PRODUCTOS");
                try {
                    listarProductos();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                System.out.println("===============================================");
                menu();
                break;
            case "2":
                System.out.println("LISTADO DE PRODUCTOS");
                try {
                    listarProductosPrecio();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                System.out.println("===============================================");
                menu();
                break;
            case "3":
                System.out.println("LISTADO DE PRODUCTOS CON PRECIO ENTRE 120 Y 202");
                try {
                    listarProductosCond();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                System.out.println("===============================================");
                menu();
                break;
            case "4":
                System.out.println("LISTADO DE PRODUCTOS QUE CONTIENEN 'Portátil'");
                try {
                    listarProductosContiene();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                System.out.println("===============================================");
                menu();
                break;
            case "5":
                System.out.println("PRODUCTO MÁS BARATO:");
                try {
                    verProductoBarato();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                System.out.println("===============================================");
                menu();
                break;
            case "6":
                System.out.println("INGRESANDO PRODUCTO...");
                try {
                    crearProducto();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                System.out.println("===============================================");
                menu();
                break;
            case "7":
                System.out.println("INGRESANDO FABRICANTE...");
                try {
                    fs.crearFabricante();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                System.out.println("===============================================");
                menu();
                break;
            case "8":
                System.out.println("MODIFICANDO PRODUCTO");
                try {
                    listarProductosPrecio();
                    modificarProducto();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                System.out.println("===============================================");
                
                
                menu();
                break;  
            case "9":
                System.out.println("Ejecución finalizada");
                break;
            default:
                System.out.println("Opción no válida");
                ;
                menu();
        }
        
        
    }
    
 
    public void listarProductos() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            for (Producto aux : productos) {
                System.out.println(aux.getNombre());
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listarProductosPrecio() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            for (Producto aux : productos) {
                System.out.println(aux.getNombre() + " ----- $ " + aux.getPrecio());
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listarProductosCond() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductosCond(120, 202);

            for (Producto aux : productos) {
                System.out.println(aux.getNombre() + " ----- $ " + aux.getPrecio());
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listarProductosContiene() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductosContiene("portátil");

            for (Producto aux : productos) {
                System.out.println(aux.getNombre() + " ----- $ " + aux.getPrecio());
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
     public void verProductoBarato() throws Exception {

        try {

            Collection<Producto> productos = dao.productoBarato();

            for (Producto aux : productos) {
                System.out.println(aux.getNombre() + " ----- $ " + aux.getPrecio());
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void crearProducto() throws Exception {
            String nombreProd;
            double precioProd;
            int fabricante;


            System.out.println("Ingrese código de fabricante: ");
            fabricante = leer.nextInt();          
            
            System.out.println("Ingrese nombre del Producto: ");
            nombreProd = leer.next();
            
            System.out.println("Ingrese precio del Producto: ");
            precioProd = leer.nextDouble();   
            
        try {
            if (nombreProd == null || nombreProd.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del producto");
            }

            //Creamos el producto
            Producto producto = new Producto(1,nombreProd,precioProd,fabricante);

            dao.guardarProducto(producto);
            System.out.println("PRODUCTO INGRESADO");
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarProducto() throws Exception {
        int codigo;
        String nombre;
        double precio;
        int fabricante;
        
            System.out.println("Ingrese código de producto: ");
            codigo = leer.nextInt();        
        
            System.out.println("Ingrese código de fabricante: ");
            fabricante = leer.nextInt();          
            
            System.out.println("Ingrese nombre del Producto: ");
            nombre = leer.next();
            
            System.out.println("Ingrese precio del Producto: ");
            precio = leer.nextDouble();   

        
        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            Producto producto = new Producto(codigo, nombre, precio, fabricante);


            dao.modificarProducto(producto);
            System.out.println("PRODUCTO MODIFICADO");
        } catch (Exception e) {
            throw e;
        }
    }
}
