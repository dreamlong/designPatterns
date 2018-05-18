package func;

/**
 * @Author: liumenglong
 * @Date: 2018/5/18 10:42
 * @Description:产品B的工厂
 */
public class FactoryB implements IFactory {

    @Override
    public IProduct getProduct() {
        return new ProductB();
    }
}
