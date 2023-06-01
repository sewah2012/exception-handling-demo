package io.undefvar.exceptiondemo.loaders;

import io.undefvar.exceptiondemo.entities.AccountEntity;
import io.undefvar.exceptiondemo.repositories.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountsLoader {
    private final TransferRepository transferRepository;

    @Bean
    ApplicationRunner applicationRunner(){
        return args -> {
            var account1 = AccountEntity.builder()
                    .id(UUID.randomUUID())
                    .balance(10.0)
                    .email("account1@undefvar.io")
                    .firstName("account1")
                    .lastName("account1")
                    .build();

            var account2 = AccountEntity.builder()
                    .id(UUID.randomUUID())
                    .balance(10000.0)
                    .email("account2@undefvar.io")
                    .firstName("account2")
                    .lastName("account2")
                    .build();

            var account3 = AccountEntity.builder()
                    .id(UUID.randomUUID())
                    .balance(20000.0)
                    .email("account3@undefvar.io")
                    .firstName("account3")
                    .lastName("account3")
                    .build();

            transferRepository.saveAll(List.of(account1, account2, account3));
        };
    }
}
