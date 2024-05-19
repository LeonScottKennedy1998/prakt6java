package org.example;

import java.io.IOException;

public class Screwdriver {
    private int id;
    private String handleType;
    private String tipType;
    private int size;
    private static Log my_log;

    static {
        try {
            my_log = new Log("screwdriver_log.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Screwdriver(int id, String handleType, String tipType, int size) {
        this.id = id;
        this.handleType = handleType;
        this.tipType = tipType;
        this.size = size;
        my_log.logger.info("Создана отвёртка с ID: " + id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        my_log.logger.info("ID отвёртки изменен на: " + id);
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
        my_log.logger.info("Тип рукоятки изменен на: " + handleType);
    }

    public String getTipType() {
        return tipType;
    }

    public void setTipType(String tipType) {
        this.tipType = tipType;
        my_log.logger.info("Тип наконечника изменен на: " + tipType);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        my_log.logger.info("Размер изменен на: " + size);
    }

    @Override
    public String toString() {
        return "Отвёртка [Идентификатор: " + id + ", Тип рукоятки: " + handleType +
                ", Тип наконечника: " + tipType + ", Размер: " + size + "]";
    }
}
