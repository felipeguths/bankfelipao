package br.com.bankfelipao.bankfelipao.contacorrente;

import br.com.bankfelipao.bankfelipao.transacao.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaqueEmContaBancariaUseCase {
    @Autowired
    private ContaCorrenteService contaCorrenteService;
    @Autowired
    private TransacaoService transacaoService;

    public void saque(SaqueContaCorrenteRequestDTO saqueContaCorrenteRequestDTO){
        ContaBancaria contaBancaria = contaCorrenteService
                .pegaContaBancariaDaAgenciaEContaCorrente(saqueContaCorrenteRequestDTO.getAgencia(), saqueContaCorrenteRequestDTO.getContaCorrente());
        contaBancaria.sacaConta(saqueContaCorrenteRequestDTO.getValorSacado());
        contaCorrenteService.save(contaBancaria);
        transacaoService.registraSaque(contaBancaria, saqueContaCorrenteRequestDTO);
    }
}


