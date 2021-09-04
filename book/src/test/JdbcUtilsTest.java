package test;

import org.junit.Test;
import utils.JdbcUtils;

import java.sql.SQLException;

public class JdbcUtilsTest {
    @Test
    public void test() {
        try {
            System.out.println(JdbcUtils.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
