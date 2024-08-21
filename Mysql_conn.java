package bill_calculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql_conn {
 
//    // MySQL 8.0 以下版本 - JDBC driver
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//    static final String DB_URL = "jdbc:mysql://localhost:3306/louis";
 
    // MySQL 8.0 以上版本 - JDBC driver URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    
    //下列字串包含資料庫名稱,依本地修改
    static final String DB_URL = "jdbc:mysql://localhost:3306/db1?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
 
 
//確認先安裝mysql-connector-java.8.0.16.jar
    static final String USER = "root"; //此帳號為本地資料庫的
    static final String PASS = "12345678"; //此密碼為本地資料庫的
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
        
            System.out.println("連接資料庫...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            System.out.println(" Statement 物件...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, url FROM websites"; //此為mysql會收到的指令
            ResultSet rs = stmt.executeQuery(sql);
        
            while(rs.next()){
 
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                System.out.print("ID: " + id);
                System.out.print(", site name: " + name);
                System.out.print(", site URL: " + url);
                System.out.print("\n");
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //  JDBC Exception
            se.printStackTrace();
        }catch(Exception e){
            //  Class.forName Exception
            e.printStackTrace();
        }finally{
            // 收尾動作，釋放資源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("End~~~~!");
    }
}