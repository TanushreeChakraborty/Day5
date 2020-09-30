package com.training;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Book headFist=new Book(100,"hFjava","karry",450);
		BookService service=new BookService();
		boolean result=service.writeObject(headFist);
		if (result) {
			System.out.println("Book Persisted");
		}else {
			System.out.println("error check");
		}

	}

}
