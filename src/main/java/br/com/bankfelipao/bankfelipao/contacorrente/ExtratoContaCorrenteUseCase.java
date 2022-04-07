package br.com.bankfelipao.bankfelipao.contacorrente;

import br.com.bankfelipao.bankfelipao.transacao.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExtratoContaCorrenteUseCase {
    @Autowired
    private ContaCorrenteService contaCorrenteService;
    @Autowired
    private TransacaoService transacaoService;

    public List<MovimentacaoContaCorrenteResponseDTO> extrato(ExtratoContaCorrenteRequestDTO extratoContaCorrenteRequestDTO) {
        ContaBancaria contaBancaria = contaCorrenteService.pegaContaBancariaDaAgenciaEContaCorrente(extratoContaCorrenteRequestDTO.getAgencia(), extratoContaCorrenteRequestDTO.getContaCorrente());
                return transacaoService.buscaListaDasTransacoesDaContaBancaria(contaBancaria, extratoContaCorrenteRequestDTO);
    }
}
