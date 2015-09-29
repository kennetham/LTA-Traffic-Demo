/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcspackage;

import dataservice.*;
import properties.*;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kenneth
 */
public class TCSTrafficServlet extends HttpServlet {

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
            TCSDataServiceQuery _tcsDataServiceQuery = new TCSDataServiceQuery();
            ArrayList<TCSTraffic> list = new ArrayList<TCSTraffic>();

            TCSTraffic _tcsTraffic;
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Project Nimbus - LTA Traffic Condition Set</title>");
            out.println("<script src=\"jquery/jquery-1.4.2.js\"></script>"
                    + "<script type=\"text/javascript\">"
                    + "$(document).ready(function(){"
                    + "$(\".stripeMe tr\").mouseover(function() {$(this).addClass(\"over\");}).mouseout(function() {$(this).removeClass(\"over\");});"
                    + "$(\".stripeMe tr:even\").addClass(\"alt\");"
                    + "})"
                    + "</script>");

            out.println("<link rel=\"stylesheet\" href=\"css/style.css\" />");

            out.println("<style type=\"text/css\">"
                    + "body {"
                    + "background: #fff;"
                    + "}"
                    + "table {"
                    + "border-collapse: collapse;"
                    + "width: 50%;"
                    + "margin: 24px;"
                    + "font-size: 1.1em;"
                    + "}"
                    + "th {"
                    + "background: #3e83c9;"
                    + "color: #fff;"
                    + "font-weight: bold;"
                    + "padding: 2px 11px;"
                    + "text-align: left;"
                    + "border-right: 1px solid #fff;"
                    + "line-height: 1.2;"
                    + "}"
                    + "td {"
                    + "padding: 6px 11px;"
                    + "border-bottom: 1px solid #95bce2;"
                    + "vertical-align: top;"
                    + "}"
                    + "td * {"
                    + "padding: 6px 11px;"
                    + "}"
                    + "tr.alt td {"
                    + "background: #ecf6fc;"
                    + "}"
                    + "tr.over td {"
                    + "background: #bcd4ec;"
                    + "}"
                    + "</style>");

            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet TrafficConditionSet TrafficServlet at " + request.getContextPath() + "</h1>");
//            out.println("<h2>GUID: " + _tcsDataServiceQuery.getMyGuid() + "</h2>");
//            out.println(_tcsDataServiceQuery.getNearbyTrafficConditions());

            list = _tcsDataServiceQuery.getTrafficConditionsAll();
            String _data = list.toString();
            String[] _temp = null;
            _temp = _data.split("},");

            out.println("<table class=\"stripeMe\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Traffic Condition ID</th>");
            out.println("<th>Link ID</th>");
            out.println("<th>Road Name</th>");
            out.println("<th>Road Category</th>");
            out.println("<th>Speed</th>");
            out.println("<th>Location</th>");
            out.println("<th>Summary</th>");
            out.println("<th>Create Date</th>");
            out.println("</tr>");
            out.println("</thead>");

            out.println("<tbody>");
            for (int i = 1; i < _temp.length - 1; i++) {
                out.println("<tr>");
//                _temp[i] = _temp[i].toString();
                _tcsTraffic = (TCSTraffic) list.get(i);
                out.println("<td>" + _tcsTraffic.getTrafficConditionID() + "</td>");
                out.println("<td>" + _tcsTraffic.getTLinkID() + "</td>");
                out.println("<td>" + _tcsTraffic.getTRoadName() + "</td>");
                out.println("<td>" + _tcsTraffic.getTRoadCategory() + "</td>");
                out.println("<td>" + _tcsTraffic.getTSpeed() + "</td>");
                out.println("<td>" + _tcsTraffic.getTLocation() + "</td>");
                out.println("<td>" + _tcsTraffic.getTSummary() + "</td>");
                out.println("<td>" + _tcsTraffic.getTCreateDate() + "</td>");
//                out.println(_temp[i] + "\n");
                out.println("</tr>");
                out.println();
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println();

//            out.println(Utils.IUtils(list.toString()));
//            out.println(_tcsDataServiceQuery.getTrafficConditions());
            out.println("</body>");
            out.println("</html>");

            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TCSTrafficServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TCSTrafficServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
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
