package com.example.eng3k;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

import static com.example.eng3k.WordListActivity.mContext;

public class WordsRecViewAdapter extends RecyclerView.Adapter<WordsRecViewAdapter.ViewHolder> {
    private static final String TAG = "WordsRecViewAdapter";
    private ArrayList<Words> words =new ArrayList<>();
    private Context context;
    private TextToSpeech mtts;

    private String parentActivity;


    public WordsRecViewAdapter(Context context, String parentActivity) {
        this.context = context;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.word_list_items,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.txtWord.setText(holder.itemView.getContext().getString(R.string.word)+": "+words.get(position).getWord());
        holder.txtMeaning.setText(context.getString(R.string.meaning)+": "+words.get(position).getMeaning());
        holder.txtExample.setText(context.getString(R.string.example)+": "+words.get(position).getExample());
        holder.rememberedButt.setText(context.getString(R.string.remembered));

        if(parentActivity.equals("rememberedwords")){
            holder.rememberedButt.setVisibility(View.GONE);
        }
        else if(parentActivity.equals("allwords")){

            holder.rememberedButt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(Utils.getInstance(mContext).addtorememberwords(words.get(position))) {

                        if (Utils.getInstance(mContext).removeWord(words.get(position))) {
                            Toast.makeText(context, "REMEMBERED", Toast.LENGTH_SHORT).show();
                            notifyDataSetChanged();
                            holder.rememberedButt.setVisibility(View.GONE);

                        }
                    }

                }
            });

        }

        holder.speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtts= new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status==TextToSpeech.SUCCESS){
                            mtts.setLanguage(Locale.US);
                            mtts.speak(words.get(position).getWord(),TextToSpeech.QUEUE_FLUSH,null);
                        }
                    }
                });
                Toast.makeText(context, words.get(position).getWord(), Toast.LENGTH_SHORT).show();
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
        private Button speech;


        private CardView parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtWord= itemView.findViewById(R.id.txtWord);
            txtMeaning = itemView.findViewById(R.id.txtMeaning);
            txtExample= itemView.findViewById(R.id.txtExample);
            parent = itemView.findViewById(R.id.parent);
            speech=itemView.findViewById(R.id.speech);
            rememberedButt= itemView.findViewById(R.id.rememberedButt);
        }
    }
}
