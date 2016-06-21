package com.example.profesormanana.a21_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by profesormanana on 20/6/16.
 */
public class DataLogSQLiteDAO extends SQLiteOpenHelper implements IDataLogDAO {
    private static final String DATABASE_NAME;
    private static final int DATABASE_VERSION;
    private static final String TABLE_LOGS;
    private static final String LOGS_DESCRIPCION;
    private static final String LOGS_FECHA;


    static {
        DATABASE_NAME = "LOGS";
        DATABASE_VERSION = 1;
        TABLE_LOGS = "LOGS";
        LOGS_FECHA = "FECHA" ;
        LOGS_DESCRIPCION = "DESCRIPCION";
    }
    public DataLogSQLiteDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void create(String descripcion){
        Log.d(this.getClass().toString(),"Insertando entrada de log : " + descripcion);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LOGS_DESCRIPCION,descripcion);
        sqLiteDatabase.insert(TABLE_LOGS,null,values);
        //INSERT INTO LOGS(DESCRIPCION) VALUES (_);
    }
    @Override
    public List<DataLog> showLogs(){

        Log.d(this.getClass().toString(),"Listando los logs");
        List<DataLog> logs= new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_LOGS, new String[]{LOGS_FECHA, LOGS_DESCRIPCION}, null, null, null, null, null);
        while(cursor.moveToNext()){
            DataLog log = new DataLog();
            log.setDescripcion(cursor.getString(cursor.getColumnIndex(LOGS_DESCRIPCION)));
            try {
                log.setFecha(DataLog.simpleDateFormat.parse(cursor.getString(cursor.getColumnIndex(LOGS_FECHA))));
            } catch (ParseException e) {
                Log.e("Error fecha","No he podido parsear la fecha " + cursor.getColumnIndex(LOGS_FECHA),e);
            }

            logs.add(log);
        }
        return logs;
    }

    @Override
    public void clearLogs(){
        Log.d(this.getClass().toString(),"Borrando todos los logs");
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_LOGS, null, null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(this.getClass().toString(),"Constuyendo la tabla " + TABLE_LOGS);
        db.execSQL("CREATE TABLE " + TABLE_LOGS + " (" +
                LOGS_DESCRIPCION + " TEXT, " +
                LOGS_FECHA + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
