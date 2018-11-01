<%@include  file="header.jsp" %>
<html>
    <body>
        <h3>Online Book Store</h3>
        <hr>
        <form action="VerifyUser" method="get">
            <pre>
            Userid      <input type="text" name="uid"/>
            Password    <input type="password" name="pw"/>
            UserType    <select name="utype"><option>admin</option><option>buyer</option></select>
            SavePwd     <input type="checkbox" name="save" value="yes"/>
                        <input type="submit" value="Login"/>
            </pre>
        </form>
        <hr>
        <a href="regi.jsp">New-User-Regi</a>
    </body>
</html>
