package IT.HW7;
import IT.HW6.MyMap;
import java.util.*;
import java.util.stream.Stream;

public class StreamHW {
    public static void run(){

                /*
                Получить сумму длин строк коллекции, которые длиннее 5-ти символов.( активно использовать методы map, count, filter…)
                 */

        ArrayList<String> test = new ArrayList<String>();
        test.add("sdfsdfasdf");
        test.add("");
        Stream<String> stream1 = test.stream();
        System.out.println("Количество строк , с длиной > 5 = " + stream1.filter(n -> n.length() > 5).count());
        System.out.println("____________________________________");

                    /*
                    Сконкотенировать все ключи map.
                     */

        Map<String,Integer> map = new MyMap<>();
        map.put("a",1);
        map.put("i",2);
        map.put("n",3);
        map.put("m",4);
        map.put("nwe",5);
        Stream<String> stream2 = map.keySet().stream();
        StringBuilder s = new StringBuilder();
        stream2.forEach(p -> s.append(p));
        System.out.println("Сконкатенировнные ключи = " + s.toString());
        System.out.println("____________________________________");

                    /*
                    Посчитать количество строк в set, в которых количество гласных больше трёх.
                     */
        Set<String> set = new TreeSet<>();
        set.add("aaaa");
        set.add("aasdfa");
        set.add("asabco");
        set.add("yurii");
        String[] ap = {"e","y","u","i","o","a"};
        Set<String> alf = new HashSet<>();
        for (int i = 0; i < ap.length ; i++) {
            alf.add(ap[i]);
        }
        set.stream().filter(str -> Arrays.stream(str.toLowerCase().split("")).filter(ch -> alf.contains(ch)).count() > 3).forEach(str -> System.out.print(str + " "));
        System.out.println();
        System.out.println("____________________________________");
                    /*
                    Вывести все элементы листа, которые больше самого большого элемента второго листа (с использованием Stream api)
                     */

        ArrayList<Integer> test1 = new ArrayList<>();
        ArrayList<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(4);
        test2.add(3);
        test1.add(1);
        test1.add(10);
        test1.add(116);
        test1.add(228);
        test1.add(0);
        test1.stream().filter(n -> n > test2.stream().max((a, b) -> a - b).get()).forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("____________________________________");




    }
}
