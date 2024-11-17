import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalculatorTest.class // Specify the boundary tests if necessary
})
@IncludeTags("Boundary")
public class BoundaryTestSuite {
    // This suite will run only the boundary-related tests from CalculatorTest
}