package br.com.bankfelipao.bankfelipao.logtransaction;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class LogTransactionResponseDTO {
    private Long id;
    private String transactionCode;
    private String agencia;
    private String contaCorrente;
    private String valueTransaction;
    private LocalDateTime dateTime;

    public static LogTransactionResponseDTO convertFromEntity(LogTransaction logTransaction){
        return new LogTransactionResponseDTOBuilder()
                .id(logTransaction.getId())
                .transactionCode(logTransaction.getTransactionCode())
                .agencia(logTransaction.getAgencia())
                .contaCorrente(logTransaction.getContaCorrente())
                .valueTransaction(logTransaction.getValueTransaction())
                .dateTime(logTransaction.getDateTime())
                .build();
    }
}
