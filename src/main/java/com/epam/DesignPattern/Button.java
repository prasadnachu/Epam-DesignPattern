package com.epam.DesignPattern;

public class Button {
    private State current;

    public Button() {
        current = OFF.instance();
    }

    public void setCurrent(State s) {
        current = s;
    }

    public void push() {
        current.push(this);
    }
}

class State {
    public void push(Button b) {
        b.setCurrent(OFF.instance());
        System.out.println("   turning OFF");
    }
}

class ON extends State {
    private static ON instance = new ON();

    private ON() {}

    public static State instance() {
        return instance;
    }
}

class OFF extends State {
    private static OFF instance = new OFF();
    private OFF() { }

    public static State instance() {
        return instance;
    }
    public void push(Button b) {
        b.setCurrent(ON.instance());
        System.out.println("   turning ON");
    }
}