package org.jingtao8a.java_guide.SPI;

public class test1 {
    public static void main(String[] args) {
        LoggerService service = LoggerService.getService();
        service.info("Hello SPI");
        service.info("Hello SPI");
    }
}
