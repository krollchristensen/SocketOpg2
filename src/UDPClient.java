// UDPClient.java
import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] buffer = "Hello Server".getBytes();
            InetAddress address = InetAddress.getByName(hostname);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(packet);

            byte[] responseBuffer = new byte[512];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server response: " + response);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}