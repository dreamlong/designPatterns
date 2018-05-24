package shallow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 17:59
 * @Description:图书馆，维护着建立日期，名字以及书籍
 *  浅拷贝：基本类型以及String类型直接拷贝值，引用类型拷贝引用,对第一个浅拷贝进行改良，针对List变量，改为ArrayList,因为其实现了cloneable接口
 *         可以实现深度复制
 */
public class Library2 implements Cloneable{

    public String name;
    public Date dateOfEstablishment;
    /**
     * 由于ArrayList实现了cloneable接口，故可以使用clone方法进行对象复制
     */
    public ArrayList<String> books;

    @Override
    protected Library2 clone() throws CloneNotSupportedException {
        Library2 library = (Library2)super.clone();
        library.books = (ArrayList<String>)books.clone();
        return library;
    }
}
