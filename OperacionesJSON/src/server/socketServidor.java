/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author EduardoDev
 */
public class socketServidor {
    public static void main(String args[]){
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Esperando conexión...");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado!");
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            System.out.println("Leyendo mensaje...");
            System.out.println((String)entrada.readObject());
            
            // JSON
            JSONObject obj = new JSONObject("{\"name\": \"John\"}");

System.out.println(obj.getString("name")); //John

        } catch (IOException ex) {
            System.out.println("Error!: No se pudo inicializar el servidor.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(socketServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
