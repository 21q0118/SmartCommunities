package ltbyz.practice_demo;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// import com.mysql.jdbc.Connection;

import javax.sql.DataSource;
import ltbyz.practice_demo.wisdom_block.pojo.UserLogin;
import ltbyz.practice_demo.wisdom_block.mapper.UserLoginMapper;

@SpringBootTest
class PracticeDemoApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() throws SQLException {
		System.out.println(dataSource.getClass());
		System.out.println(dataSource.getConnection());
	}

	@Autowired
	UserLoginMapper userLoginImpl;

	@Test
	public void toTest() {
		List<UserLogin> userLogins = userLoginImpl.queryAll();
		System.out.println(userLogins);
		userLogins.forEach(e -> System.out.println(e));
	}
}
