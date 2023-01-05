package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.List;

public abstract class Stack<T> {
    public List<T> list;

    public Stack(List<T> list){
        this.list = list;
    }
    public Stack(){
        this.list = new ArrayList<T>();
    }

    public void putBelow(T o){
        this.list.add( o);
    }

    public T pick(T o){
        for (T objective: list){
            if (objective.equals(o)){
                list.remove(objective);
                return o;
            }
        }


        System.out.println("L'objectif voulu n'est pas dans la pile");
        return null;
    }

    public T randomPick(){
        int i = (int) (Math.random() * list.size());
        T o = list.get(i);
        list.remove(o);
        return o;
    }
    public boolean isValid(){
        int count = 0;
        for (T objective: list){
            for (T objective2: list){
                if (objective.equals(objective2)){
                    count++;
                }
            }
        }
        return count<2;
    }


    public String toString(){
        String s = "Pile d'objectifs : ";
        for (T objective: list){
            s += objective.toString() + " ";
        }
        return s;

    }

    public List<T> getStack(){
        return list;
    }

}