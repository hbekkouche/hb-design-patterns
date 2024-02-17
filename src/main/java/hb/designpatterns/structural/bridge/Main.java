package hb.designpatterns.structural.bridge;

// Abstraction
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void powerOn();

    public abstract void powerOff();

    public abstract void volumeUp();

    public abstract void volumeDown();
}

// Implementor interface for device
interface Device {
    void powerOn();

    void powerOff();

    void setVolume(int volume);

    int getVolume();
}

// Concrete implementor - TV
class TV implements Device {

    private int volume;

    @Override
    public void powerOn() {
        System.out.println("TV is powered on");
    }

    @Override
    public void powerOff() {
        System.out.println("TV is powered off");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("TV volume set to " + volume);
    }

    @Override
    public int getVolume() {
        return volume;
    }
}

// Concrete implementor - Stereo
class Stereo implements Device {

    private int volume;

    @Override
    public void powerOn() {
        System.out.println("Stereo is powered on");
    }

    @Override
    public void powerOff() {
        System.out.println("Stereo is powered off");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Stereo volume set to " + volume);
    }

    @Override
    public int getVolume() {
        return volume;
    }
}

// Refined abstraction - Physical remote control
class PhysicalRemoteControl extends RemoteControl {
    public PhysicalRemoteControl(Device device) {
        super(device);
    }

    @Override
    public void powerOn() {
        System.out.println("Physical remote: Powering on the device");
        device.powerOn();
    }

    @Override
    public void powerOff() {
        System.out.println("Physical remote: Powering off the device");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        System.out.println("Physical remote: Increasing volume");
        device.setVolume(device.getVolume() + 1);
    }

    @Override
    public void volumeDown() {
        System.out.println("Physical remote: Decreasing volume");
        device.setVolume(device.getVolume() - 1);
    }
}

// Refined abstraction - Smartphone app remote control
class SmartphoneRemoteControl extends RemoteControl {
    public SmartphoneRemoteControl(Device device) {
        super(device);
    }

    @Override
    public void powerOn() {
        System.out.println("Smartphone app: Powering on the device");
        device.powerOn();
    }

    @Override
    public void powerOff() {
        System.out.println("Smartphone app: Powering off the device");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        System.out.println("Smartphone app: Increasing volume");
        device.setVolume(device.getVolume() + 1);
    }

    @Override
    public void volumeDown() {
        System.out.println("Smartphone app: Decreasing volume");
        device.setVolume(device.getVolume() - 1);
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        // Creating devices
        Device tv = new TV();
        Device stereo = new Stereo();

        // Using physical remote control with TV
        RemoteControl physicalRemoteForTV = new PhysicalRemoteControl(tv);
        physicalRemoteForTV.powerOn();
        physicalRemoteForTV.volumeUp();

        // Using smartphone app remote control with stereo
        RemoteControl smartphoneRemoteForStereo = new SmartphoneRemoteControl(stereo);
        smartphoneRemoteForStereo.powerOn();
        smartphoneRemoteForStereo.volumeDown();
    }
}

