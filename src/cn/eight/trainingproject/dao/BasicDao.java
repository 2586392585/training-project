package cn.eight.trainingproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasicDao {
    public ResultSet execQuery(Connection con, PreparedStatement pst,Object...params){
        ResultSet rs = null;
        try {
            if(params!=null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i+1,params[i]);
                }
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void execUpdate(Connection con, PreparedStatement pst,Object...params) throws SQLException {
            if(params != null){
             for (int i = 0; i < params.length; i++) {
                 pst.setObject(i+1,params[i]);
             }
         }
         pst.executeUpdate();
    }

       public void releaseResource(ResultSet rs,PreparedStatement pst,Connection con){
        try {
            if(rs != null){
                rs.close();
            }
            if(pst != null){
                pst.close();
            }
            if(con != null){
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
