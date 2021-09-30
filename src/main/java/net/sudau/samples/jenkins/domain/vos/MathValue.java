package net.sudau.samples.jenkins.domain.vos;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class MathValue {

    public static final DoubleBinaryOperator add = Double::sum;
    public static final BinaryOperator<Double> substract = (lhs, rhs) -> {
        if (lhs == null) return rhs;
        return lhs - rhs;
    };
    public static final DoubleBinaryOperator multiply = (lhs, rhs) -> lhs * rhs;
    public static final BinaryOperator<Double> divide = (lhs, rhs) -> {
        if (lhs == null) return rhs;
        if (rhs == 0.0) throw new ArithmeticException("Parameter is 0");
        return lhs / rhs;
    };
    public static final DoubleUnaryOperator sqr = value -> value * value;
    public static final DoubleUnaryOperator sqrt = Math::sqrt;

}
