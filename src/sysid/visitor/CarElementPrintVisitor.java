package sysid.visitor;

public class CarElementPrintVisitor implements CarElementVisitor {
    @Override
    public void visit(Body body) {
        System.out.println("Visiting " + body.getClass());
    }

    @Override
    public void visit(Car car) {
        System.out.println("Visiting " + car.getClass());
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Visiting " + engine.getClass());
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Visiting " + wheel.getClass() + " " + wheel.getName());
    }
}
