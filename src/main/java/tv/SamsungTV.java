package tv;

public class SamsungTV implements TV {

    public Speaker speaker;
    public int price;

    public SamsungTV() {
        System.out.println("==> SamsungTV 객체 생성");
    }

//    public SamsungTV(Speaker speaker) {
//        System.out.println("==> SamsungTV 스피커와 객체 생성");
//        this.speaker = speaker;
//    }
//
//    public SamsungTV(Speaker speaker, int price) {
//        System.out.println("==> SamsungTV 스피커와 객체 그리고 가격 생성");
//        this.speaker = speaker;
//        this.price = price;
//    }

    public void setSpeaker(Speaker speaker) {
        System.out.println("setSpeaker()");
        this.speaker = speaker;
    }

    public void setPrice(int price) {
        System.out.println("setPrice()");
        this.price = price;
    }


    public void initMethod() {
        System.out.println("초기화");
    }

    public void destroyMethod() {
        System.out.println("객체 제거됨");
    }

    public void powerOn() {
        System.out.println("삼성TV --- 전원 on (" + this.price + ")");
    }
    public void powerOff() {
        System.out.println("삼성TV --- 전원 off");
    }
    public void volumnUp() {
//        System.out.println("삼성TV --- 소리 up");
        speaker.volumnUp();
    }
    public void volumnDown() {
//        System.out.println("삼성TV --- 소리 down");
        speaker.volumnDown();
    }
}
