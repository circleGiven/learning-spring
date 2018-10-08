package polymorphism;

public class LgTV implements TV {

    public void powerOn() {
        System.out.println("LgTV---전원 켠다.");
    }

    public void powerOff() {
        System.out.println("LgTV---전원 끈다.");
    }

    public void volumnUp() {
        System.out.println("LgTV---소리 울린다,");
    }

    public void volumnDown() {
        System.out.println("LgTV---소리 내린다.");
    }
}
