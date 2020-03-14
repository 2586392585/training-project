package cn.eight.trainingproject.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 李侍尧
 * @create 2020-03-14 14:47
 */
public class Dbpool {

    private static ComboPooledDataSource ds;
    static {
        ds = new ComboPooledDataSource();
        Properties properties = new Properties();
        try {
            properties.load(Dbpool.class.getClassLoader().getResourceAsStream("db.properties"));
            ds.setDriverClass(properties.getProperty("driverName"));
            ds.setUser(properties.getProperty("username"));
            ds.setPassword(properties.getProperty("password"));
            ds.setJdbcUrl(properties.getProperty("url"));
            ds.setInitialPoolSize(Integer.valueOf(properties.getProperty("InitialPoolSize")));
            ds.setMaxPoolSize(Integer.valueOf(properties.getProperty("MaxPoolSize")));
            ds.setMinPoolSize(Integer.valueOf(properties.getProperty("MinPoolSize")));
            ds.setMaxIdleTime(Integer.valueOf(properties.getProperty("MaxIdleTime")));
            ds.setMaxStatements(Integer.valueOf(properties.getProperty("MaxStatements")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
