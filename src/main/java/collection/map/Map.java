package collection.map;

import java.util.HashMap;
import java.util.Set;

public class Map {

    public static void main(String[] args) {

        java.util.Map<String, String> map;
        map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        System.out.println(map);

        java.util.Map<String, String> map2;
        map2 = new HashMap<String, String>();
        map.put("key4", "value4");
        map.put("key5", "value5");
        map.put("key6", "value6");

        // Добавление набора данных
        map.putAll(map2);
        // Удаление объекта по ключу
        map.remove("key5");
        // Размер набора
        System.out.println("Размер набора данных : " +
                map.size());
        // Поиск по ключу
        String exists = (map.containsKey("key2")) ?
                "найден" : "не найден";
        System.out.println("Объект с ключом 'key2' "
                + exists);
        // Поиск по значению
        exists = (map.containsValue("value2")) ?
                "найден" : "не найден";
        System.out.println("Объект со значением 'value2' "
                + exists);

        // Перебор значений
        Set<java.util.Map.Entry<String, String>> set;
        set = map.entrySet();
        for (java.util.Map.Entry<String, String> me : set) {
            System.out.print("ключ : " + me.getKey() + ",значение = " + me.getValue());
        }
        // Очистка объекта
        map.clear();

    }
}
