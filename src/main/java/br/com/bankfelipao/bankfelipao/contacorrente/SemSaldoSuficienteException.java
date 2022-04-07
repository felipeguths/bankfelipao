package br.com.bankfelipao.bankfelipao.contacorrente;

public class SemSaldoSuficienteException extends RuntimeException {
    public SemSaldoSuficienteException() {
        super("Sem Saldo Suficiente Para Realizar a Operação");
    }
}
