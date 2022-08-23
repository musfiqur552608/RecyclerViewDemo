package ac.dti.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DeatailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView name, date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatail);

        imageView = findViewById(R.id.imageView);
        name = findViewById(R.id.movieName);
        date = findViewById(R.id.movieDate);

        Intent intent = this.getIntent();
        if(intent != null){
            String movieName = intent.getStringExtra("movieName");
            String movieDate = intent.getStringExtra("movieDate");
            int movieImage = intent.getIntExtra("movieImage", R.drawable.hawa);

            imageView.setImageResource(movieImage);
            name.setText(movieName);
            date.setText(movieDate);
        }
    }
}