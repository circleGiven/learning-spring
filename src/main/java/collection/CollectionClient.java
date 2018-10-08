package collection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Set;

public class CollectionClient {

    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

        CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");

        Set<String> addressList = bean.getAddressList();

        for (String address: addressList) {
            System.out.println(address.toString());
        }

        factory.close();
    }
}
