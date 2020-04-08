package chenqian.site.commontest.se;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
public class MainTest {
    public static void main(String[] args) {
        Singleton.INSTENCE.doSomeThing();
        System.out.println(Singleton.INSTENCE);
        System.out.println(Singleton.INSTENCE.toString());
        System.out.println(Singleton.INSTENCE2.toString());
        System.out.println(Singleton.INSTENCE.hashCode());
        System.out.println(Singleton.INSTENCE.hashCode());
        System.out.println(Singleton.INSTENCE2.hashCode());
    }
}
