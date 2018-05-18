package abstr;

/**
 * @Author: liumenglong
 * @Date: 2018/5/18 11:05
 * @Description:华为工厂，生产手机和电脑
 */
public class HuaweiFactory extends AbstractFactory {
    @Override
    public IMobilePhone getMobilePhone() {
        return new HuaweiPhone();
    }

    @Override
    public INotebook getNotebook() {
        return new HuaweiNotebook();
    }
}
