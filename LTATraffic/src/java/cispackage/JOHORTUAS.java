/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cispackage;

import dataservice.CISDataServiceQuery;
import properties.CISTraffic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.constants;

/**
 *
 * @author ケネス
 */
public class JOHORTUAS extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // Set to expire far in the past. Prevents caching at the proxy server
        response.setHeader("Expires", "Fri, 1 Jan 2010 00:00:00 GMT");
        // Set Date Header to expire
        response.setDateHeader("Expires", 0);

        PrintWriter out = response.getWriter();
        try {
            CISDataServiceQuery _cisDataServiceQuery = new CISDataServiceQuery();
            ArrayList<CISTraffic> list = _cisDataServiceQuery.getCameras();

            CISTraffic _cisTraffic;
            _cisTraffic = (CISTraffic) list.get(constants.CAMERA_JOHORTUAS);

            request.setAttribute("title", "Johor - Tuas");
            request.setAttribute("clat", _cisTraffic.getCLatitude());
            request.setAttribute("clon", _cisTraffic.getCLongitude());
            request.setAttribute("imgLink", _cisTraffic.getCImageURL());
            request.getRequestDispatcher("googlemap.jsp").forward(request, response);
            return;
        } finally {
            out.checkError();
            out.flush();
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
