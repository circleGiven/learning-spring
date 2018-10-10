package collection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionClient {

    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

        CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");

//        Map<String, Controller> addressList = bean.get();

//        for (String address: addressList) {
//            System.out.println(address.toString());
//        }
//        System.out.println(addressList.toString());

        factory.close();
    }
}
