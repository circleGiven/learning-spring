package tv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("tv")
public class LgTV implements TV {

//    @Qualifier는 객체를 지정한다
//    @Autowired
//    @Qualifier("apple")

    // @Resource는 @Autowired + @Qualifier
    @Resource(name="apple")
    private Speaker speaker;

    // 기본 생성자가 있어야만 컨테이너가 객체를 생성할 수 있다
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
        speaker.volumnUp();
    }

    public void volumnDown() {
        speaker.volumnDown();
    }
}
