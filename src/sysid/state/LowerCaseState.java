package sysid.state;

class LowerCaseState implements State {

    @Override
    public void writeName(StateContext context, String name) {
        System.out.println(name.toLowerCase());
        context.setState(new UpperCaseState());
    }
}
