package com.myCode.servletSet;//@Software: IntelliJ IDEA
// @Project: Lawyer
//@File:${NAME}
//@Date:2020/1/15
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "SignOutServlet", urlPatterns = "/SignOutServlet")
public class SignOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = session.getAttribute("user").toString();
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConn();
        String sql = "update agent set status='0' where acount=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            int row = ps.executeUpdate();
            ps.close();
            conn.close();
            if(row>0){
                response.sendRedirect("index.jsp");
            }else
            {
                response.setContentType("text/html");
                response.getWriter().write("退出失败！3秒后将自动跳转到首页，如果没有，请手动！");
                response.setHeader("refresh","3;url=agentIndex.jsp");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
