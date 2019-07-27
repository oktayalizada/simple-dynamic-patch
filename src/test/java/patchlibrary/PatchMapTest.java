package patchlibrary;


import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PatchMapTest{


@Test
public void   patchTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    User user=new User();
    user.setAge(20);
    user.setId("1");
    user.setLastName("testLastName");
    user.setName("fsafsafsdf");
    Map<String, Object> mapObject=new HashMap<String, Object>();
    mapObject.put("id", "dasdasd");
    mapObject.put("name", "dasdasd");
    mapObject.put("age", 40);
    mapObject.put("ssn", 1L);
    mapObject.put("gender", (byte)0);
    mapObject.put("shortVariable", (short)2);
    mapObject.put("height", 2.0);
    mapObject.put("testChar", 'c');
    mapObject.put("weight", 1f);
    mapObject.put("active", true);
    PatchMap.patch(mapObject, user);
}


}
