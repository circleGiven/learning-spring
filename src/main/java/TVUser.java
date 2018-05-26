import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TVUser {
    public static void main(String[] args) {
        // BeanFactory로 컨테이너 구동 방식
        // 이 방식은 컨테이너가 구동될때가 아닌 클라이언트의 요청에 의해서만 bean 객체가 생성된다.
        // 즉 지연로딩(Lazy loading) 방식이다.
        // 따라서 일반적인 스프링 프로젝트에서는 이 방식이 사용되지 않는다,
//        BeanFactory factory = new BeanFactory();
//
//        TV tv = (TV)factory.getBean("samsung");
//        tv.powerOn();
//        tv.volumnUp();
//        tv.volumnDown();
//        tv.powerOff();
        // 1. spring 컨테이너 구동 (applicationContext 컨테이너 구동 방식)
        // 이 방식은 구동될때 bean으로 등록돈 클래스의 객체를 생성하는 즉시로딩(pre-loading) 방식으로 동작한다.
        // applicationContext의 구현은 다양하나 많이 쓰이는건 두가지 뿐이다.
        // 파일 시스템이나 클래스 경로에 있는 XML 설정 파일을 로딩하여 구동하는 GenericXmlApplicationContext
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
        // 웹 기반의 스프링 어플리케이션을 개발할때 사용하는 XmlWebApplicationContext
//        AbstractApplicationContext factory = new XmlWebApplicationContext();



        // 2. spring 컨테이너로부터 필요한 객체 요청(LookUp)
        // LookUp 요청할때는 applicationContext 파일 안에 등록된 Bean에 id로 요청한다
        TV tv = (TV)factory.getBean("tv");
        // scope가 prototype인 경우에 생성이 된다.
//        TV tv1 = (TV)factory.getBean("tv");
//        TV tv2 = (TV)factory.getBean("tv");
        tv.powerOn();
        tv.volumnUp();
        tv.volumnDown();
        tv.powerOff();

        // 3. spring 컨테이너 종료
        // 객체 제거
        factory.close();
    }
}
