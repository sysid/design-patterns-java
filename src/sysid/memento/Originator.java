package sysid.memento;

import org.jetbrains.annotations.NotNull;

public class Originator {
    private String state;
    // The class could also contain additional data that is not part of the
    // state saved in the memento..

    public void setState(String state) {
        this.state = state;  // simplifcation, normally it is an object
        System.out.println("Originator: Setting state to: " + state);
    }

    public Memento saveToMemento() {
        System.out.println("Originator: Saving state to Memento.");
        return new Memento(this.state);
    }

    void restoreFromMemento(@NotNull Memento memento) {
        state = memento.getState();
        System.out.println("Originator: Restoring from Memento: " + state);
    }

    public static class Memento {
        private final String state;


        public Memento(String state) {
            this.state = state;
        }

        // accessible by outer class only
        private String getState() {
            return state;
        }
    }
}
