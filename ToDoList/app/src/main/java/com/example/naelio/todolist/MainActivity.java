package com.example.naelio.todolist;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Button buttonSave;
    private ListView listViewTasks;
    private EditText editTextNewTask;

    private SQLiteDatabase database;
    private ArrayAdapter<String> tasksAdapter;
    private ArrayList<String> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // recuperando componentes
            buttonSave = findViewById(R.id.buttonSaveID);
            editTextNewTask = findViewById(R.id.editTextNewTaskID);

            // iniciando banco de dados
            database = openOrCreateDatabase("app_task", MODE_PRIVATE, null);

            // criando tabelas
            database.execSQL("CREATE TABLE IF NOT EXISTS tasks(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR)");


            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveTask(editTextNewTask.getText().toString());
                    editTextNewTask.setText("");
                }
            });

            loadTaks();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void saveTask(String text) {
        try {
            if (text.isEmpty()) {
                Toast.makeText(getApplicationContext(), "field task is empty", Toast.LENGTH_SHORT).show();
            } else {
                database.execSQL("INSERT INTO tasks (name) VALUES('" + text + "')");
                Toast.makeText(getApplicationContext(), "save with success", Toast.LENGTH_SHORT).show();
                loadTaks();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadTaks() {
        try {
            // recuperando as tarefas
            Cursor cursor = database.rawQuery("SELECT * FROM tasks ORDER BY id DESC", null);

            // recuperando os ids das colunas
            int indeceCollunID = cursor.getColumnIndex("id");
            int indeceCollunTask = cursor.getColumnIndex("name");

            // my list
            listViewTasks = findViewById(R.id.listViewTasksID);

            // create adapter
            tasks = new ArrayList<>();
            tasksAdapter = new ArrayAdapter<>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    tasks
            );

            listViewTasks.setAdapter(tasksAdapter);

            // listing tasks
            cursor.moveToFirst();
            while (cursor != null) {
                Log.i("Result - ", "Task: " + cursor.getString(indeceCollunTask));
                tasks.add(cursor.getString(indeceCollunTask));
                cursor.moveToNext();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
