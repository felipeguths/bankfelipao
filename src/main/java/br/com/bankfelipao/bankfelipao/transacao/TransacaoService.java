package br.com.bankfelipao.bankfelipao.transacao;

import br.com.bankfelipao.bankfelipao.contacorrente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository transacaoRepository;


    public void registraDeposito(ContaBancaria contaBancaria, DepositaContaCorrenteRequestDTO depositaContaCorrenteRequestDTO) {
    Transacao transacao = new Transacao(contaBancaria, depositaContaCorrenteRequestDTO);
    transacaoRepository.save(transacao);
    }

    public void registraSaque(ContaBancaria contaBancaria, SaqueContaCorrenteRequestDTO saqueContaCorrenteRequestDTO) {
        Transacao transacao = new Transacao(contaBancaria, saqueContaCorrenteRequestDTO);
        transacaoRepository.save(transacao);
    }

    public List<MovimentacaoContaCorrenteResponseDTO> buscaListaDasTransacoesDaContaBancaria(ContaBancaria contaBancaria, ExtratoContaCorrenteRequestDTO extratoContaCorrenteRequestDTO) {
        return transacaoRepository.findAllByContaCorrenteIdAndDateTimeBetween(contaBancaria.getId(), extratoContaCorrenteRequestDTO.getDataInicialProBanco(), extratoContaCorrenteRequestDTO.getDataFinalProBanco())
                .stream().map(MovimentacaoContaCorrenteResponseDTO::cria).collect(Collectors.toList());
    }

}
