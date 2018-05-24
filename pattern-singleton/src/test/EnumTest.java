package test;

import enums.DBConnection;
import enums.DataSourceEnum;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 10:05
 * @Description:
 */
public class EnumTest {

    public static void main(String[] args) {
        DBConnection c1 = DataSourceEnum.DATASOURCE.getConnection();
        DBConnection c2 = DataSourceEnum.DATASOURCE.getConnection();
        System.out.println(c1 == c2);
        /**
         * 执行结果：
         *  true
         */
    }
}
