import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalculatorTest.class // Specify the addition tests if necessary
})
@IncludeTags("Addition")
public class AdditionTestSuite {
    // This suite will run only the addition-related tests from CalculatorTest
}
