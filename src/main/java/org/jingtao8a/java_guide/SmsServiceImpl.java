package org.jingtao8a.java_guide;

public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("send message " + message);
        return message;
    }
}
