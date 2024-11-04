package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Note;
import com.helper.Factory;


public class SaveNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SaveNote() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Note note = new Note(title,content,new Date());
			System.out.println(note.getId()+" "+note.getTitle()+" "+note.getContent()+" "+note.getAddedDate());
			EntityManager em = Factory.entityManagerFactory().createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(note);
			
			et.commit();
			em.close();
			response.setContentType("text/html");
			PrintWriter out= response.getWriter();
			out.println("<h1>your note is added</h1>");
			response.sendRedirect("showNotes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
