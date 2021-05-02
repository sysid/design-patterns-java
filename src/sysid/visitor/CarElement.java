package sysid.visitor;

public interface CarElement {
    void accept(CarElementVisitor visitor);
}
