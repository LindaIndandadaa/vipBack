<%--
  Created by IntelliJ IDEA.
  User: Linda
  Date: 2019/10/6
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String contextPath = request.getContextPath();
%>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>Vip客户查询</title>
</head>
<body>
    <header>
        <strong>${message}</strong>
        <form action="vip/qry.do" method="post">
            <p>
                <label>
                    VIP:
                    <input name="code" autofocus>
                </label>
                <button type="submit">Go</button>
            </p>
        </form>
    </header>
    <main>
        <c:if test="${vip!=null}">
        <article>
            <p>
                <span>
                    编号
                    <b>${vip.code}；</b>
                </span>
                <span>
                    VIP等级
                    <b>${vip.rank}；</b>
                </span>
                <span>
                    当前消费金额
                    <b>￥${vip.amount}元；</b>
                </span>
            </p>
            <p>
                <span>
                    姓名
                    <b>${vip.name}；</b>
                </span>
                <span>
                    性别
                    <b>${vip.sex}；</b>
                </span>
                <span>
                    年龄
                    <b>${vip.age}；</b>
                </span>
            <p>

                <span>
                    QQ
                    <b>${vip.qq}；</b>
                </span>
                <span>
                    邮编
                    <b>${vip.zip}；</b>
                </span>
                <span>
                    地址
                    <b>${vip.address}；</b>
                </span>
            </p>
            <p>
                ${vip.remark}
            </p>
        </article>
        </c:if>
    </main>

</body>
</html>
