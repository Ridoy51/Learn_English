package com.example.eng3k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class WordsRecViewAdapter extends RecyclerView.Adapter<WordsRecViewAdapter.ViewHolder> {

    private ArrayList<Words> words =new ArrayList<>();
    private Context context;

    public WordsRecViewAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.word_list_items,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtWord.setText(holder.itemView.getContext().getString(R.string.word)+": "+words.get(position).getWord());
        holder.txtMeaning.setText(context.getString(R.string.meaning)+": "+words.get(position).getMeaning());
        holder.txtExample.setText(context.getString(R.string.example)+": "+words.get(position).getExample());
        holder.rememberedButt.setText(context.getString(R.string.remembered));
        holder.rememberedButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, words.get(position).getWord()+" "+context.getString(R.string.remembered), Toast.LENGTH_SHORT).show();
            }
        });
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, words.get(position).getWord()+" Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return words.size();
    }

    public void setWords(ArrayList<Words> words) {
        this.words = words;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtWord,txtMeaning,txtExample;
        private Button rememberedButt;


        private CardView parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtWord= itemView.findViewById(R.id.txtWord);
            txtMeaning = itemView.findViewById(R.id.txtMeaning);
            txtExample= itemView.findViewById(R.id.txtExample);
            parent = itemView.findViewById(R.id.parent);
            rememberedButt= itemView.findViewById(R.id.rememberedButt);
        }
    }
}
