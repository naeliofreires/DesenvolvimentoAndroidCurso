package com.br.ufc.introductionsqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase database = openOrCreateDatabase("APP", MODE_PRIVATE, null);

            // create table
            database.execSQL("CREATE TABLE IF NOT EXISTS PEOPLES(NAME VARCHAR, AGE INT(3))");

            // insert date
            database.execSQL("INSERT INTO PEOPLES(NAME,AGE) VALUES ('NAELIO FREIRES', 22)");
            database.execSQL("INSERT INTO PEOPLES(NAME,AGE) VALUES ('NARCISO ROBERTO', 11)");
            database.execSQL("INSERT INTO PEOPLES(NAME,AGE) VALUES ('NEGAO', 1)");
            database.execSQL("INSERT INTO PEOPLES(NAME,AGE) VALUES ('GIOVANNA', 16)");

            Cursor cursor = database.rawQuery("SELECT NAME,AGE FROM PEOPLES", null);

            int indexColumnName = cursor.getColumnIndex("NAME");
            int indexColumnAge = cursor.getColumnIndex("AGE");

            cursor.moveToFirst();

            while (cursor != null){
                Log.i("Result - Name:", cursor.getString(indexColumnName));
                Log.i("Result - Age :", cursor.getString(indexColumnAge));

                cursor.moveToNext();
            }
        }catch (Exception ex){ ex.printStackTrace(); }

    }
}
