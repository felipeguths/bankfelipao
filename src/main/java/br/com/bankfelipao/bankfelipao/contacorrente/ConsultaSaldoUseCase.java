package br.com.bankfelipao.bankfelipao.contacorrente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaSaldoUseCase {

    @Autowired
    private ContaCorrenteService contaCorrenteService;

    public ConsultaSaldoResponseDTO consulta(ConsultaSaldoRequestDTO consultaSaldoRequestDTO){
        ContaBancaria contaBancaria = contaCorrenteService
                .pegaContaBancariaDaAgenciaEContaCorrente(consultaSaldoRequestDTO.getAgencia(), consultaSaldoRequestDTO.getContaCorrente());
        String saldo = contaBancaria.consultaSaldo();
        return new ConsultaSaldoResponseDTO(saldo);
    }
}


