package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.ReflectionFactory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(MockitoJUnitRunner.class)
public class PojoBuilderTest {
    Logger LOGGER = LoggerFactory.getLogger(PojoBuilderTest.class);

    @Test
    public void test() throws IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        ClassPath path = ClassPath.from(ClassLoader.getSystemClassLoader());
        ImmutableSet<ClassPath.ClassInfo> topLevelClasses = ImmutableSet.<ClassPath.ClassInfo>builder()
                .addAll(path.getTopLevelClasses("cl.bancochile.plataformacomercial.controllimitestaller.domain"))
                .build();

        for (ClassPath.ClassInfo classInfo : topLevelClasses) {
            try {
                testClass(classInfo.load());
            } catch (Exception e) {
                LOGGER.error("No se pudo probar la clase: " + classInfo.getSimpleName(), e);
            }
        }

    }

    public void testClass(Class<?> clazz) throws Exception {

        ReflectionFactory reflection = ReflectionFactory.getReflectionFactory();
        Constructor constructor = reflection.newConstructorForSerialization(clazz,
                Object.class.getDeclaredConstructor(new Class[0]));

        Object origin = constructor.newInstance();
        Object target = constructor.newInstance();

        BeanUtilsBean.getInstance().getConvertUtils().
                register(false, false, 0);
        BeanUtils.copyProperties(target, origin);

        Assert.assertNotNull(target.toString());

        for (Class<?> c : clazz.getClasses()) {
            if (c.getSimpleName().equalsIgnoreCase("Builder")) {
                Object builder = c.newInstance();
                for (Field field : clazz.getDeclaredFields()) {
                    Method method = getMethod(field.getName(), c);
                    if(method != null) {
                        Object targetValue = getFieldValue(field, target);
                        method.invoke(builder, targetValue);
                    }
                }
                Method method = getMethod("build", c);
                if(method != null) {
                    method.invoke(builder);
                }
                break;
            }
        }
    }

    private Object getFieldValue(Field field, Object o) {
        Object value = null;
        try {
            boolean accessible = field.isAccessible();
            field.setAccessible(true);
            value = field.get(o);
            field.setAccessible(accessible);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return value;
    }

    private Method getMethod(String methodName, Class<?> type) {
        for (Method method : type.getMethods()) {
            if (methodName.equals(method.getName())) {
                return method;
            }
        }
        return null;
    }
}