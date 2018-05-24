package shallow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 17:59
 * @Description:图书馆，维护着建立日期，名字以及书籍
 *  浅拷贝：基本类型以及String类型直接拷贝值，引用类型拷贝引用
 */
public class Library implements Cloneable{

    public String name;
    public Date dateOfEstablishment;
    public List<String> books;

    @Override
    protected Library clone() throws CloneNotSupportedException {
        Library library = (Library)super.clone();
        return library;
    }
}
