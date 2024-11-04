package com.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Note;
import com.helper.Factory;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt( request.getParameter("noteId").trim());
			EntityManager em = Factory.entityManagerFactory().createEntityManager();
			EntityTransaction et = em.getTransaction();
			Note note = (Note) em.find(Note.class, id);
			note.setTitle(request.getParameter("title"));
			note.setContent(request.getParameter("content"));
			et.begin();
			et.commit();;
			em.close();
			response.sendRedirect("showNotes.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		
	}

}
