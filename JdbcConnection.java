import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class JdbcConnection
{
    Scanner sc=new Scanner(System.in);
    void insert1() {
        System.out.println("Enter how many record store from Student ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {

            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                String databaseurl = "jdbc:mysql://localhost:3306/jdbc_db";
                String userName = "root";
                String password1 = "arjun";
                //class.forName("com.mysql.cj.jdbc.Driver");


                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "arjun");

                //System.out.println("database connected : " + con);

                System.out.println("Enter the data from Student ");
                System.out.println("Enter name,email,password,gender,city of " + i + 1 + " Student");
                String name = sc.next();
                String email = sc.next();
                String password = sc.next();
                String gender = sc.next();
                String city = sc.next();


                PreparedStatement ps = con.prepareStatement("insert into register3 values('" + name + "','" + email + "','" + password + "','" + gender + "','" + city + "')");
                int r = ps.executeUpdate();
                if (r > 0) {
                    System.out.println("successful insert ");
                } else {
                    System.out.println("Fail to insert");
                }

            } catch (Exception p) {
                System.out.println("Exception : " + p);
            }

        }
    }

    void update1()
    {
        Scanner sc=new Scanner(System.in);
        try
        {
            System.out.println("Enter the new city to be update of student ");
            String city=sc.next();
            System.out.println("Enter the email for conformation  ");
            String email=sc.next();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","arjun");
            PreparedStatement ps=con.prepareStatement("update register3 set city=? where email=?");
            ps.setString(1,city);
            ps.setString(2,email);
            int c=ps.executeUpdate();
            if(c>0)
            {
                System.out.println("Updated successfuly");
            }
            else
            {
                System.out.println("Fail in update");
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception occured "+e);
        }
    }

    void Delete11()
    {
        try
        {
            System.out.println("Enter email for be delete the record : ");
            String email=sc.next();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","arjun");
            PreparedStatement ps=con.prepareStatement("delete from register3 where email=?");
            ps.setString(1,email);
            int c=ps.executeUpdate();
            if(c>0)
            {
                System.out.println("Updated successfuly");
            }
            else
            {
                System.out.println("Fail in update");
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception occured "+e);
        }
    }


    void Select()
    {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","arjun");
            PreparedStatement ps=con.prepareStatement("select * from register3 ");
            ResultSet rs =ps.executeQuery();

            System.out.println("Name     Email         Password       Gender       City");
            while(rs.next())
            {
                String name1=rs.getString("name");
                String email1=rs.getString("email");
                String pass1=rs.getString("password");
                String gender1=rs.getString("gender");
                String city1=rs.getString("city");
                //System.out.println(name1+"\t"+email1+"\t\t"+pass1+"\t"+gender1+"\t"+city1);
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception occured "+e);
        }
    }
}

public class jdbcConnectionSwitch
{
    public static void main(String[] args)
    {
        while(1==1)
        {
            try {
                Scanner sc = new Scanner(System.in);
                operations oop = new operations();
                System.out.println("1.Insert Data");
                System.out.println("2.Update Record ");
                System.out.println("3.Delete record ");
                System.out.println("4.Show record");
                System.out.println("5.Exit");
                System.out.print("Enter your choice : ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        oop.insert1();
                        break;

                    case 2:
                        oop.update1();
                        break;

                    case 3:
                        oop.Delete11();
                        break;
                    case 4:
                        oop.Select();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid choice please enter the correct chpice ");
                }
            } catch (Exception e) {
                System.out.println();
            }
        }

    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            