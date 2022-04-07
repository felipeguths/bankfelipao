package br.com.bankfelipao.bankfelipao.transacao;

public enum NaturezaTransacao {
    DEBITO{
        @Override
        public String getSinalDaTransacao() {
            return "+";
        }
    }, CREDITO {
        @Override
        public String getSinalDaTransacao() {
            return "-";
        }
    };

    public abstract String getSinalDaTransacao();
}
