package abstr;

/**
 * @Author: liumenglong
 * @Date: 2018/5/18 10:58
 * @Description:抽象工厂，定义各个产品的生产接口，实现生产流水线，解决产品族需求
 */
public abstract class AbstractFactory {

    /**
     *
     * 功能描述: 获取手机产品
     *
     * @param:  * @param null
     * @return: IMobilePhone 手机产品
     * @Author: liumenglong
     * @date: 2018/5/18 11:00
     */
    public abstract IMobilePhone getMobilePhone();


    /**
     *
     * 功能描述: 获取笔记本产品
     *
     * @param:  * @param null
     * @return: IMobilePhone 笔记本产品
     * @Author: liumenglong
     * @date: 2018/5/18 11:00
     */
    public abstract INotebook getNotebook();
}
