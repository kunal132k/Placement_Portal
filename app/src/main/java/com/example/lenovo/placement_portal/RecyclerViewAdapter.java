package com.example.lenovo.placement_portal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    @NonNull
    Context context;
    String b;
    List<Model>mm;
   public String card11,card12;

    public RecyclerViewAdapter(List<Model>mm){
      this.mm=mm;

    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view,viewGroup,false);
        context=viewGroup.getContext();
        return new RecyclerViewAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        String card1a=mm.get(i).getCard1();
        String card2a=mm.get(i).getCard2();
        viewHolder.card111.setText(card1a);
        viewHolder.card222.setText(card2a);
    }

    @Override
    public int getItemCount() {
        return mm.size();

    }
    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView card111,card222;
        View mview;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mview=itemView;
            card111=mview.findViewById(R.id.card1);
            card222=mview.findViewById(R.id.card2);
        }
    }
}
