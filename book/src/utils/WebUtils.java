package utils;

import bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParamToBean(Map map, T bean) {
        try {
            //将获取的请求参数注入bean对象中
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
