package sysid.mediator;

/*
https://en.wikipedia.org/wiki/Mediator_pattern#Java

a Mediator object controls the values of several Storage objects,
forcing the user code to access the stored values through the mediator.
When a storage object wants to emit an event indicating that its value has changed,
it also goes back to the mediator object (via the method notifyObservers) that controls
the list of the observers (implemented using the observer pattern)
 */

public class Demo {
    public static void main(String[] args) {
        Mediator<Integer> mediator = new Mediator<>();
        mediator.setValue("bob", 20);
        mediator.setValue("alice", 24);
        mediator.getValue("alice").ifPresent(age -> System.out.println("age for alice: " + age));

        mediator.addObserver("bob", () -> {
            System.out.println("new age for bob: " + mediator.getValue("bob").orElseThrow(RuntimeException::new));
        });
        mediator.setValue("bob", 21);

        mediator.setValue("xxx", 1);
        mediator.getValue("xxx").ifPresent(i -> System.out.println("xxx: " + i));
        mediator.setValue("xxx", 2);
        mediator.getValue("xxx").ifPresent(i -> System.out.println("xxx: " + i));
    }
}
