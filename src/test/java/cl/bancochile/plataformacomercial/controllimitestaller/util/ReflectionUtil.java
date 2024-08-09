package cl.bancochile.plataformacomercial.controllimitestaller.util;

import java.lang.reflect.Field;

public class ReflectionUtil {

    public static void setProperty(Object object, String name, Object value) {
        try {
            Field f1 = object.getClass().getSuperclass().getDeclaredField(name);
            boolean isAccessible = f1.isAccessible();
            f1.setAccessible(true);
            f1.set(object, value);
            f1.setAccessible(isAccessible);
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}