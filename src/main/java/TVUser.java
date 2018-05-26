public class TVUser {
    public static void main(String[] args) {
        // bean
        BeanFactory factory = new BeanFactory();

        TV tv = (TV)factory.getBean("samsung");
        tv.powerOn();
        tv.volumnUp();
        tv.volumnDown();
        tv.powerOff();
    }
}
