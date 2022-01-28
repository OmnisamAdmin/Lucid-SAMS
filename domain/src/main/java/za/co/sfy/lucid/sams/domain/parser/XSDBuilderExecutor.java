package za.co.sfy.lucid.sams.domain.parser;

import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;

import java.io.IOException;

public class XSDBuilderExecutor {

    public static void main(String[] args) throws LucidSamsExecutionException, IOException {
        XSDBuilder xsdBuilder = new XSDBuilder();
        xsdBuilder.read();
    }
}
