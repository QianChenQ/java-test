package chenqian.site.commontest.se;

import chenqian.site.commontest.bean.SimpleTestBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
public class MainTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        Date date1 = simpleDateFormat.parse("2021-01-02 11:11:12");
        Date date2 = simpleDateFormat.parse("2021-01-02 11:11:12");
        Date date3 = simpleDateFormat.parse("2021-01-03 11:11:12");
        Date createTime1 = simpleDateFormat.parse("2021-01-02 11:11:12");
        Date createTime2 = simpleDateFormat.parse("2021-01-01 11:11:12");
        Date createTime3 = simpleDateFormat.parse("2021-01-03 11:11:12");
        List<SimpleTestBean> objects = new ArrayList<>();
        SimpleTestBean simpleTestBean1 = new SimpleTestBean();
        simpleTestBean1.setDate(date2);
        simpleTestBean1.setCreateTime(createTime1);
        simpleTestBean1.setName("1");
        SimpleTestBean simpleTestBean2 = new SimpleTestBean();
        simpleTestBean2.setDate(date2);
        simpleTestBean2.setCreateTime(createTime2);
        simpleTestBean2.setName("2");
        SimpleTestBean simpleTestBean3 = new SimpleTestBean();
        simpleTestBean3.setDate(date3);
        simpleTestBean3.setCreateTime(createTime3);
        simpleTestBean3.setName("3");
        SimpleTestBean simpleTestBean = new SimpleTestBean();
        simpleTestBean.setDate(date);
        simpleTestBean.setName("0");
        Date date4 = new Date();
        objects.add(simpleTestBean);
        objects.add(simpleTestBean1);
        objects.add(simpleTestBean2);
        objects.add(simpleTestBean3);
        objects = objects.stream().sorted((o1, o2) -> {

            if (o1.getDate() == null) {
                o1.setDate(date4);
            }
            if (o2.getDate() == null) {
                o2.setDate(date4);
            }
            if (o1.getDate().equals(o2.getDate())) {
                if (o1.getCreateTime() == null) {
                    o1.setCreateTime(date4);
                }
                if (o2.getCreateTime() == null) {
                    o2.setCreateTime(date4);
                }
                if (o1.getCreateTime().equals(o2.getCreateTime())) {
                    return 0;
                }
                if (o1.getCreateTime().before(o2.getCreateTime())) {
                    return -1;
                } else {
                    return 1;
                }
            }
            if (o1.getDate().before(o2.getDate())) {
                return -1;
            } else {
                return 1;
            }
        }).collect(Collectors.toList());
/*        objects.sort(Comparator.comparing(simpleTestBean4 -> {
            if (simpleTestBean4.getDate() != null) {
                return simpleTestBean4.getDate();
            }
            return date4;
        }));*/
        for (SimpleTestBean object : objects) {
            System.out.println(object.getName());
        }
        System.out.println(objects);
    }

    private static void add(SimpleTestBean test) {
        test.setPkId("2222");
        test = new SimpleTestBean();
    }
}
