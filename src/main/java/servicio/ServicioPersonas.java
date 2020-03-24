
package servicio;

import dao.AlumnoDAO;
import domain.Alumno;
import java.util.List;
import javax.inject.Inject;


public class ServicioPersonas {
    
 
    private AlumnoDAO personaDAO;
    
   public ServicioPersonas(){
       personaDAO = new AlumnoDAO();
   }
    
    public List<Alumno> listarPersona(){
        
        return personaDAO.listar();
    }
}
