
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--вывод или формы регистрации или логоут--%>
   <jstl:choose>
    <jstl:when test="${not empty sessionScope.user}">
        <p>${sessionScope.user.name}</p>
        <p><a href="controller?action=logout">Logout</a></p>
    </jstl:when>
     <jstl:otherwise>
         <p><a href="register.jsp">Register</a></p>
         <p><a href="login.jsp">Login</a></p>
     </jstl:otherwise>
   </jstl:choose>

<%--вывод всех цветов на страницу под формой регистрации--%>
   <jstl:choose>
       <jstl:when test="${empty sessionScope.user}">
           <jstl:forEach items="${requestScope.flowers}" var="flower">
               <br/>
               <p><img src="${flower.imagePath}" alt="flower" /></p>
               <p>Name: ${flower.name}</p>
               <p>Price: ${flower.price}</p>

               <form method="post" action="controller?action=register">
                   <input type="submit" value="Register for add this flower to the bunch" />
               </form>
           </jstl:forEach>
       </jstl:when>
</body>
</html>