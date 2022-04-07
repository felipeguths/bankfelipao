package br.com.bankfelipao.bankfelipao.contacorrente;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ExtratoContaCorrenteRequestDTO  {

    @NotBlank(message = "Deve passar uma agencia")
    private String agencia;

    @NotBlank(message = "Deve passar uma conta corrente")
    private String contaCorrente;

    @NotNull(message = "Deve passar uma data inicial para extrato")
    private LocalDate dataInicial;

    @NotNull(message = "Deve passar uma data final para extrato")
    private LocalDate dataFinal;

    @AssertTrue(message = "Deve passar uma data inicial menor que a data final")
    public boolean isDataInicialMenorQueDataFinal(){
        if (dataInicial.isEqual(dataFinal)) return true;
        else return dataInicial.isBefore(dataFinal);
    }

    public LocalDateTime getDataInicialProBanco() {
        return this.dataInicial.atTime(0,0,0);
    }

    public LocalDateTime getDataFinalProBanco() {
        return this.dataFinal.atTime(23,59,59);
    }
}
