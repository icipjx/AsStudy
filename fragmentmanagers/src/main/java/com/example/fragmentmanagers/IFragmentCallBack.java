package com.example.fragmentmanagers;

public interface IFragmentCallBack {
    void sendMsgToActivity(String string);

    String getMsgFromActivity(String msg);
}
