package com.hcd.mcpsbserver.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class InvoiceTools {

    @Tool(description = "Returns the number of invoices in July")
    public int invoicesCount() {
        return 33;
    }
}
