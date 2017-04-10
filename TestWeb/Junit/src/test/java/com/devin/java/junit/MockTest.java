package com.devin.java.junit;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static junit.framework.TestCase.*;

/**
 * Created by devin on 2017/2/20.
 */
public class MockTest {

    UserService mockUserService = mock(UserService.class);

    @Test
    public void testMock(){
        when(mockUserService.getUserByName("devin")).thenReturn(new User("devin", "123"));

        User devin = mockUserService.getUserByName("devin");
        assertNotNull(devin);
    }
}
