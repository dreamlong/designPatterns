package enums;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 09:59
 * @Description:枚举式单例
 *  优点：
 *      1、由于枚举对象是在static块加载，线程安全具有保证
 *      2、jvm对枚举具有序列化保证，故不怕序列化破坏
 *      3、反编译过来可知枚举是抽象类，故无法对其进行反射破坏
 */
public enum DataSourceEnum {
    DATASOURCE;
    private DBConnection connection = null;

    DataSourceEnum(){
        connection = new DBConnection();
    }

    public DBConnection getConnection(){
        return DATASOURCE.connection;
    }
}
