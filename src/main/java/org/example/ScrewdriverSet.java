package org.example;

import java.io.IOException;
import java.util.List;

public class ScrewdriverSet {
    private int setId;
    private List<Screwdriver> screwdrivers;
    private static Log log;

    static {
        try {
            log = new Log("ScrewdriverSet_log.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ScrewdriverSet(int setId, List<Screwdriver> screwdrivers) {
        this.setId = setId;
        this.screwdrivers = screwdrivers;
        log.logger.info("Создан набор отвёрток с ID: " + setId);
    }

    public int getId() {
        return setId;
    }

    public void setId(int setId) {
        this.setId = setId;
        log.logger.info("ID набора отвёрток изменен на: " + setId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Набор отвёрток #").append(setId).append(": [");
        for (int i = 0; i < screwdrivers.size(); i++) {
            sb.append(screwdrivers.get(i));
            if (i < screwdrivers.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
