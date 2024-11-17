import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalculatorTest.class // Specify the subtraction tests if necessary
})
@IncludeTags("Subtraction")
public class SubtractionTestSuite {
    // This suite will run only the subtraction-related tests from CalculatorTest
}