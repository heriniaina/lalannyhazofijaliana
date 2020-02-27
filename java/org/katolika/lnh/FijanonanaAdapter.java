package org.katolika.lnh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class FijanonanaAdapter extends ListAdapter<Fijanonana, FijanonanaAdapter.FijanonanaHolder> {

    private OnRowClickListener onRowClickListener;

    private static final DiffUtil.ItemCallback<Fijanonana> DIFF_CALLBACK = new DiffUtil.ItemCallback<Fijanonana>() {
        @Override
        public boolean areItemsTheSame(@NonNull Fijanonana oldItem, @NonNull Fijanonana newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Fijanonana oldItem, @NonNull Fijanonana newItem) {
            return oldItem.getLohateny().equals(newItem.getLohateny());
        }
    };

    protected FijanonanaAdapter() {
        super(DIFF_CALLBACK);
    }


    @NonNull
    @Override
    public FijanonanaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_detail, parent, false);
        return new FijanonanaHolder(view, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull FijanonanaHolder holder, int position) {
        holder.textFijanonana.setText(String.format(holder.itemView.getContext().getString(R.string.fijanonana), Util.toRoman(position + 1)));
        holder.textView.setText(getItem(position).getLohateny());

    }

    class FijanonanaHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textFijanonana;

        public FijanonanaHolder(@NonNull View itemView, ViewGroup parent) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textFijanonana = itemView.findViewById(R.id.textFijanonana);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onRowClickListener != null)
                    {
                        onRowClickListener.onClick(getItem(getAdapterPosition()));
                    }
                }
            });
        }
    }

    public void setOnRowClickListener(OnRowClickListener onRowClickListener) {
        this.onRowClickListener = onRowClickListener;
    }
}
