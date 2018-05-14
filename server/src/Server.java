import java.io.DataInputStream;
import java.net.*;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    // DEFAULT IP
    public static String SERVER_IP;
    // DESIGNATE A PORT
    public static Map<InetAddress, Socket> clientIPs = new ConcurrentHashMap<>();
    //public static List<Socket> clixentIPs = new CopyOnWriteArrayList<>();
    public static final int SERVER_PORT = 8084;
    private String receivedMessage;


    public static ServerSocket serverSocket;

    public void run() {
        try {
            SERVER_IP = getLocalIpAddress();
            if (SERVER_IP != null) {

                serverSocket = new ServerSocket(SERVER_PORT);
                System.out.println("Server created! " + "IP: " + SERVER_IP +
                        " PORT: "
                        + SERVER_PORT);
                while (true) {
                    // LISTEN FOR INCOMING CLIENTS
                    final Socket client = serverSocket.accept();
                    clientIPs.put(client.getInetAddress(), client);


                    DataInputStream DIS = new DataInputStream(client.getInputStream());
                    receivedMessage     = DIS.readUTF();
                    System.out.println("RECEIVED MESSAGE: " + receivedMessage);
                }
            } else {
                System.out.println("Couldn't detect internet connection.");
            }
        } catch (Exception e) {
            System.out.println("Motherfucker server closed");
            e.printStackTrace();
        }

    }

    // GETS THE IP ADDRESS OF YOUR PHONE'S NETWORK
    public static String getLocalIpAddress() throws UnknownHostException {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        // print the IP Address of your machine (inside your local network)
                        System.out.println(InetAddress.getLocalHost().getHostAddress());

                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            System.out.println();
            System.out.println("ServerActivity" + ex.toString());
        }
        return null;
    }

}
