package br.com.bankfelipao.bankfelipao.contacorrente;

import br.com.bankfelipao.bankfelipao.transacao.Transacao;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class MovimentacaoContaCorrenteResponseDTO {
    private String data;
    private String valorDoMovimento;

    public static MovimentacaoContaCorrenteResponseDTO cria(Transacao transacao) {
        return new MovimentacaoContaCorrenteResponseDTOBuilder()
                .data(transacao.getDataParaExtrato())
                .valorDoMovimento(transacao.getValorParaExtrato())
                .build();
    }
}
