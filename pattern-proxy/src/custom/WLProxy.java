package custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: liumenglong
 * @Date: 2018/5/27 14:27
 * @Description:代理工具类
 */
public class WLProxy {

    private static final String LN = "\r\n";

    public static Object newInstance(WLClassLoader wlClassLoader,Class<?>[] interfaces,WLInvocationHandler wlInvocationHandler) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 1、动态生成源代码.java
         */
        String src = generateSrc(interfaces);
        /**
         * 2、java文件输出磁盘
         */
        String filePath="D://";
        System.out.println(filePath);
        File file = new File(filePath+"$Proxy0.java");
        FileWriter fw = new FileWriter(file);
        fw.write(src);
        fw.flush();
        fw.close();
        /**
         * 3、把生成的.java文件编译成.class文件
         */
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
        Iterable iterable = manager.getJavaFileObjects(file);

        JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
        task.call();
        manager.close();
        /**
         * 4、编译生成的.class文件加载到JVM中来
         */
        Class proxyClass = wlClassLoader.findClass("$Proxy0");
        Constructor c = proxyClass.getConstructor(WLInvocationHandler.class);

        /**
         * 5、删除源文件
         */
        file.delete();
        /**
         * 6、返回字节码重组以后的新的代理对象
         */
        return c.newInstance(wlInvocationHandler);
    }

    /**
     * 根据代理接口生成相应的代理类
     * @param interfaces
     * @return
     */
    private static String generateSrc(Class<?>[] interfaces){
        StringBuffer sb = new StringBuffer();
        /**
         * 代理类所在包
         */
        sb.append("package custom;"+LN);
        /**
         * 声明代理类引入的包名
         */
        sb.append("import java.lang.reflect.Method;"+LN);

        /**
         * 声明代理类结构
         */
        sb.append("public class $Proxy0 implements "+interfaces[0].getName()+"{"+LN);
        /**
         * 声明成员变量
         */
        sb.append("private WLInvocationHandler h;"+LN);
        /**
         * 声明构造方法
         */
         sb.append("public $Proxy0(WLInvocationHandler h){"+LN);
         sb.append("this.h = h;"+LN);
         sb.append("}"+LN);
        /**
         * 声明成员方法
         */
        for(Method m : interfaces[0].getMethods()){
            /**
             * 构造方法体
             */
            sb.append("public "+m.getReturnType()+" "+m.getName()+"(){"+LN);
            sb.append("try{"+LN);
            sb.append("Method m = Class.forName(\""+interfaces[0].getName()+"\").getMethod(\""+m.getName()+"\");"+LN);
            sb.append("h.invoke(this,m,null);"+LN);
            sb.append("}catch(Throwable e){"+LN);
            sb.append("e.printStackTrace();");
            sb.append("}"+LN);
            sb.append("}"+LN);
        }

        sb.append("}"+LN);
        return sb.toString();
    }
}
