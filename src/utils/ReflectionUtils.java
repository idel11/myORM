package utils;

import annotations.Column;
import annotations.Table;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReflectionUtils {

    public static Map<String, Object> getFilledMap(Object classes) throws IllegalAccessException {

        Class<?> aClass = classes.getClass();
        Map<String, Object> columnNameToFieldMap = new HashMap<>();

        if (aClass.isAnnotationPresent(Table.class)) {
            Table annotation = aClass.getAnnotation(Table.class);
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column annotation2 = field.getAnnotation(Column.class);
                    field.setAccessible(true);
                    Object o = field.get(classes);
                    columnNameToFieldMap.put(annotation2.value(), o);
                }
            }
            return columnNameToFieldMap;
        }

        return null;
    }

    public static String getTableName(Class<?> aClass) {

        Table table = null;
        if (aClass.isAnnotationPresent(Table.class)) {
            table = aClass.getAnnotation(Table.class);
        }
        return Objects.requireNonNull(table).value();
    }

    public static void selectData(Object foundModels, Map<String, Object> columnNames, String tableName) {

        StringBuilder sb = new StringBuilder("SELECT * FROM "
                + tableName + " WHERE ");
        Class<?> aClass = foundModels.getClass();
        for (Map.Entry<String, Object> entry : columnNames.entrySet()) {
            sb.append(entry.getKey()).append(" = " + entry.getValue() + ", ");
        }

        StringBuilder sb2 = new StringBuilder(sb.substring(0, (sb.length() - 2)));

        System.out.println(sb2);

    }

}
