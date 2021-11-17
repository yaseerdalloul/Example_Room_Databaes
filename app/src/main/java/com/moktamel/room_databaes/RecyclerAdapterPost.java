package com.moktamel.room_databaes;


import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerAdapterPost extends RecyclerView.Adapter<RecyclerAdapterPost.HomeArticleViewHolder> {
    Context context;
    public List<Post> data;
    private LayoutInflater inflater;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int i, Post article);
    }

    class HomeArticleViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTV, bodyTV;
        public HomeArticleViewHolder(View itemView) {
            super(itemView);
            this.titleTV = itemView.findViewById(R.id.TxtTitlePostItem);
            this.bodyTV = itemView.findViewById(R.id.TxtBodyPostItem);

            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(view, getAdapterPosition(), (Post) data.get(getAdapterPosition()));
                    }
                }
            });

        }

        private void bind(Post model) {
            this.titleTV.setText(model.getTitle());
            this.bodyTV.setText(model.getBody());
        }
    }

    public RecyclerAdapterPost(Context context, List<Post> data) {
        this.context = context;
        this.data = data;
    }

    public HomeArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new HomeArticleViewHolder(this.inflater.inflate(R.layout.post_item, parent, false));

    }

    public int getItemCount() {
        return this.data.size();
    }

    public void onBindViewHolder(HomeArticleViewHolder vh, int position) {

        vh.bind((Post) this.data.get(position));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public int getPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) dp, this.context.getResources().getDisplayMetrics());
    }



}
