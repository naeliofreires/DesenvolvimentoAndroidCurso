package com.example.naelio.todolist;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

    private Button buttonSave;
    private ListView listViewTasks;
    private EditText editTextNewTask;

    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // recuperando componentes
            buttonSave = findViewById(R.id.buttonSaveID);
            listViewTasks = findViewById(R.id.listViewTasksID);
            editTextNewTask = findViewById(R.id.editTextNewTaskID);

            // iniciando banco de dados
            database = openOrCreateDatabase("app_task", MODE_PRIVATE, null);

            // criando tabelas
            database.execSQL("CREATE TABLE IF NOT EXISTS tasks(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR)");


            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String text = editTextNewTask.getText().toString();
                    database.execSQL("INSERT INTO tasks (name) VALUES('" + text + "')");
                }
            });

            // recuperando as tarefas
            Cursor cursor = database.rawQuery("SELECT * FROM tasks", null);

            // recuperando os ids das colunas
            int indeceCollunID = cursor.getColumnIndex("id");
            int indeceCollunTask = cursor.getColumnIndex("name");

            cursor.moveToFirst();
            // listando tarefas
            while (cursor != null) {
                Log.i("Resultado - ", "Tarefa: " + cursor.getString(indeceCollunTask));
                cursor.moveToNext();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
