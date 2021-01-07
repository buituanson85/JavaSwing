/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Applocation {
    
    static void input(){
       
    }
    
    static void showMenu(){
        System.out.println("1. Add book records");
        System.out.println("2. Save");
        System.out.println("3. Display book records");
        System.out.println("4. Exit");
        System.out.println("Choice: ");
    }
    static void exit(){
        System.out.println("Exit.");
        System.exit(0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> bookList = new ArrayList<>();
        int choice;
        while (true) {            
            showMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    Book book = new Book();
                    System.out.println("Enter id book: ");
                    String id = sc.nextLine();
                    System.out.println("Enter title book: ");
                    String title = sc.nextLine();
                    System.out.println("Enter author book: ");
                    String Author = sc.nextLine();
                    System.out.println("Enter price book: ");
                    String price = sc.nextLine();
                    book.setId(id);
                    book.setTitle(title);
                    book.setAuthor(Author);
                    book.setPrice(price);
                    bookList.add(book);
                    break;
                case 2: 
                    FileInputStream fis = null;
                    ObjectInputStream ois = null;
                    try {
                        fis = new FileInputStream("D:\\JavaSwing\\JavaSwing\\src\\Practical\\Books.dat");
                        ois = new ObjectInputStream(fis);
                        List<Book> bookList1 =(ArrayList<Book>) ois.readObject();
                        bookList.addAll(bookList1);
                        bookList1.clear();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Applocation.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Applocation.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Applocation.class.getName()).log(Level.SEVERE, null, ex);
                    }finally {
                        if (fis != null){
                            try {
                                fis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (ois != null) {
                            try {
                                ois.close();
                            } catch (IOException ex) {
                                Logger.getLogger(Applocation.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                        
                    FileOutputStream fos = null;
                    ObjectOutputStream oos = null;

                    try {
                        fos = new FileOutputStream("D:\\JavaSwing\\JavaSwing\\src\\Practical\\Books.dat");
                        oos = new ObjectOutputStream(fos);

                        oos.writeObject(bookList);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (fos != null){
                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (oos != null) {
                            try {
                                oos.close();
                            } catch (IOException ex) {
                                Logger.getLogger(Applocation.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    break;
                case 3:
                    FileInputStream fis2 = null;
                    ObjectInputStream ois2 = null;
                    try {
                        fis2 = new FileInputStream("D:\\JavaSwing\\JavaSwing\\src\\Practical\\Books.dat");
                        ois2 = new ObjectInputStream(fis2);
            //            }
                        List<Book> bookList1 =(ArrayList<Book>) ois2.readObject();
                        System.out.printf("%-20s %-20s %-20s %-20s","Id BOok", "Book Name", "Author", "Pride");
                        for (Book book1 : bookList1) {
                            
                            System.out.println("");
                            book1.display();
                        }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } finally {
                            if (fis2 != null){
                                try {
                                    fis2.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            if (ois2 != null){
                                try {
                                    ois2.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    break;
                case 4: 
                    exit();
                    break;
            }
        }
    }
}
