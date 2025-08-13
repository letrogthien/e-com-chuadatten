package com.chuadatten.user.outbox;

import com.chuadatten.event.RegistrationEvent;
import com.chuadatten.user.common.Status;
import com.chuadatten.user.kafka.EventProducer;
import com.chuadatten.user.outbox.repo.RegisterOutBoxRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutBoxSchedule {
    private final RegisterOutBoxRepository registerOutBoxRepository;
    private final EventProducer eventProducer;


    @Scheduled(fixedRate = 1000)
    public void processRegisterEventOutBox() {
        List<RegisterOutBox> pendingMessages = registerOutBoxRepository.findAllByStatusOrderByCreatedAtAsc(Status.PENDING);
        handleRegisterRecords(pendingMessages);
    }

    @Scheduled(fixedRate = 1000)
    public void processRetryRegisterEventOutBox() {
        List<RegisterOutBox> pendingMessages = registerOutBoxRepository.findAllByStatusOrderByCreatedAtAsc(Status.RETRY);
        handleRegisterRecords(pendingMessages);
    }

    private void handleRegisterRecords(List<RegisterOutBox> pendingMessages) {
        for (var message : pendingMessages) {
            try {
                RegistrationEvent event = RegistrationEvent.builder()
                        .email(message.getEmail())
                        .userId(message.getUserId().toString())
                        .urlActive(message.getUrlActivation())
                        .build();
                eventProducer.registerUser(event);
                message.setStatus(Status.SUCCESS);
            } catch (Exception e) {
                message.setStatus(Status.RETRY);
            }
            registerOutBoxRepository.save(message);
        }
    }



}
