/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CodigoDiscontinuos;

/**
 *
 * @author pablonello
 */
@WebServlet(name = "holaServlet", urlPatterns = {"/holaServlet"})
public class holaServlet extends HttpServlet {

    @EJB Bean bean; //importo el bean al web servis para usarlo
    @PersistenceUnit //llamo a la persistencia creada para poder utilizarla
    EntityManagerFactory emf; // creo una variable para poder utilizar los datod de la tabala que traje
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet holaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet holaServlet at " + request.getContextPath() + "</h1>");
            
            out.println("<h2>" + bean.DigaHola("pepe") + "</h2>");
            
            CodigoDiscontinuos cd = (CodigoDiscontinuos) emf.createEntityManager().createNamedQuery("CodigoDiscontinuos.findAll").getResultList().get(0);
            out.println("<h2> " + "codigo Discontinuo es :"+ cd.getDiscountCode() + "</h2>");
            out.println("<h2>" + "el numero del codigo es "+ cd.hashCode() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
