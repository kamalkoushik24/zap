package edu.harvard.cs50.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NotesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static NoteDatabase noteDatabase;
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteDatabase = Room.databaseBuilder(getApplicationContext(), NoteDatabase.class, "notes")
                .allowMainThreadQueries().build();
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new NotesAdapter();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        FloatingActionButton button = findViewById(R.id.add_note_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteDatabase.noteDao().create();
                adapter.reload();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.reload();
    }


}