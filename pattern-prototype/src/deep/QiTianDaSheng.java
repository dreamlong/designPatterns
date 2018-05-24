package deep;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.Date;

/**
 * @Author: liumenglong
 * @Date: 2018/5/24 23:30
 * @Description:
 */
public class QiTianDaSheng extends Monkey implements Cloneable,Serializable {

    public JinGuBang jinGuBang;

    public QiTianDaSheng(){
        this.jinGuBang = new JinGuBang();
        this.birthday = new Date();
    }

    @Override
    protected QiTianDaSheng clone() throws CloneNotSupportedException {
        return this.deepCopy();
    }

    public QiTianDaSheng deepCopy(){
        QiTianDaSheng o = null;
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            o = (QiTianDaSheng)ois.readObject();
            o.birthday = new Date();
        }catch (Exception e){
            e.printStackTrace();
        }
        return o;
    }
}
