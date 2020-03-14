import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
    //关联性容器
    //搜索kv结构
    public static void testMap() {
        //Map：key不重复，value可重复
        //
        Map<String,String> map = new TreeMap<>();
        map.put("wei","123456");
        System.out.println(map.get("wei"));
        map.put("gu","234567");
        map.put("zhao","456789");
        map.put("li","234678");
        System.out.println(map.get("wei"));
        System.out.println(map.get("zhao"));
        //System.out.println(map.remove("wei"));
        //System.out.println(map.remove("wei"));

        System.out.println(map.get("we"));
        System.out.println(map.getOrDefault("we","00000"));

        System.out.println(map.containsKey("wei"));
        System.out.println(map.containsValue("123456"));

        System.out.println("keySet:");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key);
        }
        System.out.println("values:");
        Collection<String> values = map.values();
        for (String v : values) {
            System.out.println(v);
        }
        System.out.println("EntrySet:");
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for (Map.Entry<String,String> es : entrySet) {
            System.out.println(es.getKey()+"-->"+es.getValue());
        }
    }

    public static void main(String[] args) {
        testMap();
    }
}
