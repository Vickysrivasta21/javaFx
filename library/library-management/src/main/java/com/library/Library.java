package com.library;

/**@author : avnish srivastava, program to implement library system for adding issue and return book, date : 30-08-2025 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class Library {
    // initializing the array of object of class issued and addbook to store the
    // details of book and students
    static addbook[] b = new addbook[500];
    static issue[] i = new issue[500];
    static int added = 0;
    static int issued = 0;

    public void add(addbook books) {

        for (int i = 0; i < added; i++) {
            if (b[i].getid() == books.getid()) {
                System.out.println("book already added!");
                return;
            }
        }
        b[added++] = books;
        System.out.println("book added!");
    }

    public static issue issuebook(int stuId, String name, int bookid) {

        Iterable<Document> bookdet = DatabaseConnection.getAllBooks();
        for (Document doc : bookdet) {
            if (doc.getInteger("id") == bookid) {
                if (doc.getInteger("availcopies") > 0) {
                    Document book = new Document()
                            .append("id", doc.getInteger("id"))
                            .append("bookName", doc.getString("bookName"))
                            .append("author", doc.getString("author"))
                            .append("publisher", doc.getString("publisher"))
                            .append("availcopies", doc.getInteger("availcopies"));
                    issue is = new issue(name, stuId, book, false);
                    DatabaseConnection.addIssue(is);
                    // b[j].setavailcopies(b[j].getavailcopies() - 1);
                    DatabaseConnection.updateBookCopies(bookid, doc.getInteger("availcopies") - 1);
                    System.out.println("book issued successfully!");
                    System.out.println("book issued on : " + is.issDate
                            + " and should be returned on or before : " + is.ret);
                    return is;
                } else {

                    System.out.println("book not available!");
                    return null;
                }
            }
        }
        return null;
    }

    public static long returnbook(int roll, int bookid) {
        long fine = 0;
        Iterable<Document> doc = DatabaseConnection.getAllIssues();
        for (Document docs : doc) {
            if (docs.getInteger("roll") == roll && docs.getInteger("bookid") == bookid) {
                String date = docs.getString("ret");
                DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate retd = LocalDate.parse(date, f);
                Long days = LocalDate.now().toEpochDay() - retd.toEpochDay();
                if (days > 0) {
                    fine = days * 5;
                }
                System.out.println(fine);
                int curr = 0;
                Iterable<Document> bookdet = DatabaseConnection.getAllBooks();
                for (Document bookDoc : bookdet) {
                    if (bookDoc.getInteger("id") == bookid) {
                        curr = bookDoc.getInteger("availcopies");
                        break;
                    }
                }
                DatabaseConnection.updateIssue(roll, bookid, true, fine, curr + 1);
            }
        }
        return fine;
    }

    public void display() {
        System.out.println("available books");
        for (int i = 0; i < added; i++) {// printing available books
            System.out.println(b[i].book());
        }
        System.out.println("issued books are : ");
        for (int j = 0; j < issued; j++) {// printing issued books
            if (!i[j].isret) {
                System.out.println(i[j].issued());
            }
        }
    }

    public static void main(String[] args) {
        // int ch;
        // Library lib = new Library();
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Available books are : ");
        // addbook book1 = new addbook("eng. physics", 121, "sk srivastava", "vision
        // publisher", 4);
        // addbook book2 = new addbook("eng. Maths", 203, "HK Dass", "morning star
        // publisher", 7);
        // addbook book3 = new addbook("History", 502, "jyoti das", "morning star", 3);
        // b[added++] = book1;
        // b[added++] = book2;
        // b[added++] = book3;
        // lib.display();
        // System.out.println("enter your choice \n 1. add book \n 2. issue book\n 3.
        // return book \n 4. display");
        // ch = sc.nextInt();
        // sc.nextLine();
        // while (ch != 5) {
        // switch (ch) {//switch case to perform operations on library based on user's
        // choice
        // case 1://adding a book
        // System.out.println("enter details to add book");
        // System.out.println("enter the name of book : ");
        // String name = sc.nextLine();
        // System.out.println("enter book id : ");
        // int id = sc.nextInt();
        // sc.nextLine();
        // System.out.println("enter the author name : ");
        // String author = sc.nextLine();
        // System.out.println("enter the number of copies available of the book");
        // int copies = sc.nextInt();
        // System.out.println("enter the publisher name : ");
        // String publisher = sc.nextLine();
        // addbook book = new addbook(name, id, author, publisher, copies);
        // lib.add(book);//sending the refrence of book to function(call by refrence)
        // lib.display();
        // break;
        // case 2:
        // //issue book to student
        // System.out.println("enter the book to issue");
        // System.out.println("enter the book ID : ");
        // int bookid = sc.nextInt();
        // sc.nextLine();
        // System.out.println("Enter student name:");
        // String Name = sc.nextLine();
        // System.out.println("Enter roll number:");
        // int roll = sc.nextInt();
        // sc.nextLine();
        // lib.issuebook(roll, Name, bookid);//calling function issuebook to issuebook
        // to student
        // break;
        // case 3:
        // //returnning a book
        // System.out.println("enter the details of book to return : ");
        // int book_id = sc.nextInt();
        // int roll_no = sc.nextInt();
        // lib.returnbook(roll_no, book_id);//calling the function to return book
        // break;
        // case 4:
        // //display the available and issued books
        // lib.display();
        // break;
        // default:
        // break;
        // }
        // System.out.println("enter your choice \n 1. add book \n 2. issue book\n 3.
        // return book \n 4. display");
        // ch = sc.nextInt();
        // sc.nextLine();
        // }
    }
}
