package library;

import library.Copy;
import java.util.*;

public class Book implements Printable {

    public static int idCounter = 0;
    public int id;
    public String title;
    public String author;
    public List<Copy> copy = new ArrayList<>();
    //public int year;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        //this.year = year;
    }

    public Copy addCopy() {
        Copy newCopy = new Copy(this.copy.size() + 1, this.id);
        this.copy.add(newCopy);
        return newCopy;
    }

    public void print() {
        System.out.println("ID: " + id + " title: " + title + " by " + author);
    }



    //public void addCopy() {};
}
