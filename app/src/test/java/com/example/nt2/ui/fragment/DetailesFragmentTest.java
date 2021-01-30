package com.example.nt2.ui.fragment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DetailesFragmentTest {

    @Test
    public void update_Info() throws Exception {
        DetailesFragment detailesFragment = Mockito.mock(DetailesFragment.class);
        detailesFragment.update_Info("s", "t", "b");
        Mockito.verify(detailesFragment).update_Info("s", "t", "b");

    }

}