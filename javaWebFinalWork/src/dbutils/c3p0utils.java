package dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;


public class c3p0utils {
    private static DataSource ds;

    static {
        //实例化
        ComboPooledDataSource c3p0 = new ComboPooledDataSource() ;
            ds =c3p0;
    }
    public  static  DataSource getDataSource(){

        return  ds;
    }
}
