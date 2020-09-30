package com.training;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BookService {
	
	public boolean writeObject(Book book) throws FileNotFoundException, IOException {
		
		boolean persisted = false;
		
		ObjectOutputStream outStream=null;
		
		try {
		outStream=new ObjectOutputStream(new FileOutputStream(new File("book.ser")));
		
		outStream.writeObject(book);
		
		persisted=true;
		}catch (IOException e) {
			
			System.err.println(e.getMessage());
		}
		finally {
			
			try {
				outStream.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return persisted;
		
	}
	
	
	
	public Book readObject() {
		
		Book book=null;
		
		ObjectInputStream inStream=null;
		try {
			
			inStream=new ObjectInputStream(new FileInputStream(new File("book.ser")));
			book=(Book)inStream.readObject();
		
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return book;
	}
	
	public boolean writeWithDataStream(Book book,File file) {
		
		try {
			
			DataOutputStream outStream=new DataOutputStream(new FileOutputStream(file));
			outStream.writeInt(book.getBookNumber());
			outStream.writeUTF(book.getBookName());
			outStream.writeUTF(book.getAuther());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return true;
	}
	
	public Book readWithDataStream(File file) {
		
	try {
		
		DataInputStream inStream= new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		Book bk=new Book();
		
		bk.setBookNumber(inStream.readInt());
		bk.setBookName(inStream.readUTF());
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		
		
		return null;
	}

}
