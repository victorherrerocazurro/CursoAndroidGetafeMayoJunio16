package com.example.profesormanana.a21_sqlite;

import java.util.List;

/**
 * Created by profesormanana on 21/6/16.
 */
public interface IDataLogDAO {
    void create(String descripcion);
    List<DataLog> showLogs();
    void clearLogs();
}
