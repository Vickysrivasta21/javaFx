package com.library;
/*@author: avnish srivastava ,addbook class for storing the details of a book like name, author name, Book Id, publisher and available copies */

public class addbook {
    //class variables to store the details of book
    private String bookName;
    private int id;
    public String author;
    public String publisher;
    private int availcopies;

    addbook(String book, int id, String author, String publisher, int available)
    {
        //constructor to initialize the instance of the class using this keyword
        this.bookName = book;
        this.id = id;
        this.author = author;
        this.publisher = publisher;
        this.availcopies = available;
    }
    public String getbookName()
    {//getter function to get name of book object
        return bookName;
    }
    public int getid()
    {//getter function to get the id of the book
        return id;
    }
    public int getavailcopies()
    {//getter function to get available copies of book
        return availcopies;
    }
    public int setavailcopies(int available)
    {//setter  function to set the number of book available
        this.availcopies = available;
        return availcopies;
    }
    public String book()
    {//method book to return the book detsils
        return " book " + id + " - " + bookName + " by " + author + " - " + publisher + " has " + availcopies + " copies available ";
    }
}

