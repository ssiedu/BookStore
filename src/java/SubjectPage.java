import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SubjectPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        int n=0;
        HttpSession session=request.getSession();
        String uid=(String) session.getAttribute("user");
        if(uid==null){
            response.sendRedirect("index.jsp");
        }

        ArrayList<String> list=(ArrayList<String>) session.getAttribute("cart");
        if(list!=null){
            n=list.size();
        }
        
        


        
        String sub="ALL";
        //to read the cookie
        //fetch-all-the-cookies-coming with request
        Cookie ck[]=request.getCookies();
        //search the desired one
        for(int i=0; i<ck.length; i++){
            String name=ck[i].getName();
            if(name.equals("pref")){
                sub=ck[i].getValue();
                break;
            }
        }

        try{
            Connection con=mypkg.Data.connect();
            String qr="select distinct subject from books order by subject";
            PreparedStatement ps=con.prepareStatement(qr);
            ResultSet rs=ps.executeQuery();
            out.println("<html>");
            out.println("<body>");
            //out.println("<marquee><h4>Attractive Offers on "+sub+" Books </h4></marquee>");
            out.println("<h6>Total Books : "+n+"</h6>");
            out.println("<h3>Welcome "+uid+" </h3>");
            out.println("<h3>Select Subject</h3>");
            out.println("<hr>");
            while(rs.next()){
                String s=rs.getString(1);
                out.println("<a href=BookList?subject="+s+">");
                out.println(s);
                out.println("</a>");
                out.println("<br>");
            }
            out.println("<hr>");
            out.println("<a href=buyerpage.jsp>Home</a>");
            out.println("</body>");
            out.println("</html>");
            
            
            
            
            
        }catch(Exception e){
            out.println(e);
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
