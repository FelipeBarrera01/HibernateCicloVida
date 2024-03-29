/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import static dao.GenericDAO.em;

import domain.Alumno;
import java.util.List;

import javax.persistence.Query;

public class AlumnoDAO extends GenericDAO {

    public List<Alumno> listar() {
        String consulta = "SELECT c FROM Alumno c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        } catch (Exception e) {
            
        }
        finally{
            if (em != null) {
              em.close();
            }
        }

    }
     public void actualizar (Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno);
            em.getTransaction().commit();
        } catch (Exception e) {
            
        }
        finally{
            if (em != null) {
              em.close();
            }
        }

    }
      public void eliminar (Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(alumno));
            em.getTransaction().commit();
        } catch (Exception e) {
            
        }
        finally{
            if (em != null) {
              em.close();
            }
        }

    }
      
      public Alumno buscarPorId(Alumno alumno){
      
      em = getEntityManager();
      return em.find(Alumno.class, alumno.getIdAlumno());
      }
}
