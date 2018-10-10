package collection;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionBean {

    private Map<String, Controller> addressList;

    public void setAddressList(Map<String, Controller> addressList) {
        this.addressList = addressList;
    }
}
