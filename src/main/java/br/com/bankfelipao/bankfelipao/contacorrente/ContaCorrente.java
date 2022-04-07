package br.com.bankfelipao.bankfelipao.contacorrente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_conta_corrente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaCorrente implements ContaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id(numero) auto increment no MYSQL
    private Long id;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "conta_corrente")
    private String contaCorrente;
    @Column(name = "saldo")
    private BigDecimal saldo;

    public ContaCorrente(String agencia, String contaCorrente) {
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
        this.saldo = BigDecimal.ZERO;
    }


    @Override
    public void sacaConta(BigDecimal valorSacado) {
        if (saldo.compareTo(valorSacado) >= 0){
            this.saldo = this.saldo.subtract(valorSacado);
        } else {
            throw new SemSaldoSuficienteException();
        }
    }

    @Override
    public void consultaExtrato() {
        System.out.println("Consulta extrato");
    }

    @Override
    public String consultaSaldo() {
        return this.saldo.toString();
    }

    @Override
    public void depositaConta(BigDecimal valorDepositado) {
        this.saldo = this.saldo.add(valorDepositado);
    }
}
