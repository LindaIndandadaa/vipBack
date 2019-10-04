<%--
  Created by IntelliJ IDEA.
  User: Linda
  Date: 2019/10/1
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>HOME</title>
    <style>
        menu,h1,ul{
            margin:0;
        }
        html,body{
            margin:0;
            height: 100%;
            font-size: 14px;
        }
        body>header{
            line-height: 80px;
            text-align: center;
            background: #999999;
        }
        body>header>h1{
            display: inline;
            text-align: center;
        }
        .body{
            position: absolute;
            top:80px;
            bottom: 0px;
            width: 100%;
        }
        .body>menu{
            position: absolute;
            left: 0px;
            width: 200px;
            height: 100%;
            background:#eea236;
            box-sizing: border-box;
        }
        .body>main{
            margin-left: 200px;
            height: 100%;
            display: block;
        }
        main>iframe{
            height: 100%;
            width: 100%;
            border: 0;
            display: block;
        }
    </style>
</head>
<body>
    <header>
        <h1>VIP消费操作系统</h1>
        <span>
            <a href="logout.do">退出登录</a>
        </span>
    </header>
    <section class="body">
        <menu>
            <ul>
                <li>
                    <a>VIP客户端</a>
                </li>
                <li>
                    <a>录入VIP客户</a>
                </li>
                <li>
                    <a>VIP客户管理</a>
                </li>
                <li>
                    <a>查看VIP消费记录</a>
                </li>
                <li>
                    <a>录入VIP消费记录</a>
                </li>
                <li>
                    <a>VIP消费记录管理</a>
                </li>
                <li>
                    <a href="updatepassword.do" target="mainFrame">修改密码</a>
                </li>
            </ul>
        </menu>
        <main>
            <iframe name="mainFrame" src="welcome.do"></iframe>
        </main>
    </section>



</body>
</html>
