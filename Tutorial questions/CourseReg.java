import java.sql.*;

public class CourseReg {
    public static void main(String[] args)throws Exception{
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","password");
        String code="CS101";

        PreparedStatement ps=con.prepareStatement("select * from CourseRegistration where CourseCode=?");
        ps.setString(1,code);
        ResultSet rs=ps.executeQuery();

        boolean found=false;
        while(rs.next()){
            found=true;
            System.out.println(rs.getString("StudentName")+" "+rs.getString("CourseName"));
        }
        if(!found) System.out.println("No students registered for "+code);

        con.close();
    }
}
