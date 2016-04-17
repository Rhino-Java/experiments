package test.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import test.example.db.DbUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ DbUtil.class })
public class AppTest {

	@Before
	public void setUp() {
		PowerMockito.mockStatic(DbUtil.class);
	}

	@Test
	public void mainTest() throws Exception {
		App.main(new String[] {});
	}

}
