public class SamsungTV implements TV {

    public SamsungTV() {
        System.out.println("==> SamsungTV 객체 생성");
    }

    public void powerOn() {
        System.out.println("삼성TV --- 전원 on");
    }
    public void powerOff() {
        System.out.println("삼성TV --- 전원 off");
    }
    public void volumnUp() {
        System.out.println("삼성TV --- 소리 up");
    }
    public void volumnDown() {
        System.out.println("삼성TV --- 소리 down");
    }
}
