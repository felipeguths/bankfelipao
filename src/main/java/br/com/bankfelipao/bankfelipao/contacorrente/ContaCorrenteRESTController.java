package br.com.bankfelipao.bankfelipao.contacorrente;


import br.com.bankfelipao.bankfelipao.respostadto.RespostaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/conta-corrente")
@RestController
public class ContaCorrenteRESTController {
    @Autowired
    private ContaCorrenteService contaCorrenteService;
    @Autowired
    private DepositaEmContaBancariaUseCase depositaEmContaBancariaUseCase;
    @Autowired
    private SaqueEmContaBancariaUseCase saqueEmContaBancariaUseCase;
    @Autowired
    private ExtratoContaCorrenteUseCase extratoContaCorrenteUseCase;
    @Autowired
    private ConsultaSaldoUseCase consultaSaldoUseCase;

    @GetMapping
    public List<ContaCorrenteResponseDTO> findAll(){
        return contaCorrenteService.findAll();
    }

    @PostMapping
    public void create(@RequestBody @Valid ContaCorrenteRequestDTO contaCorrenteRequestDTO){
        contaCorrenteService.create(contaCorrenteRequestDTO);
    }

    @PostMapping("/deposita")
    public String deposita(@RequestBody @Valid DepositaContaCorrenteRequestDTO depositaContaCorrenteRequestDTO){
        depositaEmContaBancariaUseCase.deposita(depositaContaCorrenteRequestDTO);
        return "Transação de Depósito executada com sucesso";
    }

    @PostMapping("/saque")
    public RespostaDTO saque(@RequestBody @Valid SaqueContaCorrenteRequestDTO saqueContaCorrenteRequestDTO){
        saqueEmContaBancariaUseCase.saque(saqueContaCorrenteRequestDTO);
        return new RespostaDTO("Transação de Saque executada com sucesso");
    }

    @GetMapping("/extrato")
    public List<MovimentacaoContaCorrenteResponseDTO> extrato(@RequestBody @Valid ExtratoContaCorrenteRequestDTO extratoContaCorrenteRequestDTO){
        return extratoContaCorrenteUseCase.extrato(extratoContaCorrenteRequestDTO);

    }

    @GetMapping("/consulta")
    public ConsultaSaldoResponseDTO consulta(@RequestBody @Valid ConsultaSaldoRequestDTO consultaSaldoRequestDTO){
        return consultaSaldoUseCase.consulta(consultaSaldoRequestDTO);
    }

}
