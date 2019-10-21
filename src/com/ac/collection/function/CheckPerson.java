package com.ac.collection.function;

/**
 * Description:
 * <函数式接口：只有一个抽象方法的接口>
 * Created by aochong on 2019/10/15
 *
 * @author aochong
 * @version 1.0
 */
public interface CheckPerson {
    /**
     * 检查指定的人是否符合指定的条件
     * @param person 需要检查的人
     * @return true 说明符合条件，false 不符合条件
     */
    public boolean test(Person person);
}
