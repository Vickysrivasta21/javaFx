package com.library;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseConnection {
    private static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    private static MongoDatabase database = mongoClient.getDatabase("library-management");

    public static MongoCollection<Document> getBooksCollection() {
        return database.getCollection("book");
    }

    public static MongoCollection<Document> getIssuesCollection() {
        return database.getCollection("issue");
    }

    public static void addBook(addbook book) {
        Document doc = new Document("bookName", book.getbookName())
                .append("id", book.getid())
                .append("author", book.author)
                .append("publisher", book.publisher)
                .append("availcopies", book.getavailcopies());
        getBooksCollection().insertOne(doc);
    }

    public static Iterable<Document> getAllBooks() {
        return getBooksCollection().find();
    }

    public static void updateBookCopies(int id, int newCopies) {
        getBooksCollection().updateOne(new Document("id", id),
                new Document("$set", new Document("availcopies", newCopies)));
    }

    public static void addIssue(issue iss) {
        Document doc = new Document("studentname", iss.studentname)
                .append("roll", iss.getid())
                .append("bookid", iss.book.getInteger("id"))
                .append("issDate", iss.issDate.toString())
                .append("ret", iss.ret.toString())
                .append("fine", iss.getfine())
                .append("isret", iss.isret)
                .append("bookName", iss.book.getString("bookName"));
        getIssuesCollection().insertOne(doc);
    }

    public static void updateIssue(int roll, int bookid, boolean isret, double fine, int copies) {
        // getIssuesCollection().updateOne(
        // new Document("roll", roll).append("bookid", bookid),
        // new Document("$set", new Document("isret", isret).append("fine", fine))
        // );
        getIssuesCollection().deleteOne(
                new Document("roll", roll).append("bookid", bookid));

        getBooksCollection().updateOne(new Document("id", bookid),
                new Document("$set", new Document("availcopies", copies)));
    }

    public static Iterable<Document> getAllIssues() {
        return getIssuesCollection().find();
    }

    public static void close() {
        mongoClient.close();
    }
}
