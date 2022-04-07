package br.com.bankfelipao.bankfelipao.transacao;

import br.com.bankfelipao.bankfelipao.contacorrente.ContaBancaria;
import br.com.bankfelipao.bankfelipao.contacorrente.ContaCorrente;
import br.com.bankfelipao.bankfelipao.contacorrente.DepositaContaCorrenteRequestDTO;
import br.com.bankfelipao.bankfelipao.contacorrente.SaqueContaCorrenteRequestDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@Table(name = "tb_transacao")
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "natureza")
    @Enumerated(EnumType.STRING)
    private NaturezaTransacao naturezaTransacao;
    @ManyToOne
    private ContaCorrente contaCorrente;
    @Column(name = "valor")
    private BigDecimal valor;
    @CreationTimestamp
    private LocalDateTime dateTime;

    public Transacao(ContaBancaria contaBancaria, DepositaContaCorrenteRequestDTO deposita) {
        this.descricao = "agencia: " + deposita.getAgencia() + " contaCorrente: " + deposita.getContaCorrente() + " valorDepositado: " + deposita.getValorDepositado();
        this.naturezaTransacao = NaturezaTransacao.DEBITO;
        this.contaCorrente = (ContaCorrente) contaBancaria;
        this.valor = deposita.getValorDepositado();
    }

    public Transacao(ContaBancaria contaBancaria, SaqueContaCorrenteRequestDTO saque) {
        this.descricao = "agencia: " + saque.getAgencia() + " contaCorrente: " + saque.getContaCorrente() + " valorSacado: " + saque.getValorSacado();
        this.naturezaTransacao = NaturezaTransacao.CREDITO;
        this.contaCorrente = (ContaCorrente) contaBancaria;
        this.valor = saque.getValorSacado();
    }

    public String getValorParaExtrato() {
        return this.naturezaTransacao.getSinalDaTransacao() +" "+ this.valor;
    }

    public String getDataParaExtrato() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.dateTime.toLocalDate().format(formatter);

    }
}
