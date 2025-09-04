package com.chuadatten.notify.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.chuadatten.event.OtpEvent;
import com.chuadatten.event.PasswordResetEvent;
import com.chuadatten.event.RegistrationEvent;
import com.chuadatten.event.StrangeDevice;
import com.chuadatten.notify.mail.EmailSender;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EventListener {
    private final EmailSender emailSender;
    @KafkaListener(topics = "user-register", concurrency = "3",groupId = "group1")
    public void listenRegister(ConsumerRecord<String ,RegistrationEvent> consumerRecord) throws MessagingException {
        RegistrationEvent registrationEvent =  consumerRecord.value();
        emailSender.sendBrandedEmail(registrationEvent.getEmail(), "registration success",registrationEvent.getUrlActive());
    }


    @KafkaListener(topics = "user-forgot-password", concurrency = "3",groupId = "group1")
    public void listenForgotPassword(ConsumerRecord<String ,PasswordResetEvent> consumerRecord) throws MessagingException {
        PasswordResetEvent passwordResetEvent =  consumerRecord.value();
        emailSender.sendBrandedEmail(passwordResetEvent.getEmail(), "reset password",passwordResetEvent.getUrl());
    }


    @KafkaListener(topics = "user-send-otp", concurrency = "3",groupId = "group1")
    public void listenSendOtp(ConsumerRecord<String ,OtpEvent> consumerRecord) throws MessagingException {
        OtpEvent otpEvent =  consumerRecord.value();
        emailSender.sendBrandedEmail(otpEvent.getEmail(), "otp", otpEvent.getOtp()
        );
    }

    @KafkaListener(topics = "user-strange-device", concurrency = "3",groupId = "group1")
    public void listenStrangeDevice(ConsumerRecord<String ,StrangeDevice> consumerRecord) throws MessagingException {
        StrangeDevice strangeDevice =  consumerRecord.value();
        emailSender.sendBrandedEmail(strangeDevice.getEmail(), "strange device", strangeDevice.getDeviceType() + strangeDevice.getDevideName());
    }




}
