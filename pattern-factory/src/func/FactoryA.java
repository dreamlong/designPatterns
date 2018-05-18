package func;

/**
 * @Author: liumenglong
 * @Date: 2018/5/18 10:42
 * @Description:产品A的工厂
 */
public class FactoryA implements IFactory {

    @Override
    public func.IProduct getProduct() {
        return new ProductA();
    }
}
