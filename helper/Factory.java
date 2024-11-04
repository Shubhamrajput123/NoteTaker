package com.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
		static EntityManagerFactory emf;
		public static EntityManagerFactory entityManagerFactory() {
			if(emf == null) {
				emf = Persistence.createEntityManagerFactory("java");
				
				
			}
			return emf;
		}
		public void closeFactory() {
			if(emf.isOpen())
				emf.close();
		}
}
