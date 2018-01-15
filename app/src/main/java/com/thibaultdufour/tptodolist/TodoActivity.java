package com.thibaultdufour.tptodolist;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;


/**
 * Created by dufourth on 15/01/2018.
 */
public class TodoActivity extends Activity implements View.OnClickListener {
    private Button btnValider;
    private Button btnVider;
    private EditText edittext_tache;
    private ListView listeView_task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);
        edittext_tache = (EditText) findViewById(R.id.editText_tache);
        listeView_task = (ListView) findViewById(R.id.listView_task);
        btnValider = (Button) findViewById(R.id.button_valider);
        btnVider = (Button) findViewById(R.id.button_viderListe);
        listeView_task.setAdapter(new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, Singleton.getInstance().getListTask()));
        listeView_task.setBackgroundColor(Color.BLACK);
        btnValider.setOnClickListener(this);
        btnVider.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if( v.getId() == btnValider.getId())
        {
            Singleton.getInstance().addTask(edittext_tache.getText().toString()+"\n");
            listeView_task.setAdapter(new ArrayAdapter(getApplicationContext(),
                    android.R.layout.simple_list_item_1, Singleton.getInstance().getListTask()));
            edittext_tache.setText("");
        }
        else if(v.getId() == btnVider.getId())
        {
            Singleton.getInstance().clearTaskList();
            listeView_task.setAdapter(new ArrayAdapter(getApplicationContext(),
                    android.R.layout.simple_list_item_1, Singleton.getInstance().getListTask()));

        }
    }
}
