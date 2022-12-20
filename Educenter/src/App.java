// import org.apache.commons.lang3.StringUtils;
// import org.apache.poi.ss.usermodel.Cell;
// import org.apache.poi.ss.usermodel.Row;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

class Try {
    class Educenter {

        public static void main(String args[]) throws IOException {
            System.out.println("");
            System.out.println("Пожалуйста, авторизуйтесь!");
            chooseUsers();
        }

        // Выбор Аккаунта
        public static String chooseUsers() throws IOException {
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("Выберите вашу специальность:");
            System.out.println("1. Директор");
            System.out.println("2. Учитель");
            System.out.println("3. Ученик");
            do {
                System.out.print("Ваш выбор: ");
                String choose = sc.nextLine();
                System.out.println("");
                switch (choose) {
                    case "director":
                    case "Director":
                    case "1":
                        System.out.println("Добро пожаловать Директор");
                        System.out.println("Введите логин и пароль");
                        directorInputLgPw();
                        break;
                    case "teacher":
                    case "Teacher":
                    case "2":
                        System.out.println("Добро пожаловать Учитель");
                        System.out.println("Введите логин и пароль");
                        teacherInputLgPw();
                        break;
                    case "student":
                    case "Student":
                    case "3":
                        System.out.println("Добро пожаловать Студент");
                        System.out.println("Введите логин и пороль");
                        studentInputLgPw();
                        break;
                    default:
                        System.out.println("Кто вы?");
                        System.out.print("Желаете выйти[1] или повторить[0]? ");
                        int ex = sc.nextInt();
                        if (ex == 0){
                            chooseUsers();
                        }
                        else if(ex == 1){
                            System.exit(0);
                        }
                }
                break;
            } while (true);
            return "";
        }

        // Авторизация директора
        public static void directorInputLgPw() {
            Scanner sc = new Scanner(System.in);

            ArrayList<String> loginArrayList = new ArrayList<String>();
            ArrayList<String> passwordArrayList = new ArrayList<String>();
            loginArrayList.add("Director");
            passwordArrayList.add("user-director");

            do {
                System.out.print("Введите логин: ");
                String input_lg = sc.next();
                sc.nextLine();
                System.out.print("Введите пароль: ");
                String input_pw = sc.next();
                sc.nextLine();
                int indexArray = 0;
                boolean haveInArray = false;
                while (indexArray < loginArrayList.size()) {
                    if (input_lg.equals(loginArrayList.get(indexArray)) &&
                            input_pw.equals(passwordArrayList.get(indexArray))) {
                        haveInArray = true;
                        break;
                    } else {
                        haveInArray = false;
                    }
                    indexArray++;
                }
                if (haveInArray == true) {
                    System.out.println("Приветствую дорогой, Директор!");
                    directorActions();
                    break;
                } else {
                    System.out.println("Извините, но мы не нашли такой тип аккаунта, пожалуйста повторите.");
                }
            } while (true);
        }

        // Авторизация учителя
        public static void teacherInputLgPw() throws IOException {
            Scanner sc = new Scanner(System.in);

            ArrayList<String> loginArrayList = new ArrayList<String>();
            ArrayList<String> passwordArrayList = new ArrayList<String>();
            loginArrayList.add("Teacher");
            passwordArrayList.add("user-teacher");

            do {
                System.out.print("Введите логин: ");
                String input_lg = sc.next();
                sc.nextLine();
                System.out.print("Введите пароль: ");
                String input_pw = sc.next();
                sc.nextLine();
                int indexArray = 0;
                boolean haveInArray = false;
                while (indexArray < loginArrayList.size()) {
                    if (input_lg.equals(loginArrayList.get(indexArray)) &&
                            input_pw.equals(passwordArrayList.get(indexArray))) {
                        haveInArray = true;
                        break;
                    } else {
                        haveInArray = false;
                    }
                    indexArray++;
                }
                if (haveInArray == true) {
                    System.out.println("Приветствую дорогой, Учитель!");
                    teacherActions();
                    break;
                } else {
                    System.out.println("Извините, но мы не нашли такой тип аккаунта, пожалуйста повторите.");
                }
            } while (true);
        }

        // Авторизация студента
        public static void studentInputLgPw() throws IOException {
            Scanner sc = new Scanner(System.in);

            ArrayList<String> loginArrayList = new ArrayList<String>();
            ArrayList<String> passwordArrayList = new ArrayList<String>();
            loginArrayList.add("Student");

            passwordArrayList.add("user-student");

            do {
                System.out.print("Введите логин: ");
                String input_lg = sc.next();
                sc.nextLine();
                System.out.print("Введите пароль: ");
                String input_pw = sc.next();
                sc.nextLine();
                int indexArray = 0;
                boolean haveInArray = false;
                while (indexArray < loginArrayList.size()) {
                    if (input_lg.equals(loginArrayList.get(indexArray)) &&
                            input_pw.equals(passwordArrayList.get(indexArray))) {
                        haveInArray = true;
                        break;
                    } else {
                        haveInArray = false;
                    }
                    indexArray++;
                }
                if (haveInArray == true) {
                    System.out.println("Приветствую дорогой, Студент!");
                    studentActions();
                    break;
                } else {
                    System.out.println("Извините, но мы не нашли такой тип аккаунта, пожалуйста повторите.");
                }
            } while (true);
        }

        // АВТОРИЗАЦИЯ ГОТОВА
        // ПЫТАЛСЯ ЧТО-ТО СДЕЛАТЬ С ACTIONS НЕ ПОЛУЧИЛОСЬ ПОКА УСЛОВИЯ ПОМЕНЯЛ, ПЫТАЮСЬ РАЗОБРАТЬСЯ В КОДЕ

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Действия директора
       public static void directorActions() {
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("Пожалуйста наберите номер меню для работы с программой, если закончили, то наберите 8");
            System.out.println("Меню:");
            System.out.println("1. Показать список предметов");
            System.out.println("2. Показать количество студентов");
            System.out.println("3. Показать список учителей");
            System.out.println("4. Добавить учителя");
            System.out.println("5. Удалить учителя");
            System.out.println("6. Добавить студента");
            System.out.println("7. Удалить студента");
            System.out.println("8. Выход");
            System.out.println("");
            do {
                System.out.print("Ваш выбор: ");
                String chooseAction = sc.nextLine();
                System.out.println("");
                switch (chooseAction) {
                    case "action1":
                    case "Action1":
                    case "1":
                        System.out.println("СПИСОК ВСЕХ ПРЕДМЕТОВ");
                        action1();
                        directorActions();
                        break;
                    case "action2":
                    case "Action2":
                    case "2":
                        System.out.println("КОЛИЧЕСТВО СТУДЕНТОВ ДЛЯ КАЖДОГО ПРЕДМЕТА");
                        action2();
                        directorActions();
                        break;
                    case "action3":
                    case "Action3":
                    case "3":
                        System.out.println("СПИСОК УЧИТЕЛЕЙ");
                        action3();
                        directorActions();
                        break;
                    case "action4":
                    case "Action4":
                    case "4":
                        System.out.println("ДОБАВИТЬ УЧИТЕЛЯ");
                        action4();
                        directorActions();
                        break;
                    case "action5":
                    case "Action5":
                    case "5":
                        System.out.println("УДАЛИТЬ УЧИТЕЛЯ");
                        action5();
                        directorActions();
                        break;
                    case "action6":
                    case "Action6":
                    case "6":
                        System.out.println("ДОБАВИТЬ СТУДЕНТА");
                        // action6();
                        directorActions();
                        break;
                    case "action7":
                    case "Action7":
                    case "7":
                        System.out.println("УДАЛИТЬ СТУДЕНТА");
                        // action7();
                        directorActions();
                        break;
                    default:
                        System.out.println("Такого действия нет в программе!");
                        directorActions();
                        break;
                    case "n":
                        try {
                            chooseUsers();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    case "action8":
                    case "Action8":
                    case "8":
                        System.out.println("Программа завершена, мы будем рады вашему возвращению!");
                        System.out.println("");
                        break;
                }
                break;
            } while (true);
        }

        public static void action1() {
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Director\\Subjects.txt"))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        public static void action2() {
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Director\\Students.txt"))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        public static void action3() {
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Director\\Teachers.txt"))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        public static void action4() {
            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt"));
                HashMap<String, Integer> d = new HashMap<>();
                while (br.ready()) {
                    String line = br.readLine();
                    if (d.containsKey(line)) {
                        d.put(line, (int) (d.get(line) + 1));
                    } else {
                        d.put(line, 1);
                    }
                }
                System.out.println(d);
                String s = "dsd";
                int m = 100;
                for (String i : d.keySet()) {
                    if (d.get(i) < m) {
                        m = d.get(i);
                        s = i;
                    }
                }
                System.out.println("Минимальное количество бытовой техники:"+ s);
                br.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        public static void action5() {
            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt"));
                System.out.print("Доставленная бытовая техника ");
                int countLine = 0;
                while (br.ready()) {
                    System.out.print(br.readLine() + ", ");
                    countLine++;
                }
                System.out.println("Количество = " + countLine);
                BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt"));
                System.out.print("Заказанная бытовая техника ");
                int countline = 0;
                while (br1.ready()) {
                    System.out.print(br1.readLine() + ", ");
                    countline++;
                }
                System.out.println("Количество = " + countline);
                br1.close();
                br.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
        }

// //----------------------------------------------------------------------------------------------------------------------
// //         Действия учителя
        public static void teacherActions() throws IOException{
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("Пожалуйста наберите номер меню для работы с программой, если закончили, то наберите 8");
            System.out.println("Меню:");
            System.out.println("1. Показать список предметов");
            System.out.println("2. Показать список оценок");
            System.out.println("3. Показать количество студентов");
            System.out.println("4. Показать список экзаменов");
            System.out.println("5. Показать список зачетов");
            System.out.println("6. Показать максимальный балл");
            System.out.println("7. Показать мой минимальный балл");
            System.out.println("8. Выход");
            System.out.println("");
            do {
                System.out.print("Ваш выбор: ");
                String chooseAction = sc.nextLine();
                System.out.println("");
                switch (chooseAction) {
                    case "n":
                        try{
                            Educenter.chooseUsers();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    case "action1":
                    case "Action1":
                    case "1":
                        //СПИСОК ПРЕДМЕТОВ.
                        System.out.println("ПРЕДМЕТ");
                        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Teacher\\Subjects.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        teacherActions();
                        break;

                    case "action2":
                    case "Action2":
                    case "2":
                        //СПИСОК ОЦЕНОК.
                        System.out.println("ОЦЕНКИ");
                        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\Grades.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        teacherActions();
                        break;
                    
                    case "action3":
                    case "Action3":
                    case "3":
                        //--КОЛ--СТУДЕНТОВ--
                        System.out.println("КОЛ. СТУДЕНТОВ");
                        FileInputStream hwFile = null;
                        hwFile = new FileInputStream("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Teacher\\Students.txt");
                        try (InputStreamReader rus = new InputStreamReader(hwFile, "UTF-8");
                            BufferedReader br = new BufferedReader(rus)) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        teacherActions();
                        break;

                    case "action4":
                    case "Action4":
                    case "4":
                        //СПИСОК ЭКЗАМЕНОВ
                        System.out.println("СПИСОК ЭКЗАМЕНОВ");
                        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Teacher\\Exams.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        teacherActions();
                        break;

                    case "action5":
                    case "Action5":
                    case "5":
                        //СПИСОК ЗАЧЕТОВ
                        System.out.println("СПИСОК ЗАЧЁТОВ");
                        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Teacher\\Offsets.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        teacherActions();
                        break;

                    case "action6":
                    case "Action6":
                    case "6":
                        //МАКСИМАЛЬНЫЙ БАЛЛ
                        try {

                            File myFile = new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\Grades.txt");
                            FileReader fileReader = new FileReader(myFile);
                            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

                            int lineNumber = 0;

                            while (lineNumberReader.readLine() != null) {
                                lineNumber++;
                            }

                            System.out.println(lineNumber);

                            lineNumberReader.close();

                            String lineNumber1 = String.valueOf(lineNumber);
                            File newFile = new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\Test.txt");
                            FileWriter fileWriter = new FileWriter(newFile);
                            fileWriter.write(lineNumber1 + " Строк в файле: " + "C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\Grades.txt");
                            fileWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        teacherActions();
                        break;

                    case "action7":
                    case "Action7":
                    case "7":
                        int count = 0;

                        try {
                            // create a new file object
                            File file = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt");

                            // create an object of Scanner
                            // associated with the file
                            Scanner mn = new Scanner(file);

                            // read each line and
                            // count number of lines
                            while (mn.hasNextLine()) {
                                mn.nextLine();
                                count++;
                            }
                            System.out.println("Total Number of Delivered techniques: " + count);
                            System.out.println("Your Earnings: " + count * 2000);
                            // close scanner
                            mn.close();
                        } catch (Exception e) {
                            e.getStackTrace();
                        }

                        teacherActions();
                        break;

                    default:
                        System.out.println("Такого действия нет в программе!");
                        teacherActions();
                        break;

                    case "action8":
                    case "Action8":
                    case "8":
                        System.out.println("Программа завершена, мы будем рады вашему возвращению!");
                        System.out.println("");
                        break;

                }
                break;
            } while (true);

        }
        
// ----------------------------------------------------------------------------------------------------------------------

       // Действия cтудента
        public static void studentActions() throws IOException {
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("Пожалуйста наберите номер меню для работы с программой, если закончили, то наберите 8");
            System.out.println("Меню:");
            System.out.println("1. Показать список предметов");
            System.out.println("2. Показать список оценок");
            System.out.println("3. Показать список заданий");
            System.out.println("4. Показать список экзаменов");
            System.out.println("5. Показать список зачетов");
            System.out.println("6. Показать мой максимальный балл ");
            System.out.println("7. Показать мой минимальный балл");
            System.out.println("8. Выход");
            System.out.println("");
            do {
                System.out.print("Ваш выбор: ");
                String chooseAction = sc.nextLine();
                System.out.println("");
                switch (chooseAction) {
                    case "n":
                        try{
                            Educenter.chooseUsers();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    case "action1":
                    case "Action1":
                    case "1":
                        //СПИСОК ПРЕДМЕТОВ.
                        System.out.println("РАСПИСАНИЕ");
                        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\Subjects.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        studentActions();
                        break;

                    case "action2":
                    case "Action2":
                    case "2":
                        //СПИСОК ОЦЕНОК.
                        System.out.println("ОЦЕНКИ");
                        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\Grades.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        studentActions();
                        break;
                    
                    case "action3":
                    case "Action3":
                    case "3":
                        //СПИСОК ЗАДАНИЙ
                        System.out.println("ДОМАШНЕЕ ЗАДАНИЕ");
                        FileInputStream hwFile = null;
                        hwFile = new FileInputStream("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\HW.txt");
                        try (InputStreamReader rus = new InputStreamReader(hwFile, "UTF-8");
                            BufferedReader br = new BufferedReader(rus)) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        studentActions();
                        break;

                    case "action4":
                    case "Action4":
                    case "4":
                        //СПИСОК ЭКЗАМЕНОВ
                        System.out.println("СПИСОК ЭКЗАМЕНОВ");
                        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\Exams.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        studentActions();
                        break;

                    case "action5":
                    case "Action5":
                    case "5":
                        //СПИСОК ЗАЧЕТОВ
                        System.out.println("СПИСОК ЗАЧЁТОВ");
                        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\Offsets.txt"))) {
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        studentActions();
                        break;

                    case "action6":
                    case "Action6":
                    case "6":
                        //МАКСИМАЛЬНЫЙ БАЛЛ
                        try {

                            File myFile = new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\Grades.txt");
                            FileReader fileReader = new FileReader(myFile);
                            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

                            int lineNumber = 0;

                            while (lineNumberReader.readLine() != null) {
                                lineNumber++;
                            }

                            System.out.println(lineNumber);

                            lineNumberReader.close();

                            String lineNumber1 = String.valueOf(lineNumber);
                            File newFile = new File("C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\Test.txt");
                            FileWriter fileWriter = new FileWriter(newFile);
                            fileWriter.write(lineNumber1 + " Строк в файле: " + "C:\\Users\\User\\OneDrive\\Рабочий стол\\Универ\\OOP\\Project\\Student\\Grades.txt");
                            fileWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        studentActions();
                        break;

                    case "action7":
                    case "Action7":
                    case "7":
                        int count = 0;

                        try {
                            // create a new file object
                            File file = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt");

                            // create an object of Scanner
                            // associated with the file
                            Scanner mn = new Scanner(file);

                            // read each line and
                            // count number of lines
                            while (mn.hasNextLine()) {
                                mn.nextLine();
                                count++;
                            }
                            System.out.println("Total Number of Delivered techniques: " + count);
                            System.out.println("Your Earnings: " + count * 2000);
                            // close scanner
                            mn.close();
                        } catch (Exception e) {
                            e.getStackTrace();
                        }

                        studentActions();
                        break;

                    default:
                        System.out.println("Такого действия нет в программе!");
                        studentActions();
                        break;

                    case "action8":
                    case "Action8":
                    case "8":
                        System.out.println("Программа завершена, мы будем рады вашему возвращению!");
                        System.out.println("");
                        break;

                }
                break;
            } while (true);
        }
    }
}