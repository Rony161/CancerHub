package com.example.joy.cancerhub.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joy.cancerhub.R;
import com.example.joy.cancerhub.models.CancerType;

import java.util.List;

public class CancerTAdapter extends RecyclerView.Adapter<CancerTAdapter.MyViewHolder> {

        private List<CancerType> cancerList;
        public CancerTAdapter(List<CancerType> cancerList) {
            this.cancerList = cancerList;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView textCancer;
            public MyViewHolder(View itemView) {
                super(itemView);

                textCancer = itemView.findViewById(R.id.textVCancerType);
            }
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_cancer_types,parent,false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            CancerType cancer = cancerList.get(position);
            holder.textCancer.setText(cancer.getName());

        }

        @Override
        public int getItemCount() {
            return cancerList.size();
        }

}