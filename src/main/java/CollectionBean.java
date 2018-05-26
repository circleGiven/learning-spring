
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionBean {

//    private List<String> addressList;
//    private Set<String> addressList;
    private Map<String, String> addressList;

    public void setAddressList(Map<String, String> addressList) {
        this.addressList = addressList;
    }

    public Map<String, String> getAddressList() {
        return this.addressList;
    }
}
