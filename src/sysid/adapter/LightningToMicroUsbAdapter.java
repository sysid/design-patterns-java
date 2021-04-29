package sysid.adapter;

import sysid.adapter.android.MicroUsbPhone;
import sysid.adapter.iphone.LightningPhone;

public class LightningToMicroUsbAdapter implements MicroUsbPhone {
    private final LightningPhone lightningPhone;

    public LightningToMicroUsbAdapter(LightningPhone lightningPhone) {
        this.lightningPhone = lightningPhone;
        System.out.println("Using Adapter");
    }

    @Override
    public void recharge() {
        lightningPhone.recharge();
    }

    @Override
    public void useMicroUsb() {
        System.out.println("MicroUsb connected.");
        lightningPhone.useLightning();
    }
}
