package edu.harvard.cs50.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NoteActivity extends AppCompatActivity {
    private EditText editText;
    private int id;
    private NoteDatabase noteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        editText = findViewById(R.id.note_edit_text);
        String contents = getIntent().getStringExtra("contents");
        final Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        id = getIntent().getIntExtra("id", 0);
        editText.setText(contents);
        FloatingActionButton delbtn = findViewById(R.id.note_delete);
        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.noteDatabase.noteDao().delete(id);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "Note Deleted", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.noteDatabase.noteDao().save(editText.getText().toString(), id);
    }
}