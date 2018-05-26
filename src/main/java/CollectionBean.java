
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {

//    private List<String> addressList;
//    private Set<String> addressList;
//    private Map<String, String> addressList;
    private Properties addressList;

    public void setAddressList(Properties addressList) {
        this.addressList = addressList;
    }

    public Properties getAddressList() {
        return this.addressList;
    }
}
