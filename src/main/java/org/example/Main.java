package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScrewdriverManager screwdriverManager = new ScrewdriverManager();
        Log log;

        try {
            log = new Log("Main_log.log");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Создать отвёртку");
            System.out.println("2. Найти отвёртку по идентификатору");
            System.out.println("3. Обновить параметры отвёртки");
            System.out.println("4. Удалить отвёртку по идентификатору");
            System.out.println("5. Показать все отвёртки");
            System.out.println("6. Подсчитать количество отвёрток по размеру");
            System.out.println("7. Удалить все отвёртки");
            System.out.println("8. Показать статистику отвёрток");
            System.out.println("9. Создать набор отвёрток");
            System.out.println("10. Показать доступные наборы отвёрток");
            System.out.println("11. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введите тип рукоятки:");
                    String handleType = scanner.nextLine();
                    System.out.println("Введите тип наконечника:");
                    String tipType = scanner.nextLine();
                    System.out.println("Введите размер:");
                    if (scanner.hasNextInt()) {
                        int size = scanner.nextInt();
                        scanner.nextLine();
                        screwdriverManager.createScrewdriver(handleType, tipType, size);
                    } else {
                        System.out.println("Некорректный ввод размера. Размер должен быть целым числом.");
                        scanner.nextLine();
                        log.logger.warning("Некорректный ввод размера при создании отвёртки");
                    }
                    break;
                case 2:
                    System.out.println("Введите идентификатор отвёртки:");
                    if (scanner.hasNextInt()) {
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        screwdriverManager.findScrewdriverByID(id);
                    } else {
                        System.out.println("Некорректный ввод идентификатора. Идентификатор должен быть целым числом.");
                        scanner.nextLine();
                        log.logger.warning("Некорректный ввод идентификатора при поиске отвёртки");
                    }
                    break;
                case 3:
                    System.out.println("Введите идентификатор отвёртки:");
                    if (scanner.hasNextInt()) {
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Введите новый тип рукоятки:");
                        handleType = scanner.nextLine();
                        System.out.println("Введите новый тип наконечника:");
                        tipType = scanner.nextLine();
                        System.out.println("Введите новый размер:");
                        if (scanner.hasNextInt()) {
                            int size = scanner.nextInt();
                            scanner.nextLine();
                            screwdriverManager.updateScrewdriver(id, handleType, tipType, size);
                        } else {
                            System.out.println("Некорректный ввод размера. Размер должен быть целым числом.");
                            scanner.nextLine();
                            log.logger.warning("Некорректный ввод размера при обновлении отвёртки");
                        }
                    } else {
                        System.out.println("Некорректный ввод идентификатора. Идентификатор должен быть целым числом.");
                        scanner.nextLine();
                        log.logger.warning("Некорректный ввод идентификатора при обновлении отвёртки");
                    }
                    break;
                case 4:
                    System.out.println("Введите идентификатор отвёртки:");
                    if (scanner.hasNextInt()) {
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        screwdriverManager.deleteScrewdriverById(id);
                    } else {
                        System.out.println("Некорректный ввод идентификатора. Идентификатор должен быть целым числом.");
                        scanner.nextLine();
                        log.logger.warning("Некорректный ввод идентификатора при удалении отвёртки");
                    }
                    break;
                case 5:
                    screwdriverManager.displayAllScrewdrivers();
                    break;
                case 6:
                    System.out.println("Введите размер отвёртки:");
                    if (scanner.hasNextInt()) {
                        int size = scanner.nextInt();
                        scanner.nextLine();
                        screwdriverManager.countScrewdriversBySize(size);
                    } else {
                        System.out.println("Некорректный ввод размера. Размер должен быть целым числом.");
                        scanner.nextLine();
                        log.logger.warning("Некорректный ввод размера при подсчёте количества отвёрток");
                    }
                    break;
                case 7:
                    screwdriverManager.clearAllScrewdrivers();
                    break;
                case 8:
                    screwdriverManager.displayScrewdriversStatistics();
                    break;
                case 9:
                    screwdriverManager.createSetOfScrewdrivers(scanner);
                    break;
                case 10:
                    screwdriverManager.displayAvailableSets();
                    break;
                case 11:
                    System.out.println("Выход из программы.");
                    log.logger.info("Выход из программы");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 11.");
                    log.logger.warning("Некорректный выбор в главном меню");
            }
        }
    }
}
