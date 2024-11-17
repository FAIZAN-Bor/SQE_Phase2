import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

// Suite for All Calculator Tests
@Suite
@SelectClasses({
    CalculatorTest.class // Specify your test class here
})
public class CalculatorTestSuite {
    // This class will run all tests from CalculatorTest class
}