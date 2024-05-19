package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

public class ScrewdriverManager {
    private static int setIdCounter = 1;
    private static int IDCounter = 0;
    private List<Screwdriver> screwdrivers;
    private List<ScrewdriverSet> screwdriverSets;
    private static Log log;

    static {
        try {
            log = new Log("ScrewdriverManager_log.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ScrewdriverManager() {
        this.screwdrivers = new ArrayList<>();
        this.screwdriverSets = new ArrayList<>();
        log.logger.info("Создан менеджер отвёрток");
    }

    public void createScrewdriver(String handleType, String tipType, int size) {
        try {
            int id = generateID();
            Screwdriver screwdriver = new Screwdriver(id, handleType, tipType, size);
            screwdrivers.add(screwdriver);
            log.logger.info("Создана отвёртка: " + screwdriver);
        } catch (Exception e) {
            log.logger.log(Level.SEVERE, "Ошибка при создании отвёртки", e);
        }
    }

    public void findScrewdriverByID(int id) {
        try {
            for (Screwdriver screwdriver : screwdrivers) {
                if (screwdriver.getId() == id) {
                    System.out.println("Найдена отвёртка:");
                    System.out.println(screwdriver);
                    log.logger.info("Найдена отвёртка с ID: " + id);
                    return;
                }
            }
            System.out.println("Отвёртка с указанным идентификатором не найдена.");
            log.logger.warning("Отвёртка с ID " + id + " не найдена");
        } catch (Exception e) {
            log.logger.log(Level.SEVERE, "Ошибка при поиске отвёртки", e);
        }
    }

    public void updateScrewdriver(int id, String handleType, String tipType, int size) {
        try {
            for (Screwdriver screwdriver : screwdrivers) {
                if (screwdriver.getId() == id) {
                    screwdriver.setHandleType(handleType);
                    screwdriver.setTipType(tipType);
                    screwdriver.setSize(size);
                    System.out.println("Параметры отвёртки с идентификатором " + id + " обновлены.");
                    log.logger.info("Обновлена отвёртка с ID: " + id);
                    return;
                }
            }
            System.out.println("Отвёртка с указанным идентификатором не найдена.");
            log.logger.warning("Отвёртка с ID " + id + " не найдена");
        } catch (Exception e) {
            log.logger.log(Level.SEVERE, "Ошибка при обновлении отвёртки", e);
        }
    }

    public void deleteScrewdriverById(int id) {
        try {
            for (Screwdriver screwdriver : screwdrivers) {
                if (screwdriver.getId() == id) {
                    screwdrivers.remove(screwdriver);
                    System.out.println("Отвёртка с идентификатором " + id + " удалена.");
                    log.logger.info("Удалена отвёртка с ID: " + id);
                    return;
                }
            }
            System.out.println("Отвёртка с указанным идентификатором не найдена.");
            log.logger.warning("Отвёртка с ID " + id + " не найдена");
        } catch (Exception e) {
            log.logger.log(Level.SEVERE, "Ошибка при удалении отвёртки", e);
        }
    }

    public void displayAllScrewdrivers() {
        try {
            if (screwdrivers.isEmpty()) {
                System.out.println("Список отвёрток пуст.");
                log.logger.info("Список отвёрток пуст");
            } else {
                System.out.println("Список всех отвёрток:");
                for (Screwdriver screwdriver : screwdrivers) {
                    System.out.println(screwdriver);
                }
                log.logger.info("Отображён список всех отвёрток");
            }
        } catch (Exception e) {
            log.logger.log(Level.SEVERE, "Ошибка при отображении всех отвёрток", e);
        }
    }

    public void countScrewdriversBySize(int size) {
        try {
            int count = 0;
            for (Screwdriver screwdriver : screwdrivers) {
                if (screwdriver.getSize() == size) {
                    count++;
                }
            }
            System.out.println("Количество отвёрток размера " + size + ": " + count);
            log.logger.info("Подсчитано количество отвёрток размера " + size + ": " + count);
        } catch (Exception e) {
            log.logger.log(Level.SEVERE, "Ошибка при подсчёте отвёрток по размеру", e);
        }
    }

    public void clearAllScrewdrivers() {
        try {
            screwdrivers.clear();
            System.out.println("Все отвёртки удалены.");
            log.logger.info("Все отвёртки удалены");
        } catch (Exception e) {
            log.logger.log(Level.SEVERE, "Ошибка при удалении всех отвёрток", e);
        }
    }

    public void displayScrewdriversStatistics() {
        try {
            int total = screwdrivers.size();
            int minSize = Integer.MAX_VALUE;
            int maxSize = Integer.MIN_VALUE;
            int totalSize = 0;

            for (Screwdriver screwdriver : screwdrivers) {
                int size = screwdriver.getSize();
                if (size < minSize) {
                    minSize = size;
                }
                if (size > maxSize) {
                    maxSize = size;
                }
                totalSize += size;
            }

            double averageSize = (total == 0) ? 0 : (double) totalSize / total;

            System.out.println("Статистика отвёрток:");
            System.out.println("Общее количество: " + total);
            System.out.println("Минимальный размер: " + minSize);
            System.out.println("Максимальный размер: " + maxSize);
            System.out.println("Средний размер: " + averageSize);

            log.logger.info("Просмотрена статистика отвёрток");
        } catch (Exception e) {
            log.logger.log(Level.SEVERE, "Ошибка при отображении статистики", e);
        }
    }

    public void createSetOfScrewdrivers(Scanner scanner) {
        try {
            List<Screwdriver> setScrewdrivers = new ArrayList<>();
            System.out.println("Введите количество отвёрток в наборе:");
            int numberOfScrewdrivers = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numberOfScrewdrivers; i++) {
                System.out.println("Введите тип рукоятки для отвёртки " + (i + 1) + ":");
                String handleType = scanner.nextLine();
                System.out.println("Введите тип наконечника для отвёртки " + (i + 1) + ":");
                String tipType = scanner.nextLine();
                System.out.println("Введите размер для отвёртки " + (i + 1) + ":");
                int size = scanner.nextInt();
                scanner.nextLine();
                setScrewdrivers.add(new Screwdriver(generateID(), handleType, tipType, size));
            }
            ScrewdriverSet set = new ScrewdriverSet(setIdCounter++, setScrewdrivers);
            screwdriverSets.add(set);
            System.out.println("Набор отвёрток создан:");
            System.out.println(set);

            log.logger.info("Создан новый набор отвёрток: " + set);
        } catch (Exception e) {
            log.logger.log(Level.SEVERE, "Ошибка при создании набора отвёрток", e);
        }
    }

    public void displayAvailableSets() {
        try {
            if (screwdriverSets.isEmpty()) {
                System.out.println("Наборы отвёрток отсутствуют.");
                log.logger.info("Наборы отвёрток отсутствуют");
            } else {
                System.out.println("Доступные наборы отвёрток:");
                for (ScrewdriverSet set : screwdriverSets) {
                    System.out.println(set);
                }
                log.logger.info("Отображены доступные наборы отвёрток");
            }
        } catch (Exception e) {
            log.logger.log(Level.SEVERE, "Ошибка при отображении наборов отвёрток", e);
        }
    }

    private int generateID() {
        return ++IDCounter;
    }
}
