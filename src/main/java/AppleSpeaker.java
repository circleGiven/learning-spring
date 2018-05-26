public class AppleSpeaker implements Speaker {

    public AppleSpeaker() {
        System.out.println("===> AppleSpeaker 생성");
    }

    public void volumnUp() {
        System.out.println("AppleSpeaker --- 소리 up");
    }

    public void volumnDown() {
        System.out.println("AppleSpeaker --- 소리 down");
    }
}
