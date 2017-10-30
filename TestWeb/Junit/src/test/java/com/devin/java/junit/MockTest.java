package com.devin.java.junit;

import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

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

        User user = new User("rose", "123");
        doReturn(true).when(mockUserService).isUser(user);

        boolean isUser = mockUserService.isUser(user);
        assertTrue(isUser);

        verify(mockUserService).getUserByName("devin");

    }
}
