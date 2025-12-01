package com.service;

import java.io.*;
import java.util.ArrayList;
import com.model.Book;

public class BookService {

    private final ArrayList<Book> books = new ArrayList<>();
    private final File file = new File("src/data/files/Books.csv");

    public BookService() {
        loadBooks();
    }


    public ArrayList<Book> loadBooks() {

        books.clear();

        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs(); 
                file.createNewFile();
                System.out.println("Books.csv created.");
                return books;
            }
        } catch (IOException e) {
            System.out.println("Error creating Books.csv: " + e.getMessage());
            return books;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";

            while ((line = reader.readLine()) != null) {

                String[] p = line.split(",", -1);
                if (p.length < 7) continue; // linha inválida

                Book b = new Book(
                        Integer.parseInt(p[0].trim()),  // id
                        p[1],                           // title
                        p[2],                           // author
                        p[3],                           // isbn
                        Integer.parseInt(p[4].trim()),  // year
                        Integer.parseInt(p[5].trim()),  // pages
                        p[6]                            // genre
                );

                books.add(b);
            }

        } catch (IOException e) {
            System.out.println("Error reading Books.csv: " + e.getMessage());
        }

        System.out.println("Loaded books: " + books.size());
        return books;
    }


    public Book findBookByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    public boolean registerBook(String title, String author, String isbn,
                                int releaseYear, int numPages, String genre) {

        if (findBookByIsbn(isbn) != null) {
            System.out.println("Book with this ISBN already exists.");
            return false;
        }

        Book newBook = new Book(title, author, isbn, releaseYear, numPages, genre);
        books.add(newBook);

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println(
                    newBook.getId() + "," +
                            newBook.getTitle() + "," +
                            newBook.getAuthor() + "," +
                            newBook.getIsbn() + "," +
                            newBook.getReleaseYear() + "," +
                            newBook.getNumPages() + "," +
                            newBook.getGenre()
            );
        } catch (IOException e) {
            System.out.println("Error saving book to CSV: " + e.getMessage());
            return false;
        }

        System.out.println("Book registered successfully.");
        return true;
    }

 
    public void printBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    
    public ArrayList<Book> getBooks() {
        return books;
    }

   public void deleteBook(Book book) {
        books.remove(book);
        saveAllBooks();
    }

    public void saveAllBooks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
        for (Book b : books) {
            writer.println(
                b.getId() + "," +
                b.getTitle() + "," +
                b.getAuthor() + "," +
                b.getIsbn() + "," +
                b.getReleaseYear() + "," +
                b.getNumPages() + "," +
                b.getGenre()
                );
            }
        } catch (IOException e) {
            System.out.println("Error rewriting Books.csv: " + e.getMessage());
        }
    }

}


