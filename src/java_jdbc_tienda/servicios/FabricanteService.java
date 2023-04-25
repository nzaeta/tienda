/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jdbc_tienda.servicios;

import java.util.Scanner;
import java_jdbc_tienda.entidades.Fabricante;
import java_jdbc_tienda.persistencia.FabricanteDAO;

/**
 *
 * @author NICO
 */
public class FabricanteService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    private FabricanteDAO dao;

    public FabricanteService() {
        this.dao = new FabricanteDAO();
    }
    
    public void crearFabricante() throws Exception {
            String nombreFab;

            System.out.println("Ingrese nombre del Fabricante: ");
            nombreFab = leer.next();
            

            
        try {
            if (nombreFab == null || nombreFab.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del Fabricante");
            }

            //Creamos el fabricante
            Fabricante fabricante = new Fabricante(1,nombreFab);

            dao.guardarFabricante(fabricante);
            System.out.println("FABRICANTE INGRESADO");
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
