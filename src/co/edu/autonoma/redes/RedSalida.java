/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.autonoma.redes;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author nikof
 */
public class RedSalida {
    private DataOutputStream out;
    
    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public void enviarMensaje(String mensajeEnviar) {
        try {
            out.writeUTF(mensajeEnviar);
            
            out.flush();
        } catch (IOException ex) {
            System.out.println("RED SALIDA=> Error enviando el mensaje al servidor");
        }
    }
}
