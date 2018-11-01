<%@include file="header.jsp" %>
<%
    int n=session.getMaxInactiveInterval();
    String uid=(String)session.getAttribute("user");
    if(uid==null){
    response.sendRedirect("index.jsp");
    }
    long val=session.getCreationTime();
    java.util.Date dt=new java.util.Date(val);
%>

<html>
    <body>
<!--        <h5>Your Session Was Created On <%=dt%></h5>
        <h4>If you remain idle for <%=n%> seconds your session will expire</h4>-->
        <h3>Welcome <%=uid%></h3>
        <hr>
        <pre>
        <a href="SubjectPage">Explore-Store</a>
        <a href="search.jsp">Search-Book-By-Id</a>
        <a href="subsearch.jsp">Search-Book-By-Subject</a>
        <a href="DisplayCart">View-Cart</a>
        <a href="updateform.jsp">Profile-Update</a>
        <a href="EndSession">Logout</a>
        </pre>
        <hr>
    </body>
</html>

