package br.com.bankfelipao.bankfelipao.contacorrente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
    Optional<ContaCorrente> findByAgenciaAndContaCorrente(String agencia, String contaCorrente);
}
