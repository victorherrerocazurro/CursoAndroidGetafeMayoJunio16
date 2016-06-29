package com.example.profesormanana.a22_content_provider;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by profesormanana on 21/6/16.
 */
public class PeliculasSQLiteContentProvider extends ContentProvider {

    private SQLiteDatabase db;
    private static final int CODE_PELICULAS = 1;
    private static final int CODE_PELICULA = 2;
    private static final String PELICULAS_AUTHORITY;
    private static final String PELICULAS_ENTITY;
    private static UriMatcher matcher;


    static {
        PELICULAS_AUTHORITY = "com.example.profesormanana.a22_content_provider";
        PELICULAS_ENTITY = "Pelicula";
        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        // content://com.example.profesormanana.a22_content_provider/Pelicula -> Para todo el contenido
        matcher.addURI(PELICULAS_AUTHORITY,PELICULAS_ENTITY,CODE_PELICULAS);
        // content://com.example.profesormanana.a22_content_provider/Pelicula/7 -> Para la entidad con id = 7
        matcher.addURI(PELICULAS_AUTHORITY,PELICULAS_ENTITY+"/*",CODE_PELICULA);
    }
    @Override
    public boolean onCreate() {
        PeliculasSQLiteDAO dao = new PeliculasSQLiteDAO(getContext());
        db = dao.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (matcher.match(uri)){
            case CODE_PELICULA:
                return db.query(
                        false,
                        PeliculasSQLiteDAO.TABLE_PELICULAS,
                        projection,
                        PeliculasSQLiteDAO.PELICULAS_ID+" = ?",
                        new String[]{uri.getLastPathSegment()},null,null,sortOrder,null);
            case CODE_PELICULAS:
                return db.query(false,PeliculasSQLiteDAO.TABLE_PELICULAS,projection,selection,selectionArgs,null,null,sortOrder,null);
            default:
                throw new UnsupportedOperationException("Operación no soportada");
        }

    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (matcher.match(uri)){
            case CODE_PELICULAS | CODE_PELICULA:
                return "vnd.android.cursor.item/vnd."+PELICULAS_AUTHORITY+"."+PELICULAS_ENTITY;
            default:
                throw new UnsupportedOperationException("Operación no soportada");
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        switch (matcher.match(uri)){
            case CODE_PELICULAS:
                db.insert(PeliculasSQLiteDAO.TABLE_PELICULAS,null,values);
                return Uri.withAppendedPath(uri,values.getAsString(PeliculasSQLiteDAO.PELICULAS_ID));
            default:
                throw new UnsupportedOperationException("Operación no soportada");
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        switch (matcher.match(uri)){
            case CODE_PELICULAS:
                return db.delete(PeliculasSQLiteDAO.TABLE_PELICULAS,PeliculasSQLiteDAO.PELICULAS_ID+" = ?",new String[]{uri.getLastPathSegment()});
            case CODE_PELICULA:
                return db.delete(PeliculasSQLiteDAO.TABLE_PELICULAS,selection,selectionArgs);
            default:
                throw new UnsupportedOperationException("Operación no soportada");
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        switch (matcher.match(uri)){
            case CODE_PELICULAS:
                return db.update(PeliculasSQLiteDAO.TABLE_PELICULAS,values,selection,selectionArgs);
            case CODE_PELICULA:
                return db.update(PeliculasSQLiteDAO.TABLE_PELICULAS,values,PeliculasSQLiteDAO.PELICULAS_ID + " = ?",new String[]{uri.getLastPathSegment()});
            default:
                throw new UnsupportedOperationException("Operación no soportada");
        }
    }
}
