import java.sql.*;
import java.util.Scanner;

public class Baitap {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Biatap","root",""
                );
                Statement stmt =conn.createStatement();
        )
        {
            String sqlInsert = "insert into danhsach values(6,'Quy nho',19,120000)";
            System.out.println("The sql statement is : "+sqlInsert +"\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted+" records inserted.\n");

            String sqlDelete = "delete from danhsach where id=5 or Ten='Trang'";
            System.out.println("The sql statement is: "+sqlDelete+"\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted+" records deleted.\n");

            String sqlUpdate = "Update danhsach where set qty=qty+2000 where id=1";
            System.out.println("the sql statement is: "+sqlUpdate+"\n");
            int countUpdate = stmt.executeUpdate(sqlUpdate);
            System.out.println(countUpdate +" records affected.\n");

            //seacrh id
             Scanner scID = new Scanner(System.in);
             System.out.println("Enter id: ");
             String id = scID.nextLine();
             System.out.println("ID is: "+id);
             String findbyid = "SELECT * FROM danhsach where id like '%"+id+"'";
             System.out.println(findbyid);
             //search Ten
             Scanner scTen = new Scanner(System.in);
             System.out.println("Enter ten: ");
             String Ten = scTen.nextLine();
             System.out.println("Ten is:"+Ten);
             String findbyten = "Select * from danhsach where Ten like'%"+Ten+"'";
             System.out.println(findbyten);
             //search tuoi
            Scanner scTuoi = new Scanner(System.in);
            System.out.println("Enter tuoi: ");
            String tuoi = scTuoi.nextLine();
            System.out.println("Tuoi is:"+tuoi);
            String findbytuoi = "Select * from danhsach where Tuoi like'%"+tuoi+"'";
            System.out.println(findbytuoi);
            //seacrh qty
            Scanner scQTY = new Scanner(System.in);
            System.out.println("Enter qty: ");
            String qty = scTen.nextLine();
            System.out.println("qty is:"+qty);
            String findbyqty = "Select * from danhsach where qty like'%"+qty+"'";
            System.out.println(findbyqty);

             String query[] = {findbyid, findbyten,findbytuoi,findbyqty};
             for(String q:query)
             {
                 ResultSet resultSet3 = stmt.executeQuery(q);
                 System.out.println("Search "+q+"is(id,Ten,tuoi,qty): ");
                 while(resultSet3.next())
                 {
                     id = resultSet3.getString("id");
                     Ten  = resultSet3.getString("Ten");
                     tuoi = resultSet3.getString("tuoi");
                     qty = resultSet3.getString("qty");
                     System.out.println("ID: "+id+", Ten: "+Ten+",Tuoi: "+tuoi+",Qty: "+qty);
                 }
                 System.out.println("\n");
             }

            ResultSet rset  = stmt.executeQuery("select * from danhsach");
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColumns = rsetMD.getColumnCount();

            for(int i=1;i<=numColumns;++i)
            {
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();

            for(int i =1;i<=numColumns;++i)
            {
                System.out.printf("%-30s", "("+rsetMD.getColumnClassName(i)+")");
            }
            System.out.println();

            while(rset.next())
            {
                for (int i=1;i<= numColumns;++i)
                {
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println();
            }


        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
