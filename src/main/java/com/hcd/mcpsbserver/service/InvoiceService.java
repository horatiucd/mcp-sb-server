package com.hcd.mcpsbserver.service;

import com.hcd.mcpsbserver.domain.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final Logger log = LoggerFactory.getLogger(InvoiceService.class);

    public List<Invoice> findBy(String pattern) {
        log.info("Retrieving invoices having '{}' in their number", pattern);

        return List.of(
                new Invoice(1, "att-invoice-1", "2025-06-01",
                        "AT&T", "Local", "Paid", 101.0),
                new Invoice(2, "att-invoice-2", "2025-07-01",
                        "AT&T", "VOIP", "Paid", 102.0),
                new Invoice(3, "att-invoice-31", "2025-08-01",
                        "AT&T", "Internet", "Paid", 103.0),
                new Invoice(3, "att-invoice-32", "2025-08-02",
                        "AT&T", "Toll Free", "Paid", 103.0),
                new Invoice(4, "att-invoice-33", "2025-08-03",
                        "AT&T", "Dark Fiber", "Approved", 104.01),
                new Invoice(5, "att-invoice-34", "2025-08-04",
                        "AT&T", "Dark Fiber", "Under Review", 105.01),
                new Invoice(6, "att-invoice-4", "2025-09-01",
                        "AT&T", "VOIP", "Paid", 15.01));

    }
}
