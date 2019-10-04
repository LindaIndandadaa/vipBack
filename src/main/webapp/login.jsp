<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <meta charset="utf-8">
        <title>XXX</title>
    </head>
    <script>
        if(window.top!=window)
            window.top.location.href=window.location.href;
    </script>
<body>
    <strong>${message}</strong>
    <form action="login.do" method="post">
        <p>
            <label>Account:<input name="account"></label>
        </p>
        <p>
            <label>PassWord:<input name="password" type="password"></label>
        </p>
        <p>
            <button type="submit">Login</button>
        </p>
    </form>
    <%session.removeAttribute("message");%>
</body>
</html>
