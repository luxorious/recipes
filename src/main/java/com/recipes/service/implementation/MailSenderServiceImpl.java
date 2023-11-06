package com.recipes.service.implementation;

import com.recipes.service.interfaces.MailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailSenderServiceImpl implements MailSenderService {

    @Override
    public synchronized void send(String mail, String text) {
        //do something )
    }
}
