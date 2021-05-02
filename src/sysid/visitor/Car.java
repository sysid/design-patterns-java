package sysid.visitor;

import java.util.List;

public class Car implements CarElement {
    private final List<CarElement> elements;

    Car() {
        this.elements = List.of(
                new Wheel("front left"), new Wheel("front right"),
                new Wheel("back left"), new Wheel("back right"),
                new Engine(), new Body()
        );
    }

    @Override
    public void accept(CarElementVisitor visitor) {
        for (CarElement el : elements) {
            el.accept(visitor);
        }
        visitor.visit(this);
    }
}
