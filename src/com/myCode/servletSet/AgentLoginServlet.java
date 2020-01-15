package com.myCode.servletSet;
//@Software: IntelliJ IDEA
// @Project: Lawyer
//@File:${NAME}
//@Date:2020/1/12
// Author:御承扬
//E-mail:2923616405@qq.com

import com.myCode.DB.DBConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;


@WebServlet(name = "AgentLoginServlet", urlPatterns = "/AgentLoginServlet")
public class AgentLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("agent");
        String pwd = request.getParameter("password");
        String pwdTemp = "";
        String errorMsg = "";
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConn();
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
                        errorMsg="账户名错误";
                    }
                }
                if(!pwdTemp.equals("")){
                    if(pwd.equals(pwdTemp)){
                        String sql1 = "update agent set status='1' where acount=?";
                        PreparedStatement ps = conn.prepareStatement(sql1);
                        ps.setString(1,account);
                        ps.executeUpdate();
                        ps.close();
                        HttpSession session = request.getSession();
                        session.setAttribute("user", account);
                        request.setAttribute("account", account);
                        request.getRequestDispatcher("agentIndex.jsp").forward(request,response);
                    } else {
                        errorMsg = errorMsg+ "或者密码与账户不匹配！";
                        request.setAttribute("msg",errorMsg);
                        request.getRequestDispatcher("error.jsp").forward(request,response);
                    }
                }
                else {
                    errorMsg = errorMsg+ "密码与账户匹配失败";
                    request.setAttribute("msg",errorMsg);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
