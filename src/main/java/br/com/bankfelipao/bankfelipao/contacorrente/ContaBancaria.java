package br.com.bankfelipao.bankfelipao.contacorrente;

import java.math.BigDecimal;

public interface ContaBancaria {
    void consultaExtrato();
    String consultaSaldo();
    Long getId();
    void depositaConta(BigDecimal valorDepositado);

    void sacaConta(BigDecimal valorSacado);
}
