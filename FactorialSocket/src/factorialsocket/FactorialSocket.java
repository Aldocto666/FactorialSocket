package FactorialSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FactorialSocket {

    public static void main(String[] args) throws IOException {
        
        String maquinaAceptadora;
        maquinaAceptadora = "127.0.0.1";
        //maquinaAceptadora= InetAddress.getByName(args[0]);
        int puerto=0;
        puerto=1045;
        //puerto= Integer.parseInt(args[1]);
        
        Socket cliente= new Socket(maquinaAceptadora, puerto);
        Scanner teclado= new Scanner(System.in);
        String numero;
        PrintWriter salidaAlServer = new PrintWriter(cliente.getOutputStream());
        
        System.out.println("Teclee un número para calcular su factorial");
        numero=teclado.nextLine();
        
        
        salidaAlServer.write(numero);
        salidaAlServer.close();
        cliente.close();
        
    }
    
}
