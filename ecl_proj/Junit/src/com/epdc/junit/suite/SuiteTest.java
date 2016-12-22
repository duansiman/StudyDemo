package com.epdc.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.epdc.junit.JunitTest;
import com.epdc.junit.enclosed.EnclosedTest;
/**
 * 测试套件，执行多个测试单元
 * @author devin
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	JunitTest.class,
	EnclosedTest.class
})
public class SuiteTest {

}
