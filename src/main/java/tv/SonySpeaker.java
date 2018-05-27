package tv;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {

    public SonySpeaker() {
        System.out.println("===> SonySpeaker 객체 생성");
    }

    public void volumnUp() {
        System.out.println("SonySpeaker --- 소리 up");
    }

    public void volumnDown() {
        System.out.println("SonySpeaker --- 소리 down");
    }
}
