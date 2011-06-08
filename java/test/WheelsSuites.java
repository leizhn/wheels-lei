import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.autonavi.infra.collections.SimpleElementsTest;
import com.autonavi.infra.utils.NumbersTest;

@RunWith(Suite.class)
@SuiteClasses({
	SimpleElementsTest.class,
	NumbersTest.class
})
public class WheelsSuites {
	
}
