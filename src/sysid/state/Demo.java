package sysid.state;

public class Demo {

    public static void main(String[] args) {
        StateContext context = new StateContext();
        System.out.println("Hello world");

        context.writeName("Monday");
        context.writeName("Tuesday");
        context.writeName("Wednesday");
        context.writeName("Thursday");
        context.writeName("Friday");
        context.writeName("Saturday");
        context.writeName("Sunday");
    }
}
