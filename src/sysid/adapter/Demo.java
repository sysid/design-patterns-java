package sysid.adapter;

import sysid.adapter.android.Android;
import sysid.adapter.android.MicroUsbPhone;
import sysid.adapter.iphone.Iphone;
import sysid.adapter.iphone.LightningPhone;

public class Demo {
    public static void main(String[] args) {
        Android android = new Android();
        Iphone iphone = new Iphone();

        System.out.println("Recharging android with MicroUsb");
        rechargingMicroUsbPhone(android);

        System.out.println("Recharging iphone with Lightning");
        rechargingLightning(iphone);

        System.out.println("Recharging iphone with MicroUsb");
        rechargingMicroUsbPhone(new LightningToMicroUsbAdapter(iphone));
    }

    private static void rechargingLightning(LightningPhone phone) {
        phone.useLightning();
        phone.recharge();
    }

    private static void rechargingMicroUsbPhone(MicroUsbPhone phone) {
        phone.useMicroUsb();
        phone.recharge();
    }
}
