import java.sql.*;

public class JDBCExample {
    private static final String URL = "jdbc:postgresql://localhost:5432/D-mart";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Akhil@10";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL , USER , PASSWORD);
            stmt = conn.createStatement();

            String query = "select * from customers";
            rs =  stmt.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("customer_id");
                String name = rs.getString("name");

                System.out.println(id + " " + name);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(rs != null){
                    rs.close();
                }
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }

            }catch (SQLException e){}
        }


    }


}
