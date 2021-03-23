package com.example.eng3k;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;
    private static ArrayList<Words> allWords;
    private static ArrayList<Words> rememberedWords;
    private Context context;


    public Utils() {
        if(null==allWords){
            allWords=new ArrayList<>();
            initData();
        }
        if (null== rememberedWords){
            rememberedWords=new ArrayList<>();
        }
    }

    private void initData() {
        //Todo: add initial data

        allWords.add(new Words(1,"Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words(2,"Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words(3,"Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words(4,"Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words(5,"Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words(6,"Good", "ভালো", "tommy is a good dog"));

    }

    public static Utils getInstance() {
        if(null!=instance){
            return instance;
        }else {
            instance=new Utils();
            return instance;
        }

    }

    public static ArrayList<Words> getAllWords() {

        return allWords;
    }

    public static ArrayList<Words> getRememberedWords() {
        return rememberedWords;
    }
}
