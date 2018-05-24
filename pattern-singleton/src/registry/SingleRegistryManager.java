package registry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 09:16
 * @Description:单例注册管理类
 */
public class SingleRegistryManager {

    private static Map<String,Object> singletonMap = new HashMap<String,Object>();

    public static synchronized Object getInstance(String className){
        if(null == className){
            className = SingleRegistryManager.class.getName();
        }
        if(!singletonMap.containsKey(className)){
            try {
                singletonMap.put(className,Class.forName(className).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return singletonMap.get(className);
    }


}
