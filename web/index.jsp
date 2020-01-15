<%--
  Created by IntelliJ IDEA.
  User: 御承扬
  Date: 2020/1/11
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>彭友来律师事务所</title>
    <style type="text/css">
      .b{
        height:100px;
        width:100px;
        position:absolute;
        bottom:0;
        margin-left:-50px;/*div宽度的一半*/
        left:50%;
      }
      .content {
        width: 960px;
        margin: 32px auto;
        padding: 0 24px;
      }
      .content_wrapper{
        min-height: 372px;
        padding-top: 40px;
        margin: 0 20px 60px 25px;
        *zoom:1;
      }
      .login_pictures {
        position: relative;
        margin-right: 395px;
      }
      .login_pictures_picture {
        position: absolute;
        left: 200px;
        right: 0;
        top: 0;
        height: 400px;
        _width: 100%;
      }
      .login_pictures_txt {
        padding-top: 25px;
        position: relative;
        font-size: 14px;
        font-weight: normal;
        line-height: 24px;
        color: #e91131;
      }
      .xm_login_container {
        width: 334px !important;
        height: 387px !important;
      }
      .login_container {
        float: right;
        border: 1px solid
        #a0b1c4;
        width: 334px;
        height: 387px;
        _height: 371px;
        background-color:
                #fff;
        position: relative;
        z-index: 12;
        padding: 0;
        border-radius: 5px;
        overflow: hidden;
      }
      .xm_login_card {
        position: relative;
        width: 100%;
        height: 100%;
        background: url("images/lawyer.jpg");
      }
      .xm_login_card_tab {
        height: 50px;
        font-size: 0;
        border-bottom: 1px solid
        #a0b1c4;
        background-color: #f9fbfe;
        border-radius: 6px 6px 0 0;
      }
      .xm_login_card_tab_item {
        float: left;
        width: 100%;
        font-size: 26px;
        line-height: 50px;
        color: #e994a5;
        text-align: center;
        cursor: pointer;
      }
      p{
        font-size: 26px;
      }
    </style>
    <script language="JavaScript">
      function checkAgentPassword(agent,password){
        if(agent.value ===""){
          alert("请输入账号！");
          agent.focus();
          return false;
        }
        else if(agent.value ===""){
          alert("请输入密码！");
          password.focus();
          return false;
        }
        else if(agent.value !=="" && password.value !==""){
          return true;
        }
      }
    </script>
  </head>
  <body>
  <div class="content">
    <div class="content_wrapper">
      <div id="loginAndSigh" class="xm_login_container login_container" style="width: 330px; height: 336px; visibility: visible;">
        <div class="xm_login_card">
          <div class="xm_login_card_tab">
            <div id="loginCard" class="xm_login_card_tab_item">登录与注册</div>
          </div>
          <form name="form1" method="post" action="${pageContext.request.contextPath}/AgentLoginServlet" onsubmit="return checkAgentPassword(form1.agent,form1.password)">
            <table width="85%" border="0">
              <tr>
                <td width="36%" height="50px"><label for="agent">账号：</label></td>
                <td width="64%" height="50px"><input name="agent" type="text" id="agent" style="width: 120px"></td>
              </tr>
              <tr>
                <td width="36%" height="50px"><label for="password">密码：</label></td>
                <td width="36%" height="50px"><input name="password" id="password" type="text" style="width: 120px"></td>
              </tr>
              <tr>
                <td colspan="2">&nbsp;<input type="submit" width="50px" name="submit" value="确认"></td>
                <td><input type="button" style="width: 50px" value="注册" onclick="window.location.href='UserLogin.jsp'"></td>
              </tr>
            </table>
          </form>
        </div>
      </div>
      <div class="login_pictures">
        <div class="login_pictures_picture">
          <img src="images/indexLog.png" width="250" height="400" alt="图片">
        </div>
        <div class="login_pictures_txt">
          <p>法无授权不得为，<br>法无禁止不得罚。</p>
        </div>
      </div>
    </div>
  </div>
  <div class="b">
    <%@include file="copyright.jsp"%>
  </div>
  </body>
</html>
