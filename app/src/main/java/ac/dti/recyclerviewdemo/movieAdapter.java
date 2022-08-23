package ac.dti.recyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class movieAdapter extends RecyclerView.Adapter<movieAdapter.ViewHolder>{

    movies[] myMovies;
    Context context;

    public movieAdapter(movies[] myMovies, Context context) {
        this.myMovies = myMovies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        movies my_movies = myMovies[position];
        holder.movieName.setText(my_movies.getMovieName());
        holder.movieDate.setText(my_movies.getMovieDate());
        holder.movieImage.setImageResource(my_movies.getMovieImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, my_movies.getMovieName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), DeatailActivity.class);
                intent.putExtra("movieName",my_movies.getMovieName());
                intent.putExtra("movieDate",my_movies.getMovieDate());
                intent.putExtra("movieImage",my_movies.getMovieImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myMovies.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView movieImage;
        TextView movieName;
        TextView movieDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.imageView);
            movieName = itemView.findViewById(R.id.movieName);
            movieDate = itemView.findViewById(R.id.movieDate);
        }
    }
}
