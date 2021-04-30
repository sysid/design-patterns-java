package sysid.state;

public class UpperCaseState implements State {

    @Override
    public void writeName(StateContext context, String name) {
        System.out.println(name.toUpperCase());
        context.setState(new LowerCaseState());
    }
}
