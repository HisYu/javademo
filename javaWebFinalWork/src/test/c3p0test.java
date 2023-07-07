package test;
import bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import Dao.UserDao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class c3p0test {
    public static  void main(String[] args) {
        try {
            DatabaseMetaData ds = null;
            Connection connection = ds.getConnection();
            System.out.println(connection);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        UserDao userdao = new UserDao();
        User hy = userdao.findUserByName("hy");
        if (hy == null){
            System.out.println("空");
        }
else {
            System.out.println(hy.getUsername());
        }
    }

}
