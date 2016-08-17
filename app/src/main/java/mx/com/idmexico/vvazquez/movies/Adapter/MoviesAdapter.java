package mx.com.idmexico.vvazquez.movies.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mx.com.idmexico.vvazquez.movies.Model.Movie;
import mx.com.idmexico.vvazquez.movies.R;

/**
 * Created by sistemas on 17/08/2016.
 */

    public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

        private List<Movie> movies;
        private int rowLayout;
        private Context context;


        public static class MovieViewHolder extends RecyclerView.ViewHolder {
            LinearLayout moviesLayout;
            TextView movieTitle;
            TextView data;
            TextView movieDescription;
            TextView rating;
            ImageView movieImage;


            public MovieViewHolder(View v) {
                super(v);
                moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
                movieTitle = (TextView) v.findViewById(R.id.title);
                data = (TextView) v.findViewById(R.id.subtitle);
                movieDescription = (TextView) v.findViewById(R.id.description);
                rating = (TextView) v.findViewById(R.id.rating);
                movieImage = (ImageView) v.findViewById(R.id.movie_image);
            }
        }

        public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
            this.movies = movies;
            this.rowLayout = rowLayout;
            this.context = context;
        }

        @Override
        public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
            return new MovieViewHolder(view);
        }


        @Override
        public void onBindViewHolder(MovieViewHolder holder, final int position) {
            holder.movieTitle.setText(movies.get(position).getTitle());
            holder.data.setText(movies.get(position).getReleaseDate());
            holder.movieDescription.setText(movies.get(position).getOverview());
            holder.rating.setText(movies.get(position).getVoteAverage().toString());
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500/"+movies.get(position).getPosterPath()).into(holder.movieImage);
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }
    }

