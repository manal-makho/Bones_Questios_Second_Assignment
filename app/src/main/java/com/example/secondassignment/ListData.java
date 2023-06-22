package com.example.secondassignment;

public class ListData {

    private String question;
    private int imgID;

    public ListData(String question, int imgID) {
        this.question = question;
        this.imgID = imgID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }
}
