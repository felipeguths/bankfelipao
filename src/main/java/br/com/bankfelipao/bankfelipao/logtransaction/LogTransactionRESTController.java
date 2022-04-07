package br.com.bankfelipao.bankfelipao.logtransaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/logtransaction")
@RestController
public class LogTransactionRESTController {
    @Autowired
    private LogTransactionRepository logTransactionRepository;
    @Autowired
    private LogTransactionService logTransactionService;

    @PostMapping
    public void create(@RequestBody LogTransactionRequestDTO logTransactionRequestDTO){
        LogTransaction logTransaction = logTransactionRequestDTO.createLogEntity();
        logTransactionRepository.save(logTransaction);
    }
    @GetMapping
    public List<LogTransactionResponseDTO> findAll() {
        return logTransactionRepository.findAll()
                .stream()
                .map(LogTransactionResponseDTO::convertFromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LogTransactionResponseDTO findById(@PathVariable Long id){

        return logTransactionService.findByIdDTO(id);
    }

    @PutMapping("/{id}")
    public LogTransactionResponseDTO updateById(@PathVariable Long id, @RequestBody LogTransactionRequestDTO logTransactionRequestDTO){
        LogTransaction logTransaction = logTransactionService.findById(id);
        logTransaction.updateValuesFrom(logTransactionRequestDTO);
        LogTransaction logTransactionUpdated = logTransactionRepository.save(logTransaction);
        return LogTransactionResponseDTO.convertFromEntity(logTransactionUpdated);
    }
}
