
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] words = str.split("\\s");
        Map<String, Integer> map1 = new LinkedHashMap<>(9);
        List<String> list = Arrays.stream(words).map(element -> element.toLowerCase()
                        .replaceAll("\\p{Punct}", ""))
                .sorted()
                .collect(Collectors.toList());

        for (String s : list) {
            if (map1.containsKey(s)) {
                map1.put(s, map1.get(s) + 1);
            } else {
                map1.put(s, 1);
            }
        }

        map1.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(System.out::println);


    }
}
