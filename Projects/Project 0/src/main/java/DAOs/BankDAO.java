package DAOs;

import MyCollections.MyArrayList;

import java.sql.SQLException;

public interface BankDAO<T> {
    public void save(T row) throws SQLException;

    public MyArrayList<T> getAll() throws SQLException;

    public void deleteByID(int ID) throws SQLException;

    public MyArrayList<T> getByID(int ID) throws SQLException;
}
