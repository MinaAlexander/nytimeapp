package com.example.nt2.ui.fragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class PostsFragmentTest {
    @Mock
    PostsFragment postsFragment;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void isNetworkConnected() {
        doReturn(postsFragment.isNetworkConnected()).when(postsFragment).isNetworkConnected();
        System.out.println(postsFragment.isNetworkConnected());
    }

    @Test
    public void isInternetAvailable() {
        doReturn(postsFragment.isInternetAvailable()).when(postsFragment).isInternetAvailable();
        System.out.println(postsFragment.isInternetAvailable());
    }

}