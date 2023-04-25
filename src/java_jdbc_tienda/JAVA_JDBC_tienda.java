/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jdbc_tienda;

import java_jdbc_tienda.servicios.FabricanteService;
import java_jdbc_tienda.servicios.ProductoService;

/**
 *
 * @author NICO
 */
public class JAVA_JDBC_tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FabricanteService fs = new FabricanteService();
        ProductoService ps = new ProductoService();       
        
        
        ps.menu();
        
        
    
        
        
        
        
    }
    
}
