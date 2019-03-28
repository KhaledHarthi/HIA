package com.khaledharthi.harajinterviewapp.Models;

public class PostItem {

    String name;
    String imgURL;

    public PostItem(String name, String url){
        this.name=  name;
        this.imgURL = url;
    }


    public String getName(){
        return name;
    }

    public String getImgURL(){
        return imgURL;
    }
}
