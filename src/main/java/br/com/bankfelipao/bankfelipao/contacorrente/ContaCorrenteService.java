package br.com.bankfelipao.bankfelipao.contacorrente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaCorrenteService {
    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    public List<ContaCorrenteResponseDTO> findAll() {
        return contaCorrenteRepository.findAll()
                .stream()
                .map(ContaCorrenteResponseDTO::convertFromEntity)
                .collect(Collectors.toList());
    }

    public void create(ContaCorrenteRequestDTO contaCorrenteRequestDTO) {
        ContaCorrente contaCorrente = contaCorrenteRequestDTO.convertToEntity();
        contaCorrenteRepository.save(contaCorrente);
    }

    public ContaBancaria pegaContaBancariaDaAgenciaEContaCorrente(String agencia, String contaCorrente) {
        return   contaCorrenteRepository
                .findByAgenciaAndContaCorrente(agencia, contaCorrente).orElseThrow(ContaBancariaNotFoundExcepetion::new);
    }

    public void save(ContaBancaria contaBancaria) {
        contaCorrenteRepository.save((ContaCorrente) contaBancaria);
    }
}
