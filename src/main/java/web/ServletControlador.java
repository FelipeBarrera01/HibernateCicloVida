/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Alumno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.ServicioPersonas;

/**
 *
 * @author Felipe Barrera
 */

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServicioPersonas servicioPersonas = new ServicioPersonas();
        
        List<Alumno> listadoPersonas = servicioPersonas.listarPersona();
        
        req.setAttribute("personas", listadoPersonas);
        
        try {
            req.getRequestDispatcher("/WEB-INF/listado.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }
    
    
}
