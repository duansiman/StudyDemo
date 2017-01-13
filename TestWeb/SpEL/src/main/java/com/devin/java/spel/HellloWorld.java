package com.devin.java.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Created by devin on 2017/1/12.
 */
public class HellloWorld {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'hello world'");
        System.out.println(expression.getValue(String.class));

        Expression e1 = parser.parseExpression("'hello world'.length()");
        System.out.println(e1.getValue(Integer.class));
    }

}
