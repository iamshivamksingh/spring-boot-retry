package com.example.demo;

import com.example.demo.helper.ConfigLoaderHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author sksingh created on 18/01/24
 */
@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final ConfigLoaderHelper configLoaderHelper;

    @Override
    public void run(String... args) throws Exception {
        // System.out.println(configLoaderHelper.getMetadata());

        // System.out.println(configLoaderHelper.getEmailProperty());

        // System.out.println(configLoaderHelper.getSupportEmails());

        // System.out.println(configLoaderHelper.getOrderStatusesForRemoval());
    }
}
