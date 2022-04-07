package br.com.bankfelipao.bankfelipao.contacorrente;

import br.com.bankfelipao.bankfelipao.transacao.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepositaEmContaBancariaUseCase {
    @Autowired
    private ContaCorrenteService contaCorrenteService;
    @Autowired
    private TransacaoService transacaoService;

    public void deposita(DepositaContaCorrenteRequestDTO depositaContaCorrenteRequestDTO) {
        ContaBancaria contaBancaria = contaCorrenteService
                .pegaContaBancariaDaAgenciaEContaCorrente(depositaContaCorrenteRequestDTO.getAgencia(), depositaContaCorrenteRequestDTO.getContaCorrente());
        contaBancaria.depositaConta(depositaContaCorrenteRequestDTO.getValorDepositado());
        contaCorrenteService.save(contaBancaria);
        transacaoService.registraDeposito(contaBancaria, depositaContaCorrenteRequestDTO);
    }
}
