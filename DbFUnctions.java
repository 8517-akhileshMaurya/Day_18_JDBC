import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFUnctions {
    public Connection connect_to_db(String dbname , String username , String pass){
           Connection con = null;

           try{
           Class.forName("org.postgresql.Driver");
           con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname , username , pass );
           if(con!=null){
               System.out.println("Connection is Established ");
           }
           else {
               System.out.println("Connection failed");
           }
           }catch (Exception e)
           {
               System.out.println(e);
           }
           return con;
    }

    //----> Create
    public void createTable(Connection conn , String table_name){
        Statement statement;
        try{
            String query = "create table " + table_name + "(empid SERIAL primary key , name varchar(20) , Address varchar(20))";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        }catch (Exception e){
            System.out.println("ex");
        }
    }

    //--> Insert
    public void insert_row(Connection conn ,String table_name ,  String name , String add){
        Statement statement;
        try{
            String query = String.format("insert into %s(name , address ) values ('%s' , '%s');" ,  table_name,name,add );

            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("values inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //-->Read
    public void read_data(Connection conn , String table_name){
        Statement statement;
        ResultSet rs = null;
        try{
         String query = String.format("select * from %s" , table_name);
         statement = conn.createStatement();
         rs = statement.executeQuery(query);
         while (rs.next()){
             System.out.print(rs.getString("empid")+" ");
             System.out.print(rs.getString("name")+ " ");
             System.out.print(rs.getString("Address")+" ");
             System.out.println();
         }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //--> Update
    public void update_name(Connection conn, String Table_name , String old_name , String new_name){
    Statement statement;
    try{
        String quarry = String.format("Update %s set name = '%s' where name = '%s'" , Table_name , new_name , old_name);
        statement = conn.createStatement();
        statement.executeUpdate(quarry);
        System.out.println("Updated sucesufully");

    }catch (Exception e){
        System.out.println(e);
    }
    }

    //--> Search  by name
    public void search_by_name(Connection conn , String table_name , String name){
    Statement statement;
    ResultSet rs = null;
    try{
        String quarry = String.format("Select * from %s where name  = '%s'" , table_name , name);
        statement = conn.createStatement();
        rs = statement.executeQuery(quarry);

        while (rs.next()){
            System.out.print(rs.getString("empid")+" ");
            System.out.print(rs.getString("name")+" ");
            System.out.print(rs.getString("Address")+" ");
            System.out.println();
        }

    }catch (Exception e){
        System.out.println(e);
    }
  }

    public void delete_row_by_name(Connection conn , String table_name , String name){
        Statement statement;
        try{
            String quarry = String.format("Delete from %s where name = '%s'", table_name , name);
            statement = conn.createStatement();
            statement.executeUpdate(quarry);

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
