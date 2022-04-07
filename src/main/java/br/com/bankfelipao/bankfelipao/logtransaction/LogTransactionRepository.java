package br.com.bankfelipao.bankfelipao.logtransaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogTransactionRepository extends JpaRepository<LogTransaction, Long> {
}
