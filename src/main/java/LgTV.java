public class LgTV implements TV {

    public LgTV() {
        System.out.println("==> LgTV 객체 생성");
    }

    public void powerOn() {
        System.out.println("LGTV --- 전원 on");
    }

    public void powerOff() {
        System.out.println("LGTV --- 전원 off");
    }

    public void volumnUp() {
        System.out.println("LGTV --- 소리 up");
    }

    public void volumnDown() {
        System.out.println("LGTV --- 소리 down");
    }
}
