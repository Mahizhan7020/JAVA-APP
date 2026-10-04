import java.sql.*;

public class Product {
    public static void main(String[] args)throws Exception{
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","password");

        PreparedStatement ps=con.prepareStatement("insert into Product values(?,?,?,?)");
        ps.setInt(1,1); ps.setString(2,"Laptop"); ps.setDouble(3,50000); ps.setInt(4,5); ps.executeUpdate();

        ps=con.prepareStatement("select * from Product where ProductID=?");
        ps.setInt(1,1); ResultSet rs=ps.executeQuery();
        while(rs.next()) System.out.println(rs.getString("ProductName"));

        ps=con.prepareStatement("update Product set Quantity=? where ProductID=?");
        ps.setInt(1,20); ps.setInt(2,1); ps.executeUpdate();

        rs=con.createStatement().executeQuery("select * from Product where Quantity<10");
        while(rs.next()) System.out.println(rs.getString("ProductName"));

        con.close();
    }
}
