<%
    String qr="select distinct subject from books order by subject";
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/data7", "root","root");
    java.sql.PreparedStatement ps=con.prepareStatement(qr);
    java.sql.ResultSet rs=ps.executeQuery();
%>
<html>
    <body>
        <h3>Search-Book-By-Subject</h3>
        <form action="BookList">
            Subject <select name="subject">
<%
       while(rs.next()){
        String s1=rs.getString(1);
       
%>
<option><%=s1%></option>
<%
    }
%>
                
                    </select>
                <input type="submit" value="Search"/>
        </form>
        <hr>
        <a href="buyerpage.jsp">Home</a>
    </body>
</html>
<%
    con.close();
%>