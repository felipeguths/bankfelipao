package br.com.bankfelipao.bankfelipao.logtransaction;

public class LogTransactionNotFoundException extends RuntimeException {
    public LogTransactionNotFoundException(){
        super("Log de transação não encontrada");
    }
}
