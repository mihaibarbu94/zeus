public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        DBConnecter connecter = new DBConnecter();
        connecter.connect();
        connecter.insert("HEi");
        Data data = new Data();
        Server server = new Server();
        server.run();
    }
}