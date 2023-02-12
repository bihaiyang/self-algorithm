package com.bii.spi;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/01/09
 */
public class Main {
    
    
    public static void main(String[] args) {
        LoggerService service = LoggerService.getService();
        service.info("hello SPI");
        service.debug("hello SPI");
    }
}
