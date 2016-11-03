package factorialsocket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorFactorial {

    public static void main(String[] args) throws IOException {
        int puerto;
        puerto=1045;
        //puerto= Integer.parseInt(args[0]);
        
        ServerSocket Servidor = new ServerSocket(puerto);
        System.out.println("En espera de alguna conexión");
        
        Socket soc = Servidor.accept();
        System.out.println("Conexión establecida");
        int miNum = 0;
        
        Scanner entrada = new Scanner(soc.getInputStream());
        System.out.println("Esperando el número");
        miNum = Integer.parseInt(entrada.nextLine());
        System.out.println("Número recibido: " + miNum);
        
        
            BigInteger f = new BigInteger("1");
            for (int i = 1; i <= miNum; i++) {
                f = f.multiply(new BigInteger(i + ""));
            }
            
            System.out.println("Factorial: "+f);
        
        
        /*
        double factorial=1;
        while ( miNum!=0) {
            factorial=factorial*miNum;
            miNum--;
        }
        
        System.out.println("Factorial: "+factorial);
        
        /*
        String mensaje= Integer.toString(miNum);
        OutputStream flujoSalida;
        flujoSalida = soc.getOutputStream();
        PrintWriter salidaSocket = new PrintWriter(new OutputStreamWriter(flujoSalida));
        salidaSocket.println(mensaje);
        salidaSocket.flush();
*/        

        soc.close();
        
        Servidor.close();
    }
    
}
