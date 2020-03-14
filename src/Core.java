
import IT.HW6.MyMap;

public class Core {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyMap<Integer,String> map = new MyMap<>();
        map.put(1,"kek");
        map.put(4,"hui");
        map.put(3,"k");
        MyMap<Integer,String> mapx = (MyMap<Integer, String>) map.clone();
        System.out.println(map.toString());
        System.out.println(mapx.toString());
        System.out.println(map == mapx);


    }
}
