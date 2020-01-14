package com.myCode.servletSet;//@Software: IntelliJ IDEA
// @Project: Lawyer
//@File:${NAME}
//@Date:2020/1/14
// Author:御承扬
//E-mail:2923616405@qq.com

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
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/lawyer?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "root19537";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url,username,password);
        }catch(SQLException e){
            e.printStackTrace();
        }
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
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head><title>注册结果</title></head>");
                    out.println("<body>");
                    out.println("<center>");
                    out.println("<h3>注册成功</h3>");
                    out.println("<a href=\"index.jsp\">返回登录界面</a>");
                    out.println("</center>");
                    out.println("</body>");
                    out.println("</html>");
                    out.flush();
                    out.close();
                }else{
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head><title>注册结果</title></head>");
                    out.println("<body>");
                    out.println("<center>");
                    out.println("<h3>注册失败</h3>");
                    out.println("<a href=\"UserLogin.jsp\">返回注册界面</a>");
                    out.println("</center>");
                    out.println("</body>");
                    out.println("</html>");
                    out.flush();
                    out.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
