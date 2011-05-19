import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.autonavi.infra.collections.SimpleElementsTest;
import com.autonavi.infra.utils.NumbersTest;
import com.tinfochina.infra.volume.SortDirTest;

@RunWith(Suite.class)
@SuiteClasses({
	SortDirTest.class,
	SimpleElementsTest.class,
	NumbersTest.class
})
public class WheelsSuites {
	
}
