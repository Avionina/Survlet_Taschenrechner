/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*
* @author MMoschkau
*/
@WebServlet(urlPatterns = {"/TaschenRechner"})
public class TaschenRechner extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        int zahl1 = 0;
        int zahl2 = 0;
        char op = '+';
        int erg = zahl1 + zahl2;

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TaschenRechner</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'><font face='Britannic' size='10' color='red'>Hallo. Willkommen beim Taschenrechner</font></div>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<table border='3' align='center'>");
            out.println("<form action='TaschenRechner' method='get' id='TaschenRechner'>");
            out.println("<th colspan='2'>Taschenrechner</th>");
            out.println("<tr>");
            out.println("<td>" + "<label for='zahl1'>Gebe Zahl 1 ein.</label> </td> <td> <input type='text' name='zahl1' id='zahl1' maxlength='5' </td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>" + "<label for='operator'>Gebe den Operator ein.</label> </td> <td> <input type='text' name='operator' id='operator' maxlength='1' </td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>" + "<label for='zahl2'>Gebe Zahl 2 ein.</label> </td> <td> <input type='text' name='zahl2' id='zahl2' maxlength='5' </td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><button type='submit'>Ergebnis ansehen.</button></td>" + "<td><button type='reset'>Eingaben l&ouml;schen</button></td>");
            out.println("</tr>");
            zahl1 = Integer.parseInt(request.getParameter("zahl1"));
            zahl2 = Integer.parseInt(request.getParameter("zahl2"));
            op = request.getParameter("operator").charAt(0);
            switch (op) {
                case '+': {
                    erg = zahl1 + zahl2;
                    break;
                }
                case '-': {
                    erg = zahl1 - zahl2;
                    break;
                }
                case '/': {
                    try {
                        erg = zahl1 / zahl2;
                    } catch(ArithmeticException A) {
                        out.println("<br>");
                        out.println("<br>");
                        out.println("<h1 align='center'>Durch 0 teilen nicht m&oumlglich.</h1>");
                    }

                    break;
                }
                case '*': {
                    erg = zahl1 * zahl2;
                    break;
                }
            }
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("</form>");
            out.println("</table>");
            out.println("<h1 align='center'>Das Ergebnis ist: " + erg + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
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
    }
}