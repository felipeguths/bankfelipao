package br.com.bankfelipao.bankfelipao.logtransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogTransactionService {
    @Autowired
    private LogTransactionRepository logTransactionRepository;

    public LogTransaction findById(Long id){
        return logTransactionRepository
                .findById(id)
                .orElseThrow(LogTransactionNotFoundException::new);
    }

    public LogTransactionResponseDTO findByIdDTO(Long id) {
        LogTransaction logTransaction = findById(id);
        return LogTransactionResponseDTO.convertFromEntity(logTransaction);
    }
}
