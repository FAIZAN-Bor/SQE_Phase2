import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

@TestInstance(Lifecycle.PER_METHOD)
@TestMethodOrder(OrderAnnotation.class)
//@Execution(ExecutionMode.CONCURRENT)
public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator(); 
    }
    
    @Test
    @Order(1)
    @Tag("Addition")
    public void testAdditionPositiveNumbers() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Addition Test");
        calculator.oldValue = 5;
        calculator.newValue = 10;
        calculator.calculation = 1; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()) );
    }

    @Test
    @Order(2)
    @Tag("Addition")
    @Tag("Negative")
    public void testAdditionNegativeNumbers() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Addition Test with Negative Numbers");
        calculator.oldValue = -5;
        calculator.newValue = -10;
        calculator.calculation = 1; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(3)
    @Tag("Addition")
    @Tag("Boundary")
    public void testAdditionBoundaryValues() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Addition Boundary Test");
        calculator.oldValue = Integer.MAX_VALUE;
        calculator.newValue = 1;
        calculator.calculation = 1; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(4)
    @Tag("Subtraction")
    public void testSubtractionPositiveNumbers() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Subtraction Test");
        calculator.oldValue = 10;
        calculator.newValue = 5;
        calculator.calculation = 2; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(5)
    @Tag("Subtraction")
    @Tag("Negative")
    public void testSubtractionNegativeNumbers() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Subtraction Test with Negative Numbers");
        calculator.oldValue = -10;
        calculator.newValue = -5;
        calculator.calculation = 2; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(6)
    @Tag("Subtraction")
    @Tag("Boundary")
    public void testSubtractionBoundaryValues() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Subtraction Boundary Test");
        calculator.oldValue = Integer.MIN_VALUE;
        calculator.newValue = -1;
        calculator.calculation = 2; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(7)
    @Tag("Multiplication")
    public void testMultiplicationPositiveNumbers() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Multiplication Test");
        calculator.oldValue = 5;
        calculator.newValue = 10;
        calculator.calculation = 3; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(8)
    @Tag("Multiplication")
    @Tag("Zero")
    public void testMultiplicationByZero() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Multiplication by Zero Test");
        calculator.oldValue = 10;
        calculator.newValue = 0;
        calculator.calculation = 3; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(9)
    @Tag("Multiplication")
    @Tag("Boundary")
    public void testMultiplicationBoundaryValues() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Multiplication Boundary Test");
        calculator.oldValue = Integer.MAX_VALUE;
        calculator.newValue = 2;
        calculator.calculation = 3; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(10)
    @Tag("Division")
    public void testDivisionPositiveNumbers() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Division Test");
        calculator.oldValue = 10;
        calculator.newValue = 2;
        calculator.calculation = 4; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    

    @Test
    @Order(12)
    @Tag("Division")
    @Tag("Boundary")
    public void testDivisionBoundaryValues() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Division Boundary Test");
        calculator.oldValue = Double.MAX_VALUE;
        calculator.newValue = 1;
        calculator.calculation = 4; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    // Decimal Handling Tests
    @Test
    @Order(13)
    @Tag("Decimal")
    public void testDecimalAddition() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Decimal Addition Test");
        calculator.oldValue = 5.5;
        calculator.newValue = 4.5;
        calculator.calculation = 1; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(14)
    @Tag("Decimal")
    public void testDecimalDivision() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running Decimal Division Test");
        calculator.oldValue = 5.0;
        calculator.newValue = 2.0;
        calculator.calculation = 4; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    // Tests from CSV
    @Test
    @Order(15)
    @Tag("CSV")
    public void testOperationsFromCSV() throws IOException {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running CSV Test");
        BufferedReader br = new BufferedReader(new FileReader("testcases.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            double oldValue = Double.parseDouble(data[0]);
            double newValue = Double.parseDouble(data[1]);
            int calculation = Integer.parseInt(data[2]);
            double expected = Double.parseDouble(data[3]);

            calculator.oldValue = oldValue;
            calculator.newValue = newValue;
            calculator.calculation = calculation;
            double res=calculator.calculateResult();
            System.out.print(res);
            assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
        }
        br.close();
    }
    
    @Test
    @Order(16)
    @Tag("ECP")
    @Tag("Addition")
    public void testAdditionPositiveRange() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running ECP Addition Positive Range Test");
        calculator.oldValue = 100;
        calculator.newValue = 50;
        calculator.calculation = 1; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(17)
    @Tag("ECP")
    @Tag("Addition")
    public void testAdditionNegativeRange() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running ECP Addition Negative Range Test");
        calculator.oldValue = -100;
        calculator.newValue = -50;
        calculator.calculation = 1; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(18)
    @Tag("BVA")
    @Tag("Subtraction")
    public void testSubtractionWithMaxValue() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running BVA Subtraction with Max Value Test");
        calculator.oldValue = Integer.MAX_VALUE;
        calculator.newValue = 1;
        calculator.calculation = 2; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(19)
    @Tag("BVA")
    @Tag("Subtraction")
    public void testSubtractionWithMinValue() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running BVA Subtraction with Min Value Test");
        calculator.oldValue = Integer.MIN_VALUE;
        calculator.newValue = 1;
        calculator.calculation = 2; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    

    @Test
    @Order(21)
    @Tag("BVA")
    @Tag("Multiplication")
    public void testMultiplicationBoundaryValues1() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running BVA Multiplication Boundary Test");
        calculator.oldValue = Integer.MAX_VALUE;
        calculator.newValue = 1;
        calculator.calculation = 3; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(22)
    @Tag("ECP")
    @Tag("Division")
    public void testDivisionWithPositiveNumbers() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running ECP Division Positive Numbers Test");
        calculator.oldValue = 200;
        calculator.newValue = 10;
        calculator.calculation = 4;
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(23)
    @Tag("ECP")
    @Tag("Division")
    public void testDivisionWithNegativeNumbers() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running ECP Division Negative Numbers Test");
        calculator.oldValue = -200;
        calculator.newValue = -10;
        calculator.calculation = 4; 
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

    @Test
    @Order(24)
    @Tag("ECP")
    @Tag("Decimal")
    public void testDecimalMultiplication() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Running ECP Decimal Multiplication Test");
        calculator.oldValue = 10.5;
        calculator.newValue = 2;
        calculator.calculation = 3; // 3 for multiplication
        double res=calculator.calculateResult();
        System.out.print(res);
        assertEquals(res,Double.parseDouble(calculator.displayLabel.getText()));
    }

        
@Suite
@SelectClasses({CalculatorTest.class})
@Tag("Addition")
class AdditionTestSuite {}

@Suite
@SelectClasses({CalculatorTest.class})
@Tag("Subtraction")
class SubtractionTestSuite {}

@Suite
@SelectClasses({CalculatorTest.class})
@Tag("Multiplication")
class MultiplicationTestSuite {}

@Suite
@SelectClasses({CalculatorTest.class})
@Tag("Division")
class DivisionTestSuite {}

}