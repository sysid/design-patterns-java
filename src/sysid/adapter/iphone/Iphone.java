package sysid.adapter.iphone;

public class Iphone implements LightningPhone {
    private boolean connector;

    @Override
    public void recharge() {
        if (connector) {
            System.out.println("Recharge started");
            System.out.println("Recharge finished");
        } else {
            System.out.println("Connect Lightning first");
        }
    }

    @Override
    public void useLightning() {
        connector = true;
        System.out.println("Lightning connected");
    }
}
