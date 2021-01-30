package com.example.nt2.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class RepositryTest {

    @Spy
    Repositry repositry = Repositry.getINSTANCE();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getPosts() {
        doReturn(repositry.getPosts()).when(repositry).getPosts();
        System.out.println(repositry.getPosts());
    }
}