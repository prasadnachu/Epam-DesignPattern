package com.epam.DesignPattern;

public class Singleton {
     
    private static Singleton myObj;
    
    public static Singleton getInstance(){
        if(myObj == null){
            myObj = new Singleton();
        }
        return myObj;
    }
     
    public void getSomeThing(){
        System.out.println("I am Singleton Design Pattern....");
    }
}