package com.example.yushen.comp6442_assignment_1_2016;

/**
 * Created by yushen on 19/03/2016.
 */
public class Newnote {
    private int id;
    private String  name;
    private String content;

    public Newnote(){

    }

    public Newnote(int id,String name, String content){
        this.id=id;
        this.name=name;
        this.content=content;
}
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
}
    public void setContent(String content){
        this.content=content;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getContent(){
        return content;
    }
}
