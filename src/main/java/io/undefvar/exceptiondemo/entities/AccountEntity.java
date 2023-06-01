package io.undefvar.exceptiondemo.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("ACCOUNTS")
public class AccountEntity {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Double balance;

    @Version
    int version;
}
