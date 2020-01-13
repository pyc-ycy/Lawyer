package com.myCode.servletSet;
//@Software: IntelliJ IDEA
// @Project: Lawyer
//@File:${NAME}
//@Date:2020/1/12
// Author:御承扬
//E-mail:2923616405@qq.com

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet(name = "AgentLoginServlet", urlPatterns = "/AgentLoginServlet")
public class AgentLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("agent");
        String pwd = request.getParameter("password");
        String pwdTemp = "";
        String errorMsg = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
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
        if(conn != null){
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
            }catch (SQLException e){
                e.printStackTrace();
            }
            if(!pwdTemp.equals("")){
                if(pwd.equals(pwdTemp)){
                    request.setAttribute("account", account);
                    request.getRequestDispatcher("agentIndex.jsp").forward(request,response);
                } else {
                    errorMsg = errorMsg+account + "密码与账户不匹配！pwd为："+pwd+",pwdTemp:"+pwdTemp;
                    request.setAttribute("msg",errorMsg);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                }
            }
            else {
                errorMsg = errorMsg+account + "密码与账户匹配失败！pwd为："+pwd+",pwdTemp:"+pwdTemp;
                request.setAttribute("msg",errorMsg);
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
