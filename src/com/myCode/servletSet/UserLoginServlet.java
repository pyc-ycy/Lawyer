package com.myCode.servletSet;//@Software: IntelliJ IDEA
// @Project: Lawyer
//@File:${NAME}
//@Date:2020/1/14
// Author:御承扬
//E-mail:2923616405@qq.com

import com.myCode.DB.DBConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String tel = request.getParameter("tel");
        String account = request.getParameter("account");
        String pwd = request.getParameter("password");
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConn();
        if(conn!=null){
            String sql = "insert into agent(name,sex,tel,acount,password) values(?,?,?,?,?)";
            try{
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,sex);
                ps.setString(3,tel);
                ps.setString(4,account);
                ps.setString(5,pwd);
                int row = ps.executeUpdate();
                ps.close();
                conn.close();
                if(row >0){
                    response.setContentType("text/html");
                    response.getWriter().write("注册成功！3秒后将自动跳转到登录页面，如果没有，请手动！");
                    response.setHeader("refresh","3;url=index.jsp");

                }else{
                    response.setContentType("text/html");
                    response.getWriter().write("注册成功！3秒后将自动跳转到注册页面，如果没有，请手动！");
                    response.setHeader("refresh","3;url=UserLogin.jsp");
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
