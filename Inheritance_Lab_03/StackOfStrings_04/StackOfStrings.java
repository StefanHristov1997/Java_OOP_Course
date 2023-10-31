package StackOfStrings_04;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        data.add(0,item);
    }

    public String pop(){
        return data.remove(0);
    }

    public String peek(){
        return data.get(0);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
}
