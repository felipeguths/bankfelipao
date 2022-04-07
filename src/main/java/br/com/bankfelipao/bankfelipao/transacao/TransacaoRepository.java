package br.com.bankfelipao.bankfelipao.transacao;

import br.com.bankfelipao.bankfelipao.contacorrente.MovimentacaoContaCorrenteResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    List<Transacao> findAllByContaCorrenteIdAndDateTimeBetween(Long id, LocalDateTime startDate, LocalDateTime endDate);
}
