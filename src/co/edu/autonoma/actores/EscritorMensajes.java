/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.autonoma.actores;

import java.io.IOException;
import java.io.StringWriter;
import org.json.simple.JSONObject;

/**
 *
 * @author nikof
 */
public class EscritorMensajes {
    String nombreJugador;
    JSONObject obj;

    public EscritorMensajes() {
        this.nombreJugador = null;
        
        this.obj = new JSONObject();
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.obj.put("jugador", this.nombreJugador);
    }

    String escribirMensaje(int jugada) {
        this.obj.put("jugada", jugada);
        
        StringWriter out = new StringWriter();
        
        try {
            obj.writeJSONString(out);
        } catch (IOException ex) {
            System.out.println("ESCRITOR MENSAJE=> error realizando el mensaje: " + ex.getMessage());
        }

        String jsonText = out.toString();
        
        return jsonText;
    }
    
}
