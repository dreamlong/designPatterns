package simple;

/**
 * @Author: liumenglong
 * @Date: 2018/5/18 10:26
 * @Description:简单工厂
 */
public class ProductFactory {

    /**产品编号**/
    private int proNo;

    public ProductFactory(int proNo){
        this.proNo = proNo;
    }

    /**
     *
     * 功能描述: 根据产品编号生成对应的产品；
     *          1、将需求和产品解耦
     *          2、然而，产品和工厂没有完全解耦：原因，当新增产品时，要维护工厂里面的switch case或者if else块，
     *             当产品越来越多的时候，维护成本越来越高，因此，工厂和产品还是绑定在一起的
     *          3、如何解决上述问题，要将工厂和产品解耦，就是要将switch case块的逻辑分离出来，之前是一个工厂接口对应
     *             多个产品，根据swith case或者if else动态获取指定的产品，现在通过一个工厂对应一个产品的方法，来获取，即工厂方法，
     *             解决方案见func包下
     *
     * @param:  * @param null
     * @return: IProduct
     * @Author: liumenglong
     * @date: 2018/5/18 10:29
     */
    public IProduct getProduct(){
        switch (proNo){
            default:return new ProductA();
            case 1:return new ProductA();
            case 2:return new ProductB();
        }
    }
}
