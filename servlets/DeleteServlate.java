package com.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Note;
import com.helper.Factory;

public class DeleteServlate extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteServlate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				int noteId = Integer.parseInt(request.getParameter("note_id").trim());
				EntityManager em = Factory.entityManagerFactory().createEntityManager();
				EntityTransaction et = em.getTransaction();
				Note n =(Note) em.find(Note.class, noteId);
				et.begin();
				em.remove(n);
				et.commit();
				em.close();		
				response.sendRedirect("showNotes.jsp");
				
				
			} catch (Exception e) {
				e.getMessage();
			}
		
		
	}

	

}
