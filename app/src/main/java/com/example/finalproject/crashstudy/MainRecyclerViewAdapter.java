package com.example.finalproject.crashstudy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ExceptionInfo> list;

    public MainRecyclerViewAdapter(ArrayList<ExceptionInfo> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emaker_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder vh = (ViewHolder) holder;
        final ExceptionInfo e = list.get(position);
        vh.tvDesc.setText(e.getDesc());
        vh.btn.setText(e.getName());
        vh.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExceptionMaker.makeException(e.getType());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private Button btn;
        private TextView tvDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.btnTrigger);
            tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}
