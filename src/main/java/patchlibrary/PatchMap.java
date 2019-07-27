package patchlibrary;


import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class PatchMap {
    private PatchMap(){

    }

    public static Object patch(Map<String,Object> user, Object current) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (Map.Entry<String, Object> entry : user.entrySet()) {
            Method sumInstanceMethod
                    = current.getClass().getDeclaredMethod("set"+
                    StringUtils.capitalize(entry.getKey()), getTypeClass(entry.getValue()));

            sumInstanceMethod.invoke(current, entry.getValue());
        }
        return current;
    }


    private static Class getTypeClass(Object object) {
        if (object instanceof Byte)
            return byte.class;
        if (object instanceof Short)
            return short.class;
        if (object instanceof Integer)
            return int.class;
        if (object instanceof Long)
            return long.class;
        if (object instanceof Character)
            return char.class;
        if (object instanceof Float)
            return float.class;
        if (object instanceof Double)
            return double.class;
        if (object instanceof Boolean)
            return boolean.class;
        else{
            return object.getClass();
        }
    }

}
