package com.epam.DesignPattern;

import java.io.*;
import java.awt.*;
import java.util.*;

import com.epam.DesignPattern.Builder;
import com.epam.DesignPattern.Singleton;
import com.epam.DesignPattern.BasicRemote;
import com.epam.DesignPattern.Device;
import com.epam.DesignPattern.Forest;
import com.epam.DesignPattern.Radio;
import com.epam.DesignPattern.Tv;
import com.epam.DesignPattern.Button;
import com.epam.DesignPattern.Command;
import com.epam.DesignPattern.DomesticEngineer;
import com.epam.DesignPattern.Politician;
import com.epam.DesignPattern.Programmer;

/**
 * Hello world!
 *
 */
public class App 
{
	static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 100000;
    static int TREE_TYPES = 2;
    
    public static void main( String[] args ) throws IOException
    {
    	//singleton example
        Singleton st = Singleton.getInstance();
        st.getSomeThing();
        
        System.out.println();
        System.out.println("*********** I'm an example for Builder Design Pattern.....**************\n");
        
        //Builder example
        
        Builder user1 = new Builder.UserBuilder("Dhoni", "MS")
        	    .age(30)
        	    .phone("1234567")
        	    .address("Fake address 1234")
        	    .build();
        	 
        System.out.println(user1);
        	 
        Builder user2 = new Builder.UserBuilder("Sachin", "Tendulkar")
        	    .age(40)
        	    .phone("5655")
        	    .build();
        	 
        System.out.println(user2);
        	 
        Builder user3 = new Builder.UserBuilder("Virat", "Kohli")
        	    .build();
        	 
        System.out.println(user3);
        	    

        System.out.println("************** I'm an example for Bridge Design Pattern...... *********************\n");
        	    	
        testDevice(new Tv());
        testDevice(new Radio());
        	        
        System.out.println("*************** I'm an example for FlyWeight Design Pattern...... *****************\n");
        Forest forest = new Forest();
        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
        	forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
        			"Summer Oak", Color.GREEN, "Oak texture stub");
        	forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
        			"Autumn Oak", Color.BLUE, "Autumn Oak texture stub");
        }        	        
        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);
        System.out.println(TREES_TO_DRAW + " trees drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);       	        
        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
        		"MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
        
        
        InputStreamReader is = new InputStreamReader( System.in );
        
        
        System.out.println("************** I'm an example for Command Design Pattern......**********************\n");
        ArrayList<Object> queue = produceRequests();
        workOffRequests(queue);
        
        
        System.out.println("*************** I'm an example for State Design Pattern......*********************\n");
        Button btn = new Button();
        while (true) {
            System.out.print("Press 'Enter'");
            is.read();
            btn.push();
            System.out.println();
        }
       	        

    }
    public static ArrayList<Object> produceRequests() {
        ArrayList<Object> queue = new ArrayList<Object>();
        queue.add(new DomesticEngineer());
        queue.add(new Politician());
        queue.add(new Programmer());
        return queue;
    }

    public static void workOffRequests(ArrayList<Object> queue) {
        for (Object command : queue) {
            ((Command)command).execute();
        }
    }

    private static int random(int min, int max) {
       	        return min + (int) (Math.random() * ((max - min) + 1));
   }

    public static void testDevice(Device device) {
    	System.out.println("Tests with basic remote.");
    	BasicRemote basicRemote = new BasicRemote(device);
    	basicRemote.power();
    	device.printStatus();
    }
}
