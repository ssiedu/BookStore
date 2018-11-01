import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypkg.Data;

public class SaveBook extends HttpServlet {

    Connection con; PreparedStatement ps;
    Statement stmt;
   @Override
    public void init(){
        try{
        String qr="insert into books values(?,?,?,?,?,?)";
        con=Data.connect();            
        ps=con.prepareStatement(qr);
        stmt=con.createStatement();
        }catch(Exception e){
        }
    }
    @Override
    public void destroy(){
        try{
        con.close();
        }catch(Exception e){
        }
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        //reads the data
        String title=request.getParameter("title");
        String author=request.getParameter("author");
        String publisher=request.getParameter("publisher");
        String subject=request.getParameter("subject");
        int price=Integer.parseInt(request.getParameter("price"));
        //process
        try{
        String sql="select max(bcode) from books";
        ResultSet rs=stmt.executeQuery(sql);
        rs.next();
        int id=rs.getInt(1);
        if(id==0){
            id=1001;
        }else{
           id=id+1; 
        }
        ps.setInt(1, id);
        ps.setString(2, title);
        ps.setString(3, author);
        ps.setString(4, publisher);
        ps.setString(5, subject);
        ps.setInt(6, price);
        ps.executeUpdate();
        //response
        out.println("<html>");
        out.println("<body>");
        out.println("<h4>Book-Details-Saved-Successfully</h4>");
        out.println("<h5><a href=bookentry.jsp>Add-More</a></h5>");
        out.println("<h5><a href=adminpage.jsp>Admin-Home</a></h5>");
        }catch(Exception e){
           out.print(e);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
