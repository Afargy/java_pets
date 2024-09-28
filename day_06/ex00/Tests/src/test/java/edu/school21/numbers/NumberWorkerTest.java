package edu.school21.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberWorkerTest {
    private NumberWorker object = new NumberWorker();

    @ParameterizedTest
    @ValueSource(ints = { -100, -2, -1, 0, 1 })
    void testIsPrime_WithIllegalNumbers_ThrowsIllegalNumberException(int num) {
        assertThrows(IllegalNumberException.class, () -> object.isPrime(num),
                "Number is illegal. Throw is asserted");
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 3, 7, 11, 887 })
    void testIsPrime_WithPrimeNumbers_RerurnsTrue(int num) {
        assertTrue(object.isPrime(num), "Number is prime. Result must be true");
    }

    @ParameterizedTest
    @ValueSource(ints = { 4, 8, 100, 200, 999 })
    void testIsPrime_WithCompositeNumbers_RerurnsFalse(int num) {
        assertFalse(object.isPrime(num),
                "Number is composite. Result must be false");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void testDigitsSum_WithCvsFile(int num, int sum) {
        assertEquals(sum, object.digitsSum(num));
    }

}
