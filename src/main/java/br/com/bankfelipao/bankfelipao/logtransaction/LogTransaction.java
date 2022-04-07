package br.com.bankfelipao.bankfelipao.logtransaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "Log_de_Transação")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "transaction_code")
    private String transactionCode;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "conta_corrente")
    private String contaCorrente;
    @Column(name = "value_transaction")
    private String valueTransaction;
    @CreationTimestamp
    private LocalDateTime dateTime;


    public LogTransaction(String transactionCode, String agencia, String contaCorrente, String valueTransaction) {
        this.transactionCode = transactionCode;
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
        this.valueTransaction = valueTransaction;
    }

    public void updateValuesFrom(LogTransactionRequestDTO logTransactionRequestDTO) {
        this.transactionCode = logTransactionRequestDTO.getTransactionCode();
        this.agencia = logTransactionRequestDTO.getAgencia();
        this.contaCorrente = logTransactionRequestDTO.getContaCorrente();
        this.valueTransaction = logTransactionRequestDTO.getValueTransaction();
    }
}
