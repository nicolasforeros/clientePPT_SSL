/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.autonoma.redes;

import co.edu.autonoma.actores.InterpreteMensajes;
import co.edu.autonoma.interfaces.InterfazJuego;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Realiza y gestiona la recepcion de mensajes
 *
 * @author Nicolas Forero
 * @author Leandra Builes
 */
public class RedEntrada extends Thread{
    
    //AGREGAR NOMBRE DE JUGADOR
    private String nombreJugador;
    
    private DataInputStream in;
    private InterfazJuego juego;
    private InterpreteMensajes interpreteMensajes;
    
    public RedEntrada(){
        this.interpreteMensajes = new InterpreteMensajes();
    }
    
    /**
     * espera por un mensaje del servidor y posteriormente lo envia al interprete
     */
    @Override
    public void run(){
        
        System.out.println("RED ENTRADA => empezando hilo");
        this.interpreteMensajes.setJuego(this.juego);
        this.interpreteMensajes.setNombreJugador(this.nombreJugador);
        
        while(true){
            
            try {
                String mensajeIn = in.readUTF();
                System.out.println("RED ENTRADA=> se recibió el mensaje " + mensajeIn);
                
                this.interpreteMensajes.interpretarMensaje(mensajeIn);
            } catch (IOException ex) {
                System.out.println("RED ENTRADA=> error en la recepción de mensajes " + ex.getMessage());
                break;
            }
            
        }
        
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public void setJuego(InterfazJuego panel) {
        this.juego = panel;
    }
    
    public void setNombreJugador(String nombre){
        this.nombreJugador = nombre;
    }
    
}
