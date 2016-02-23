package jdbc;

/**
 * Created by 908752 on 2/22/16.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userData1", eager = true)
@SessionScoped
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<Author> getAuthors(){
        ResultSet rs = null;
        PreparedStatement pst = null;

        String stm = "Select * from authors";
        List<Author> records = new ArrayList<>();

        try (Connection con = getConnection()){
            pst = con.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while(rs.next()){
                Author author = new Author();
                author.setId(rs.getInt(1));
                author.setName(rs.getString(2));
                records.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public Connection getConnection(){
        Connection con = null;
        System.out.println("getConnection..");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection
                    ("jdbc:oracle:thin:@localhost:1521/xe", "aristo_owner", "ardvo1");

        } catch (Exception e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return con;
    }
}