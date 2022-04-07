package br.com.bankfelipao.bankfelipao.contacorrente;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ContaCorrenteResponseDTO {
    private String agencia;
    private String contaCorrente;
    private BigDecimal saldo;

    public static ContaCorrenteResponseDTO convertFromEntity(ContaCorrente contaCorrente) {
        return new ContaCorrenteResponseDTOBuilder()
                .agencia(contaCorrente.getAgencia())
                .contaCorrente(contaCorrente.getContaCorrente())
                .saldo(contaCorrente.getSaldo())
                .build();
    }
}
