package SystemEquations;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionThreeTest {
    FunctionThree functionThree;
    @BeforeEach
    void setUp() {
        functionThree = new FunctionThree();
    }

    @Test
    void testF(){
        double x = 1.0;
        double actual = functionThree.function(x);
        double expected = 6.4;
        assertThat(actual).isCloseTo(expected , Percentage.withPercentage(0.1));
    }

    @ParameterizedTest
    @CsvSource({
            " 1 , 6.4,\n" +
                    "1.4 , 3.64903,\n" +
                    "1.5 , 1.24807,"
    })
    void testF(double x , double expected){
        assertThat(functionThree.function(x)).isCloseTo(expected , Percentage.withPercentage(0.1));
    }

    @Test
    void testSteps(){
        double start = 0.0;
        double end = 2.0;
        double step = 0.002;
        assertThat(functionThree.numberSteps(start , end ,step )).isEqualTo(1001);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0 , 2.0 , 0.002 , 0 , 0.0,\n" +
                    "0.0 , 2.0 , 0.002 , 700 ,  1.4,\n" +
                    "0.0 , 2.0 , 0.002 , 1000 , 2,"
    })
    void testfillX(double start , double end , double step ,int index , double expected ) {
        double [] x = functionThree.fillX(start , end ,step );
        assertThat(x[index]).isCloseTo(expected , Percentage.withPercentage(0.1));
    }

    @ParameterizedTest
    @CsvSource({
            "0.0 , 2.0 , 0.002 , 0 , 4,\n" +
                    "0.0 , 2.0 , 0.002 , 700 , 3.64903,\n" +
                    "0.0 , 2.0 , 0.002 , 1000 ,  0.93914,"
    })
    void textfillY(double start , double end , double step ,int index , double expected) {
        double [] x = functionThree.fillX(start , end ,step );
        double []y = functionThree.fillY(x);
        assertThat(y[index]).isCloseTo(expected , Percentage.withPercentage(0.1));
    }


    @ParameterizedTest
    @CsvSource({
            "0.0 , 2.0 , 0.002 ,  2269.5294,"
    })
    void arraySum(double start , double end , double step ,double expected ) {
        double [] x = functionThree.fillX(start , end ,step );
        double []y = functionThree.fillY(x);
        assertThat(functionThree.arraySum(y)).isCloseTo(expected , Percentage.withPercentage(0.1));
    }

    @ParameterizedTest
    @CsvSource({
            "0.0 , 2.0 , 0.002 , 2.2672,"
    })
    void arrayAverage(double start , double end , double step ,double expected) {
        double [] x = functionThree.fillX(start , end ,step );
        double []y = functionThree.fillY(x);
        assertThat(functionThree.arrayAverage(y)).isCloseTo(expected , Percentage.withPercentage(0.1));
    }



    @ParameterizedTest
    @CsvSource({
            "0.0 , 2.0 , 0.002 , 8.333,"
    })
    void findMaxY(double start , double end , double step ,double expected) {
        double [] x = functionThree.fillX(start , end ,step );
        double []y = functionThree.fillY(x);
        assertThat(functionThree.FindMaxY(y)).isCloseTo(expected , Percentage.withPercentage(0.1));
    }

    @ParameterizedTest
    @CsvSource({
            "0.0 , 2.0 , 0.002 ,  0.00479626,"
    })
    void findMinY(double start , double end , double step ,double expected) {
        double [] x = functionThree.fillX(start , end ,step );
        double []y = functionThree.fillY(x);
        assertThat(functionThree.FindMinY(y)).isCloseTo(expected , Percentage.withPercentage(0.1));
    }

    @ParameterizedTest
    @CsvSource({
            "0.0 , 2.0 , 0.002 , 701 , Y = 8.333246177315598 Index = 701,"
    })
    void printInfoMaxY(double start , double end , double step ,int index , String expected) {
        double [] x = functionThree.fillX(start , end ,step );
        double []y = functionThree.fillY(x);
        assertThat(functionThree.PrintInfoMaxY(y ,index)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0 , 2.0 , 0.002 , 699 , Y = 0.004796264766233471 Index = 699"
    })
    void printInfoMinY(double start , double end , double step ,int index , String expected) {
        double [] x = functionThree.fillX(start , end ,step );
        double []y = functionThree.fillY(x);
        assertThat(functionThree.PrintInfoMinY(y ,index)).isEqualTo(expected);
    }
}