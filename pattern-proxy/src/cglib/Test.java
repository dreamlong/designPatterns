package cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liumenglong
 * @Date: 2018/5/26 22:32
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException {



        ZhangSan zhangSan = (ZhangSan)new CglibMeipo().getInstance(ZhangSan.class);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");
        System.out.println(zhangSan);
        //zhangSan.findLove();

        //通过反编译工具可以查看源代码
//        byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{ZhangSan.class});
//        FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
//        os.write(bytes);
//        os.close();


    }
}
