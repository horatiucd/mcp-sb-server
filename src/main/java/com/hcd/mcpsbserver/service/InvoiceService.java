package com.hcd.mcpsbserver.service;

import com.asentinel.common.orm.OrmOperations;
import com.hcd.mcpsbserver.domain.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final Logger log = LoggerFactory.getLogger(InvoiceService.class);

    private final OrmOperations orm;

    public InvoiceService(OrmOperations orm) {
        this.orm = orm;
    }

    public List<Invoice> findByPattern(String pattern) {
        log.info("Retrieving invoices having '{}' in their number", pattern);
         return orm.newSqlBuilder(Invoice.class)
                 .select()
                 .where()
                 .column(Invoice.COL_NUMBER).like('%' + pattern + '%')
                 .exec();
    }
}
