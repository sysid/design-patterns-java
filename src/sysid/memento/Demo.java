package sysid.memento;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Originator.Memento> savedStates = new ArrayList<Originator.Memento>();

        Originator originator = new Originator();

        originator.setState("state1");
        savedStates.add(originator.saveToMemento());
        originator.setState("state2");
        savedStates.add(originator.saveToMemento());
        originator.setState("state3");
        savedStates.add(originator.saveToMemento());
        originator.setState("state4");

        originator.restoreFromMemento(savedStates.get(1));
    }
}
