package br.com.bankfelipao.bankfelipao.logtransaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LogTransactionRequestDTO {
    private String transactionCode;
    private String agencia;
    private String contaCorrente;
    private String valueTransaction;

    public LogTransaction createLogEntity(){
        return new LogTransaction(transactionCode, agencia, contaCorrente, valueTransaction);
    }
}
