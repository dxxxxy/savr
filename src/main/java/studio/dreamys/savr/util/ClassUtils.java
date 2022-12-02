package studio.dreamys.savr.util;

import org.reflections.Reflections;
import studio.dreamys.savr.annotation.SavrList;
import studio.dreamys.savr.annotation.SavrWrld;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassUtils {
    public static List<Class<?>> primitiveWrappers = Arrays.asList(
            Integer.class,
            Long.class,
            Float.class,
            Double.class,
            Boolean.class,
            Character.class,
            Byte.class,
            Short.class
    );

    public static String fieldToString(Field field, Object instance) throws IllegalAccessException {
        StringBuilder fieldAsString = new StringBuilder();

        //check if field is primitive
        if (primitiveWrappers.contains(field.get(instance).getClass())) {
            fieldAsString.append(field.getName()).append("=").append(field.get(instance)).append(", ");
        }

        //check if field is a String
        else if (field.get(instance).getClass().equals(String.class)) {
            fieldAsString.append(field.getName()).append("='").append(field.get(instance)).append("', ");
        }

        //check if field is anything else
        else {
            Object object2 = field.get(instance);
            fieldAsString.append(field.getName()).append("=").append(object2.getClass().getSimpleName()).append("{");

            for (Field field2 : object2.getClass().getDeclaredFields()) {
                try {
                    field2.setAccessible(true);

                    fieldAsString.append(fieldToString(field2, object2));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            //remove last comma
            fieldAsString.delete(fieldAsString.length() - 2, fieldAsString.length());

            fieldAsString.append("}, ");
        }

        return fieldAsString.toString();
    }

    public static List<Class<?>> getSavrWrldTypes() {
        //get all classes
        Reflections reflections = new Reflections();

        //return list of classes annotated with @SavrWrld
        return new ArrayList<>(reflections.getTypesAnnotatedWith(SavrWrld.class));
    }

    /**
     * @param world Object annotated with {@link SavrWrld}.
     * */
    public static List<Field> getSavrListFields(Class<?> world) {
        //get fields
        List<Field> fields = Arrays.asList(world.getFields());

        //return list of fields annotated with @SavrList
        return fields.stream().filter(field -> field.isAnnotationPresent(SavrList.class)).collect(Collectors.toList());
    }
}
