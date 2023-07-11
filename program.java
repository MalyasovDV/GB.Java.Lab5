import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


public class program {
    /**
     * Есть тест. Нужно извлечь из него все слова и отсортировать по длине.
     * Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица
     * проснись
     *
     * и
     * ты
     * Еще
     * день друг Пора
     * ..
     */
    public static void collectStats(String text) {
        List<String> listStr = Arrays.asList(text.split(" "));
        Map<Integer, List<String>> stats = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        for (String str: listStr) {
            stats.putIfAbsent(str.length(), new ArrayList<String>());
            result.add(str);
            result.addAll(stats.get(str.length()));
            stats.put(str.length(), result);
            result = new ArrayList<>();
        }
        
        for (List<String> value: stats.values())
            System.out.println(value);
    }

    // *--> Не нашел другого способа возврата смерженного листа, кроме как через
    // Stream, отдельную функцию не стал писать
    public static void main(String[] args) {
        String text = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        collectStats(text);
    }

}