package com.example.usuario.favoritos2;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Browser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class MainActivity extends Activity {
    private Button boton;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = findViewById(R.id.textView);
        boton = findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sURL="";
                String sVisitado="";
                resultado.setText("");

                Uri miUri= Browser.BOOKMARKS_URI;

                ContentResolver contentResolver = getContentResolver();

                String [] columnas = new String[]{
                        Browser.BookmarkColumns.URL,
                        Browser.BookmarkColumns.VISITS};
                Cursor cursor = contentResolver.query(miUri,
                        columnas,
                        null,
                        null,
                        null);

                if (cursor.moveToFirst()){
                    int columnaURL = cursor.getColumnIndex(Browser.BookmarkColumns.URL);
                    int columnaVisits = cursor.getColumnIndex(Browser.BookmarkColumns.VISITS);

                    do{
                        sURL = cursor.getString(columnaURL);
                        sVisitado = cursor.getString(columnaVisits);
                    }while (cursor.moveToNext());
                }

            }
        });
    }
}