import java.sql.*;

/**
 *
 * @author postgresqltutorial.com
 */
public class DBConnecter {

    private final String url = "jdbc:postgresql://localhost:5432/zeus";
    private final String user = "postgres";
    private final String password = "Gbhunbu19";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        System.out.println("Connecting...");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public long insert(String data) {
        String SQL = "INSERT INTO readings(id, name, age, email, data) "
                + "VALUES(?,?,?,?,?)";

        long id = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, 1);
            pstmt.setString(2, "2");
            pstmt.setInt(3, 3);
            pstmt.setString(4, "4");
            pstmt.setString(5, "5");

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}