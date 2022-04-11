package com.kreitek.editor;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Document {
    private Stack <ArrayList<String>> recordList = new Stack<>();

    public Document (){
        recordList.add(new ArrayList<String>());
    }

    public void add(ArrayList <String> state){
        recordList.add(state);
    }

    public ArrayList <String> pop (){
        try {
            return recordList.pop();
        } catch (EmptyStackException e){
            return recordList.peek();
        }
    }

    public ArrayList <String> peek (){
        return recordList.peek();
    }

}
