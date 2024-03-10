/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package paola.image;
import java.io.*;
import java.net.*;
/**
 *
 * @author paola
 */
public class Image {

    public static void main(String[] args) {
        String hostName = "localhost";
        int portNumber = 65432;

        try (
            Socket socket = new Socket(hostName, portNumber);
            OutputStream out = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream("src/sources/Bimbo.png");
        ) {
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
            System.out.println("La imagen ha sido enviada.");
        } catch (UnknownHostException e) {
            System.err.println("No se conoce el host: " + hostName);
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error al intentar enviar la imagen: " + e.getMessage());
            System.exit(1);
        } 
    }

    
}
