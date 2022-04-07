package br.com.bankfelipao.bankfelipao.contacorrente;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ContaCorrenteRequestDTO {
    @NotBlank(message = "Deve passar uma agencia")
    private String agencia;
    @NotBlank(message = "Deve passar uma conta corrente")
    private String contaCorrente;

    public ContaCorrente convertToEntity() {
        return new ContaCorrente(agencia, contaCorrente);
    }
}