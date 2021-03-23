package com.example.eng3k;

public class Words {
    private int id;
    private String word;
    private String meaning;
    private String example;

    public Words(int id,String word, String meaning, String example) {
        this.word = word;
        this.meaning = meaning;
        this.example = example;
        this.id=id;
    }

    public String getWord() {
        return word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "Words{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                ", example='" + example + '\'' +
                '}';
    }
}
