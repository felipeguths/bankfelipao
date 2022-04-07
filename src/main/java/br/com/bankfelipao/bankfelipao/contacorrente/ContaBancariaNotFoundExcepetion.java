package br.com.bankfelipao.bankfelipao.contacorrente;

public class ContaBancariaNotFoundExcepetion extends RuntimeException {
    public ContaBancariaNotFoundExcepetion() {
        super("Agencia ou Conta Corrente incorretas");
    }
}
