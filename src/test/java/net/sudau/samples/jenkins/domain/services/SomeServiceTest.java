package net.sudau.samples.jenkins.domain.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import net.sudau.samples.jenkins.domain.dtos.MathParameter;
import net.sudau.samples.jenkins.domain.vos.Operations;
import org.junit.jupiter.api.Test;

class SomeServiceTest {

    private SomeService serviceUnderTest = new SomeService();

    @Test
    void now () {
        LocalDateTime beforeTest = LocalDateTime.now();
        LocalDateTime actual = serviceUnderTest.now();
        LocalDateTime afterTest = LocalDateTime.now();
        assertThat(actual).isBetween(beforeTest, afterTest);
    }

    @Test
    void calculate () {
        List<Double> values = Arrays.asList(1.0, 2.5, 3.1);

        assertThat(serviceUnderTest.calculate(new MathParameter(Operations.ADD, values)))
                .isEqualTo(6.6);
        assertThat(serviceUnderTest.calculate(new MathParameter(Operations.SUBSTRACT, values)))
                .isEqualTo(-4.6);
        assertThat(serviceUnderTest.calculate(new MathParameter(Operations.MULTIPLY, values)))
                .isEqualTo(7.75);
        assertThat(serviceUnderTest.calculate(new MathParameter(Operations.DIVIDE, values)))
                .isEqualTo(0.12903225806451613);
    }
}
