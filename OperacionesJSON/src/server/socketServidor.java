/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public static void main(String args[]) {
        String datos = "";
        String tipo = "";
        ObjectInputStream entrada = null;
        ObjectOutputStream salida = null;
        JSONObject objetoJson = null;
        float parametro1 = 0;
        float parametro2 = 0;
        float resultado = 0;
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Esperando conexión...");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado!");
            entrada = new ObjectInputStream(cliente.getInputStream());
            System.out.println("Leyendo petición...");
            datos = (String) entrada.readObject();
            objetoJson = new JSONObject(datos);
            tipo = objetoJson.getString("tipo");
            parametro1 = objetoJson.getFloat("param1");
            parametro2 = objetoJson.getFloat("param2");
            switch (tipo) {
                case "+":
                    resultado = parametro1 + parametro2;
                    break;
                case "-":
                    resultado = parametro1 - parametro2;
                    break;
                case "*":
                    resultado = parametro1 * parametro2;
                    break;
                case "/":
                    resultado = parametro1 / parametro2;
            }
            System.out.println("Enviando respuesta...");
            salida = new ObjectOutputStream(cliente.getOutputStream());
            salida.writeObject(resultado + "");
        } catch (IOException ex) {
            System.out.println("Error!: No se pudo inicializar el servidor.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(socketServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
