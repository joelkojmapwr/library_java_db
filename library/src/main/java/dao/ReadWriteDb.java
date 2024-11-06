package dao;

import java.util.List;

public interface ReadWriteDb<T> {
    // Method to read a record by its ID
    T readById(int id);

    // Method to read all records
    List<T> readAll();

    // Method to create a new record
    void insert(T entity);

    /*
    // Method to update an existing record
    void update(T entity);

    // Method to delete a record by its ID
    void delete(int id);
    */

}