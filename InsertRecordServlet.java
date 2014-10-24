package servlets;
import static db.DAOSQLite.getAllRecordsAsList;
import static db.DAOSQLite.insertRecord;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Book;
/**
 *
 * @author Kevin
 */
public class InsertRecordServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        
        // get real path to the sqlite db
        ServletContext sc = this.getServletContext();
        String dbPath = sc.getRealPath("/WEB-INF/book.db");

        // get parameters passed in from the request
        String semester = request.getParameter("semester");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String isbn = request.getParameter("isbn");
        String amount = request.getParameter("amount");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertRecordServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=home.html>" + "Return to Home Page" + "</a>");

            if(semester != null && email != null && course != null && isbn != null && amount != null) {
                int amountNum = Integer.parseInt(amount);
                Book book = new Book(0, semester, email, course, isbn, amountNum);
                insertRecord(book, dbPath);
                for(Book b : getAllRecordsAsList(dbPath)) {
                    out.println("<p>" + b + "</p>");
                }
            } else {
                out.println("Missing one or more values.");
            }
            
            out.println("</body>");
            out.println("</html>");
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
