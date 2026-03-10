import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 2,31, 54, 27, 9, 1);
        System.out.println(list.stream().sorted().filter(i -> i > 10).toList());
        System.out.println(list.stream().filter(i -> i % 2 == 0).toList());
        System.out.println(list.stream().filter(i -> i % 2 == 0).mapToDouble(Integer::doubleValue).sum());

        List<String> list2 = Arrays.asList("hola", "DAM", "IES de Teis", "DAW", "ciaoo!");
        System.out.println(list2.stream().map(i -> i.toUpperCase()).toList());
        System.out.println(list2.stream().map(String::toUpperCase).toList());
        System.out.println(list2.stream().map(i -> i.startsWith("D")).toList());
        System.out.println(list2.stream().map(i -> i.matches("^[Dd].*s")).toList());
    }
}
