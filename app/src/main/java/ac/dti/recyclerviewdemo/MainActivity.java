package ac.dti.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.RecycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movies myMovies[] = new movies[]{
          new movies("Hawa", "2022",R.drawable.hawa),
          new movies("Karagar", "2022",R.drawable.karagar),
          new movies("Damal", "2022",R.drawable.damal),
          new movies("Aynabazi", "2019",R.drawable.aynabazi),
          new movies("Mosari", "2021",R.drawable.mosari)
        };

        movieAdapter adapter = new movieAdapter(myMovies, MainActivity.this);
        recyclerView.setAdapter(adapter);
    }
}