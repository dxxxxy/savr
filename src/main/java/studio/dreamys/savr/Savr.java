package studio.dreamys.savr;

import studio.dreamys.savr.annotation.SavrWrld;
import studio.dreamys.savr.util.ClassUtils;
import studio.dreamys.savr.util.FileUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Savr {
    /**
     * @param world Object annotated with {@link SavrWrld}.
     * */
    public static void save(Object world) {
        List<Field> savrListFields = ClassUtils.getSavrListFields(world.getClass());
        List<String> lines = new ArrayList<>();

        for (Field listField : savrListFields) {
            try {
                for (Object object : (List<Object>) listField.get(world)) { //for each object in the list
                    //get last part of class name
                    String className = object.getClass().getName();
                    className = className.substring(className.lastIndexOf(".") + 1);

                    //start building
                    StringBuilder objectAsString = new StringBuilder(className + " { ");

                    //for each field, add to the string
                    for (Field field : object.getClass().getDeclaredFields()) {
                        try {
                            //access private fields
                            field.setAccessible(true);

                            //get field as a string
                            try {
                                objectAsString.append(ClassUtils.fieldToString(field, object));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    //remove last comma
                    objectAsString.delete(objectAsString.length() - 2, objectAsString.length());

                    //end building
                    objectAsString.append(" }");

                    //print
                    System.out.println(objectAsString);

                    //add to lines
                    lines.add(String.valueOf(objectAsString));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        //write to file
        FileUtils.saveCompressed(String.join(System.lineSeparator(), lines));
    }

    /**
     * @param world Object annotated with {@link SavrWrld}.
     * */
    public static void load(Object world) {
        List<Field> savrListFields = ClassUtils.getSavrListFields(world.getClass());
    }
}
