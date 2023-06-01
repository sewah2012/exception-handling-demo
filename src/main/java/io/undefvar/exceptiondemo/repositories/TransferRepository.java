package io.undefvar.exceptiondemo.repositories;

import io.undefvar.exceptiondemo.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransferRepository extends CrudRepository<AccountEntity, UUID> {
}
