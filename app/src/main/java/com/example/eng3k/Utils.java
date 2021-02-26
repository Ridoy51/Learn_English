package com.example.eng3k;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;


    private static ArrayList<Words> allWords;
    private static ArrayList<Words> rememberedWords;

    public Utils() {
        if(null!=allWords){
            allWords=new ArrayList<>();
            initData();
        }
        if (null== rememberedWords){
            rememberedWords=new ArrayList<>();
        }
    }

    private void initData() {
        //Todo: add initial data

        allWords.add(new Words("Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words("Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words("Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words("Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words("Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words("Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words("Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words("Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words("Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words("Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words("Good", "ভালো", "tommy is a good dog"));

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
