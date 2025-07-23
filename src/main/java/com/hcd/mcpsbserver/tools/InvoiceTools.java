package com.hcd.mcpsbserver.tools;

import com.hcd.mcpsbserver.domain.Invoice;
import com.hcd.mcpsbserver.service.InvoiceService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceTools {

    private final InvoiceService invoiceService;

    public InvoiceTools(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Tool(name = "get-invoices-by-pattern",
            description = "Returns all invoices filtered by the provided pattern.")
    public List<Invoice> invoices(String pattern) {
        return invoiceService.findByPattern(pattern);
    }
}
