package com.example.geochatroom;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Message> msglist = new ArrayList<>();

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView author;
        private final TextView date;
        private final TextView content;

        public ViewHolder(View view) {
            super(view);
            author = (TextView) view.findViewById(R.id.author);
            content = (TextView) view.findViewById(R.id.content);
            date = (TextView) view.findViewById(R.id.date);
        }

        public TextView getAuthor() {
            return author;
        }

        public TextView getDate() {
            return date;
        }

        public TextView getContent() {
            return content;
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_message, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getAuthor().setText(msglist.get(position).getAuthor());
        viewHolder.getDate().setText("" + msglist.get(position).getTimestamp());
        viewHolder.getContent().setText(msglist.get(position).getContent());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return msglist.size();
    }

    public void addMessage(Message message) {
        msglist.add(message);
        notifyDataSetChanged();
    }

    public void clearMessages() {
        msglist.clear();
    }
}
