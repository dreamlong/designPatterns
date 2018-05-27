package staticed;

/**
 * @Author: liumenglong
 * @Date: 2018/5/26 21:19
 * @Description:代理类，帮儿子找女票，需要根据儿子的找女票方法，再编写自己的代理方法；假如儿子还有找工作方法，也要代理，那么也要再编写找工作方法
 */
public class Father implements Person {

    private Person son;

    public Father(Person son){
        this.son = son;
    }
    @Override
    public void findLove() {
        System.out.println("根据你的要求去物色");
        son.findLove();
        System.out.println("双方父母是否同意");
    }
}
