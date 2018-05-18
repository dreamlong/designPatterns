package func;

/**
 * @Author: liumenglong
 * @Date: 2018/5/18 10:39
 * @Description:工厂方法接口，获取产品
 */
public interface IFactory {

    /**
     *
     * 功能描述: 获取产品，各个具体工厂根据接口实现各自的获取产品方法
     *          1、通过此方法，同一产品级，可以根据工厂接口实现各自的工厂
     *          2、这样，就将简单工厂的获取产品的耦合逻辑给解耦了，实现了一个产品对应一个具体的工厂
     *          3、但是，工厂方法依旧存在一个问题，就是，当出现一个工厂需要实现产品族的业务需求的时候
     *            工厂方法就不满足需求了，何为产品族，比如苹果生产mac笔记本和iphone手机，华为生产华为
     *            笔记本和华为手机，这两个工厂各自的产品就是一个产品族，如果使用工厂方法去实现这种需求，
     *            1）需要新建一个工厂接口来实现这个产品生产接口
     *            2）各个厂商需要根据接口去实现这个工厂
     *            3）即，同一个厂商，不同的产品对应了不同的工厂，按现实来理解，也不会这样，因为有流水线
     *         4、因此，对应第三点的问题解决，我们采用抽象工厂方法来实现，见abstr包
     *
     * @param:  * @param null
     * @return: IProduct 产品
     * @Author: liumenglong
     * @date: 2018/5/18 10:40
     */
    public IProduct getProduct();
}
