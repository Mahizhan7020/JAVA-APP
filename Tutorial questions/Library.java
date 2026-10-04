import java.sql.*;

public class Library {
    public static void main(String[] args)throws Exception{
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","password");

        PreparedStatement ps=con.prepareStatement("insert into Book values(?,?,?,?,?)");
        ps.setInt(1,101); ps.setString(2,"Java"); ps.setString(3,"James"); ps.setDouble(4,500); ps.setString(5,"Yes");
        ps.executeUpdate();

        ps=con.prepareStatement("select * from Book where BookID=?");
        ps.setInt(1,101); ResultSet rs=ps.executeQuery();
        while(rs.next()) System.out.println(rs.getString("Title"));

        rs=con.createStatement().executeQuery("select * from Book where Availability='Yes'");
        while(rs.next()) System.out.println(rs.getString("Title"));

        ps=con.prepareStatement("update Book set Availability=? where BookID=?");
        ps.setString(1,"No"); ps.setInt(2,101); ps.executeUpdate();

        con.close();
    }
}
