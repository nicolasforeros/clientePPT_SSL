/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.autonoma.actores;

import guippt.Login;

/**
 * Clase principal del cliente, se crea el jugador y se habilita el login
 * @author Nicolas Forero Segovia
 * @author Leandra Builes
 * @version 1.1
 */
public class PrincipalJuego {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        System.setProperty("javax.net.ssl.trustStore", "myKeyStore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "hola123");
        
        Jugador jugador = new Jugador();
        
        Login login = new Login(jugador);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        
    }
    
}
