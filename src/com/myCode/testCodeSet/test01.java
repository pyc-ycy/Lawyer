//IntelliJ IDEA
//Lawyer
//test01
//2020/1/13
// Author:御承扬
//E-mail:2923616405@qq.com

package com.myCode.testCodeSet;

import java.sql.*;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        String account;
        String pwd;
        String pwdTemp = "";
        String errorMsg = "";
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名：");
        account = in.next();
        System.out.println("请输入密码：");
        pwd = in.next();
        in.close();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/lawyer?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "root19537";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            String sql = "select * from agent";
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next())
                {
                    String s = rs.getString("acount");
                    if(s.equals(account))
                    {
                        pwdTemp = rs.getString("password");
                        break;
                    }
                    else
                    {
                        errorMsg="用户未注册！";
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pwd.equals(pwdTemp)){
            System.out.println(account+"登录成功！欢迎");
        }else{
            System.out.println("pwdTemp"+pwdTemp);
            System.out.println("msg:"+errorMsg);
        }

    }
}
