package com.example.profesormanana.a31_content_provider_contacts;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by profesormanana on 28/6/16.
 */
public class ContactosProvider {

    private Context context;

    public ContactosProvider(Context context) {
        this.context = context;
    }
    public List<String> getContactos(){
        List<String> contactos = new ArrayList<>();
        ContentResolver resolver = context.getContentResolver();
        Cursor query = resolver.query(ContactsContract.Contacts.CONTENT_URI,// URI de comunicacion con el provider
                new String[]{ContactsContract.Contacts.DISPLAY_NAME},// Columnas a devolver
                null, // Condicion de query DISPLAY_NAME = ? AND FIRST_NAME = ?
                null, // Argumentos new String[]{"Vic","Victor"}
                null // Order by
        );
        while(query.moveToNext()){
            contactos.add(query.getString(query.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
        }
        query.close();

        return contactos;
    }
}
