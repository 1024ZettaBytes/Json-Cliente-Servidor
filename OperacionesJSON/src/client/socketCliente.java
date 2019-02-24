/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author EduardoDev
 */
public class socketCliente {

    public static void main(String args[]) {
        ObjectInputStream entrada = null;
        ObjectOutputStream salida = null;
        String datos = "";
        String respuesta="";
        try {
            System.out.println("Conectándose a servidor...");
            Socket servidor = new Socket("localhost", 12345);
            System.out.println("Leyendo archivo...");
            salida = new ObjectOutputStream(servidor.getOutputStream());
            datos = new String(Files.readAllBytes(Paths.get("op.json")));
            salida.writeObject(datos);
            System.out.println("Petición enviada!");
            System.out.println("Esperando respuesta...");
            entrada = new ObjectInputStream(servidor.getInputStream());
            respuesta=(String)entrada.readObject();
            System.out.println("Respuesta recibida: "+respuesta);
            salida.close();
            servidor.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(socketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
