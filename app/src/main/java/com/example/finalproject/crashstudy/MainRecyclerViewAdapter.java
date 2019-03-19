package com.example.finalproject.crashstudy;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ExceptionInfo> mList;
    private Context mContext;

    public MainRecyclerViewAdapter(ArrayList<ExceptionInfo> list, Context context) {
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emaker_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder vh = (ViewHolder) holder;
        final ExceptionInfo e = mList.get(position);
        vh.tvDesc.setText(e.getDesc());
        vh.btn.setText(e.getName());
        vh.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExceptionMaker.makeException(e.getType(), mContext);
            }
        });

        if (e.isMainThread()) {
            vh.tvLabelThread.setTextColor(ContextCompat.getColor(mContext, R.color.label_selected));
            vh.tvLabelThread.setBackgroundResource(R.drawable.label_bg_selected);
        }
        if (e.isCatch()) {
            vh.tvLabelCatch.setTextColor(ContextCompat.getColor(mContext, R.color.label_selected));
            vh.tvLabelCatch.setBackgroundResource(R.drawable.label_bg_selected);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private Button btn;
        private TextView tvDesc;
        private TextView tvLabelThread;
        private TextView tvLabelCatch;

        public ViewHolder(View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.btnTrigger);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvLabelThread = itemView.findViewById(R.id.tvLabelThread);
            tvLabelCatch = itemView.findViewById(R.id.tvLabelCatch);
        }
    }
}
