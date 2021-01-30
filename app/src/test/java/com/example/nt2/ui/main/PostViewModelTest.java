package com.example.nt2.ui.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class PostViewModelTest {
    @Spy
    PostViewModel postViewModel;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getPosts() {
        doReturn(postViewModel.fillData()).when(postViewModel).fillData();
        System.out.println(postViewModel.fillData());
    }

}