package chenqian.site.commontest.se;

import chenqian.site.commontest.bean.SimpleTestBean;
import org.springframework.stereotype.Service;

import java.util.function.BinaryOperator;

/**
 * 功能简介:.
 * *
 */
@Service
public class BinaryOperatorImpl<T> implements BinaryOperator<T> {
    /**
     * Applies this function to the given arguments.
     *
     * @param o  the first function argument
     * @param o2 the second function argument
     * @return the function result
     */
    @Override
    public T apply(Object o, Object o2) {
        SimpleTestBean o1 = (SimpleTestBean) o;
        SimpleTestBean o21 = (SimpleTestBean) o2;
        o1.setName(o1.getName() + ","+ o21.getName());
        return (T)o1;
    }
}
