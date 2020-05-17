/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class Productos extends HttpServlet {

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
      
        String pro =request.getParameter("producto");
       Double cant =Double.parseDouble(request.getParameter("cantidad"));
        String cod =request.getParameter("codigo");
        Double resul = null;
        Double descuento;
        
        
        if(pro.equals("TV") ){
            if ( cod.equals("")) {
             resul=800*cant;
            }
             else if ( cod.equals("TRENTINO")){
                 descuento=(800*cant)*0.2;
                   resul=(800*cant)-descuento;
                 
             }
             else if ( cod.equals("JPSegundo")){
                  descuento=(800*cant)*0.5;
                 resul=(800*cant)-descuento;
             }
        }
        else if(pro.equals("RADIO") ){
            if ( cod.equals("")) {
             resul=250*cant;
            }
             else if ( cod.equals("TRENTINO")){
                 descuento=(250*cant)*0.2;
                 resul=(250*cant)-descuento;
                 
             }
             else if ( cod.equals("JPSegundo")){
                  descuento=(250*cant)*0.5;
                 resul=(250*cant)-descuento;
             }
        }
        else if(pro.equals("TOSTADORA") ){
            if ( cod.equals("")) {
             resul=100*cant;
            }
             else if ( cod.equals("TRENTINO")){
                 descuento=(100*cant)*0.2;
                 resul=(100*cant)-descuento;
                 
             }
             else if ( cod.equals("JPSegundo")){
                  descuento=(100*cant)*0.5;
                 resul=(100*cant)-descuento;
             }
            
        }
        System.out.println("resultado-----------------------------------------------------------"+resul);
        
          request.setAttribute("resul", resul);
        RequestDispatcher rd;
       rd= request.getRequestDispatcher("pidido.jsp");
        rd.forward(request, response);
            
        
        
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
