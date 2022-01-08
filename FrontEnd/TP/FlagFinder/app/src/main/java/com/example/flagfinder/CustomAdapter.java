package com.example.flagfinder;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Country> countrylist = new ArrayList<>();

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
        }

        public TextView getName() {
            return name;
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_country, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getName().setText("" + countrylist.get(position).getName());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return countrylist.size();
    }

    public void addCountry(Country country) {
        countrylist.add(country);
        notifyDataSetChanged();
    }

    public void clearCountries() {
        countrylist.clear();
    }
}
