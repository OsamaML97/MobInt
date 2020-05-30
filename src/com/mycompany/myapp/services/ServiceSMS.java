/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author OsamaML97
 */
public class ServiceSMS {
        public static final String ACCOUNT_SID = "AC6d0111938a93428bb65ca8dfc65783dd";
    public static final String AUTH_TOKEN = "14297ed07174908644f0e6def63bd94a";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+95127263"),
                new com.twilio.type.PhoneNumber("+12029522208"),
                "test")
            .create();

        System.out.println(message.getSid());
    }
}
    

