package deep;

import java.io.Serializable;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 23:28
 * @Description:需要深度复制，实现序列化接口
 */
public class JinGuBang implements Serializable {

    public float h = 100;
    public float d = 10;

    public void big(){
        this.h *= 2;
        this.d *= 2;
    }

    public void small(){
        this.h /= 2;
        this.d /= 2;
    }
}
