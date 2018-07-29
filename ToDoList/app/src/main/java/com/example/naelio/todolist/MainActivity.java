package com.example.naelio.todolist;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    private ArrayList<Integer> ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // recuperando componentes
            buttonSave = findViewById(R.id.buttonSaveID);
            editTextNewTask = findViewById(R.id.editTextNewTaskID);

            // my list
            listViewTasks = findViewById(R.id.listViewTasksID);

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

            listViewTasks.setLongClickable(true);
            listViewTasks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Log.i("Result - ", "Position: " + position);

                    deleteTask(ids.get(position));
                    return true;
                }
            });

            loadTasks();

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
                loadTasks();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadTasks() {
        try {
            // recover tasks
            Cursor cursor = database.rawQuery("SELECT * FROM tasks ORDER BY id DESC", null);

            // recover ids columns
            int indeceCollunID = cursor.getColumnIndex("id");
            int indeceCollunTask = cursor.getColumnIndex("name");

            // create adapter
            tasks = new ArrayList<>();
            ids = new ArrayList<>();

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
                ids.add(Integer.parseInt(cursor.getString(indeceCollunID)));

                cursor.moveToNext();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void deleteTask(Integer index) {
        try {
            database.execSQL("DELETE FROM tasks WHERE id = " + index);
            loadTasks();
            Toast.makeText(getApplicationContext(), "deleted with success", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
