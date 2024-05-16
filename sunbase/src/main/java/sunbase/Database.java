package sunbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Database {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/chatbot";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "keerthana";

    public static void saveEmbeddings(List<String> embeddings) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO embeddings (embedding) VALUES (?)")) {
                    for (String embedding : embeddings) {
                        stmt.setString(1, embedding);
                        stmt.executeUpdate();
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
