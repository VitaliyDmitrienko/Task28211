import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InstantiationException, NoSuchFieldException,
            InvocationTargetException {

        HashMap map = new HashMap(); //Создадим объект класса HashMap
        Class<?> clazz = map.getClass(); //Получим у него класс
        //Создадим новый объект класса HashMap
        HashMap instance = (HashMap) clazz.getConstructor().newInstance();
        //Получим у созданного объекта поле size
        Field field = instance.getClass().getDeclaredField("size");
        //Установим доступность поля
//        System.out.println(field.trySetAccessible());

//        if (field.trySetAccessible()) {
//        try {
        field.setAccessible(true);
        //Установим полю size значение 10
        field.setInt(instance, 10);

//        } catch (Exception e) {
//            throw new RuntimeException(e);
//            e.printStackTrace();


        System.out.println("Map is empty: " + instance.isEmpty());
        System.out.println("Map size:" + instance.size());
        System.out.println("Values: " + instance.toString());
    }

}