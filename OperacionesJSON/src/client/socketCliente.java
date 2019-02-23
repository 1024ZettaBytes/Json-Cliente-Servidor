/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author EduardoDev
 */
public class socketCliente {
    public static void main(String args[]){
        try {
            System.out.println("Conectándose a servidor...");
            Socket servidor = new Socket("localhost", 12345);
            ObjectOutputStream salida = new ObjectOutputStream(servidor.getOutputStream());
            File archivo = new File("C:\\Users\\EduardoDev\\Desktop\\p.txt");
            
            
            System.out.println("Enviando mensaje...");
            salida.writeObject("EPALEEE");
            System.out.println("Mensaje enviado!");
            salida.close();
            servidor.close();
        } catch (IOException ex) {
            System.out.println("Error!: No se pudo establecer una conexion con el servidor especificado.");
        }
    }
}
