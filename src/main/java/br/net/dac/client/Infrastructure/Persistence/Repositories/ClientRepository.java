package br.net.dac.client.Infrastructure.Persistence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.net.dac.client.Domain.Entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findOneByCpf(@Param("cpf") String cpf);
}