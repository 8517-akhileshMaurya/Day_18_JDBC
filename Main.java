import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        DbFUnctions db = new DbFUnctions();
        Connection conn = db.connect_to_db("Tut_db" , "postgres" , "Akhil@10");
        //db.createTable(conn , "Employee");
//        db.insert_row(conn , "Employee" , "Akhilesh" , "Mumbai");
//        db.insert_row(conn , "Employee" , "Aditya" , "Kokan nagar" );
//        db.insert_row(conn, "Employee" , "Nikhil" , "sahayadri Nager");

//          db.update_name(conn , "Employee" , "Smit" , "Shubham" );
//            db.search_by_name(conn , "Employee" , "Shubham");
//            System.out.println();
//          db.read_data(conn, "Employee" );

           db.delete_row_by_name(conn , "Employee" , "Shubham");
           db.read_data(conn, "Employee" );


    }
}