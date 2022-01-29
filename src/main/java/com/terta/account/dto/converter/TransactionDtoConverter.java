package com.terta.account.dto.converter;

import com.terta.account.dto.TransactionDto;
import com.terta.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction from) {
        return new TransactionDto (from.getId (),
                from.getTransactionType (),
                from.getAccount (),
                from.getTransactionDate ());
    }
}
