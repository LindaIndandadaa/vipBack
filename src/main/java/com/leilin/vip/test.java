package com.leilin.vip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test {
    public static void Query() {
        Lock lock = new ReentrantLock();
        Connection connection = null;
        try {
            String SDdriver = "com.mysql.jdbc.Driver";
            String SDurl = "jdbc:mysql://localhost:3307/vipope";
            //emsdb替换成自己的数据库名称
            String SDuser = "root";
            String SDpassword = "123456";
            Class.forName(SDdriver);
            connection = DriverManager.getConnection(SDurl, SDuser, SDpassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String ss = new String("SELECT * from user;");
        try {
            preparedStatement = connection.prepareStatement(ss);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("account"));
            }
        } catch (SQLException ex) {
        } finally {
            closeAll(connection, preparedStatement,resultSet);
        }
    }

    public static void closeAll(Connection connection, PreparedStatement preparedStatement,ResultSet resultSet) {
        try {
            //按顺序关闭
            if(resultSet!=null) {
                resultSet.close();
            }
            if (preparedStatement!=null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Query();

    }

}