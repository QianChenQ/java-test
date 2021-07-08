package chenqian.site.commontest.se;

import chenqian.site.commontest.bean.SimpleTestBean;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 功能简介:.
 * *
 */
public class Deduplication {
    public static void main(String[] args) {
        List<SimpleTestBean> beanList = new ArrayList<>();
        SimpleTestBean bean1 = new SimpleTestBean();
        bean1.setId(1);
        bean1.setName("陈虔");
        bean1.setPkId(null);

        SimpleTestBean bean2 = new SimpleTestBean();
        bean2.setId(2);
        bean2.setName("bean2");
        bean2.setPkId("bean2Pkid");

        SimpleTestBean bean3 = new SimpleTestBean();
        bean3.setId(1);
        bean3.setName("陈虔");
        bean3.setPkId("null");

        beanList.add(bean1);
        beanList.add(bean2);
        beanList.add(bean3);

        List<SimpleTestBean> result = beanList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
                new TreeSet<>(Comparator.comparing(simpleTestBean -> simpleTestBean.getId() + ";" + simpleTestBean.getName() + ";" + simpleTestBean.getPkId()))
        ), ArrayList::new));
        SimpleTestBean o = beanList.stream().reduce(new BinaryOperatorImpl<>()).orElse(null);
        System.out.println(o);
    }
}
