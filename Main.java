import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.util.*;

public class Main {

    public static void main(String[] args) {
       HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
       Map<String, String> map = hazelcastInstance.getMap("default");
       for (int i = 0; i < 100; i++) {
           map.put("key" + i, "value" + i);
       }
    }
}
