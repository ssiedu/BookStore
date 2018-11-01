<html>
    <body>
        <h3>Online Book Store</h3>
        <h4>Book Entry Form</h4>
        <hr>
        <form action="SaveBook" method="get">
            <pre>
            Title       <input type="text" name="title"/>
            Author      <input type="text" name="author"/>
            Publshr     <input type="text" name="publisher"/>
            Subject     <select name="subject">
                        <option>English</option>
                        <option>Maths</option>                            
                        <option>Physics</option>                            
                        <option>Chemistry</option>                            
                        <option>CompSc</option>                            
                        <option>Others</option>                            
                        </select>
            Price       <input type="text" name="price"/>
                        <input type="submit" value="Save"/>
            </pre>
        </form>
        <hr>
        <a href="adminpage.jsp">Admin-Home</a>
    </body>
</html>

