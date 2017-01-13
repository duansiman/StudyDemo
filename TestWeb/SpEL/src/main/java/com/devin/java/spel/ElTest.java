package com.devin.java.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by devin on 2017/1/12.
 */
public class ElTest {

    public static void main(String[] args) {
        User user = new User();
        user.setName("devin");
        user.setSex("man");
//        user.setInterests(Arrays.asList("swim","read"));//这个集合不可修改
        user.setInterests(new ArrayList<>());

        ExpressionParser parser = new SpelExpressionParser();
        Expression ep = parser.parseExpression("name");

        EvaluationContext context = new StandardEvaluationContext(user);//指定root object

        System.out.println(ep.getValue(context));
        System.out.println(ep.getValue(user));

//        parser.parseExpression("interests[0]").setValue(context, "game");
//        System.out.println(user);

        SpelParserConfiguration cofig = new SpelParserConfiguration(true, true);//元素是null 它可以自动地创建的元素
        parser = new SpelExpressionParser(cofig);
        parser.parseExpression("interests[2]").setValue(context, "game");
        System.out.println(user);
    }

}
