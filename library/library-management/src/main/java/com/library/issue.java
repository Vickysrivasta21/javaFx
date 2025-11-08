/*@author : avnish srivastava , issue class to store the details of student and the book issued by him*/

package com.library;
import java.time.LocalDate;
import java.time.LocalDateTime;//using LocalDateTime to get the current date on which the student issues the book

import org.bson.Document;

public class issue {
    //class variables to store the details of student along with the book issued
    String studentname;
    private int roll;
    Document book;
    LocalDateTime issDate;
    LocalDate ret;
    private double fine;
    boolean isret;

    issue(String stu_name, int roll_no, Document book, boolean isret)
    {//constructor to initialize the instance variable of class using this keyword
        this.studentname = stu_name;
        this.roll = roll_no;
        this.book = book;
        this.isret = isret;
        this.issDate = LocalDateTime.now();
        this.ret = LocalDate.now().plusDays(7);
    }
    public double setfine(double fine)
    {//setter function to set the fine on book returned if any
        return this.fine = fine;
    }
    public double getfine()
    {//getter method to get the fine against the student for issued book
        return fine;
    }
    public Document getbook()
    {
        return book;
    }
    public int getid(){
        //getter method to get the id of book
        return roll;
    }
    public String issued(){
        //method to return the details of student along with the book issued 
        return "student name : " + studentname + " roll no : " + roll + " has issued the book : " + book.getString("bookName")  + " on " + issDate; 
    }
}

