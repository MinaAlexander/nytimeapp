package com.example.nt2.ui.Interface;

public interface MyCommunicator {

    public interface DisplayDetailes {
        void onItemClickCard(String source, String title, String body);
        void onItemClick(int postion);
    }
}
