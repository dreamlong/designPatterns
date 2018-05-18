package abstr;

/**
 * @Author: liumenglong
 * @Date: 2018/5/18 11:06
 * @Description:苹果工厂，生产苹果手机和笔记本
 */
public class AppleFactory extends AbstractFactory {
    @Override
    public IMobilePhone getMobilePhone() {
        return new IPhone();
    }

    @Override
    public INotebook getNotebook() {
        return new Mac();
    }
}
