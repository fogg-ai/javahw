package it.step;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String consScan;
        String[] sp;
        String path = null;
        boolean check = false;
        a:
        while (true) {
            System.out.println("\nКоманды консоли: \n" +
                    "dir — выводит список файлов в текущей директории\n" +
                    "cd «путь» — перейти в директорию, путь к которой задан первым аргументом\n" +
                    "pwd — вывести полный путь до текущей директории\n" +
                    "cat «имя_файла» - выводит содержимое текстового файла «имя_файла»" +
                    "break - завершить работу програмы");
            consScan = scanner.nextLine();
            sp = consScan.split(" ");

            switch (sp[0]) {
                case "dir":
                    if (!check) {
                        new Dir(pathFile(sp));
                    } else {
                        new Dir(path);
                    }
                    break;
                case "cd":
                    path = new CD(pathFile(sp)).getPath();
                    check = true;
                    break;

                case "pwd":
                    if (!check) {
                        new PWD(pathFile(sp));
                    } else {
                        new PWD(path);
                    }
                    break;

                case "cat":
                    new Cat(pathFile(sp));
                    break;
                case "download":
                    new Download();
                    break;
                case "break":

                    break a;
            }
        }
    }

    static private String pathFile(String[] sp) {
        String path;

        if (sp[0].equals("dir") || "pwd".equals(sp[0])) {
            path = System.getProperty("user.dir");
        } else {
            try {
                path = sp[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Вы не ввели путь(имя)");
                System.err.println(e.getMessage());
                path = System.getProperty("user.dir");
            }

        }

        return path;
    }

}
