package br.com.bankfelipao.bankfelipao.contacorrente;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
public class DepositaContaCorrenteRequestDTO {

    @NotBlank(message = "Deve passar uma agencia")
    private String agencia;

    @NotBlank(message = "Deve passar uma conta corrente")
    private String contaCorrente;

    @NotNull(message = "Deve passar um valor para depósito")
    @Positive(message = "Deve passar um valor positivo")
    private BigDecimal valorDepositado;

}
