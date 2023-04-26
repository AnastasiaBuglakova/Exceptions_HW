// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество дата рождения номер телефона пол
// Форматы данных:
// фамилия, имя, отчество - строки
// дата_рождения - строка формата dd.mm.yyyy
// номер_телефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.
// Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и 
// показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
// Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, 
// что именно неверно. Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку 
// должны записаться полученные данные, вида
// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// Не забудьте закрыть соединение с файлом.
// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
package Exceptions_HW4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExceptionsHW4 {
    public static void main(String[] args) {
        String[] message = {"Пожалуйста, введите ФИО через пробел(пример: Петров Петр Петрович): ",
            "Пожалуйста, введите дату рождения в формате dd.mm.yyyy через точку: ", 
            "Пожалуйста, введите номер_телефона - целое беззнаковое число (пример: 89283214551): ",
            "Пожалуйста, введите пол - символ латиницей f или m"};
        boolean exit = false;
        try (Scanner iSc = new Scanner(System.in)) {
            while(!exit){
                String lineForSaving = null;
                String surname = null;
                while (lineForSaving == null){
                    System.out.println(message[0]);
                    String surname_name_patronymic = iSc.nextLine();
                    if (checkedName(surname_name_patronymic)) lineForSaving = surname_name_patronymic;
                    surname = surname_name_patronymic.split(" ")[0];
                }
                String dateOfBirth = null;
                while (dateOfBirth == null){
                    System.out.println(message[1]);
                    dateOfBirth = iSc.nextLine();
                    // System.out.println(dateOfBirth);
                    // String[] date = dateOfBirth.split("-");
                    // System.out.println(Arrays.toString(dateOfBirth.split("-")));
                    if (checkedDateOfBirth(dateOfBirth)) lineForSaving += " " + dateOfBirth;
                    else dateOfBirth = null;
                }

                String phoneNumber = null;
                while (phoneNumber == null){
                    System.out.println(message[2]);
                    phoneNumber = iSc.nextLine();
                    if (checkedPhoneNumb(phoneNumber)) lineForSaving += " " + phoneNumber;
                    else phoneNumber = null;
                }
                String sex = null;
                while (sex == null){
                    System.out.println(message[3]);
                    sex = iSc.nextLine();
                    if (checkedSex(sex)) lineForSaving +=  " " + sex.toLowerCase();
                    else phoneNumber = null;
                }


                try(FileWriter writer = new FileWriter("Exceptions_HW4/" + surname + ".txt", true))
                {
                    writer.write(lineForSaving + "\n");
                    writer.flush();
                } catch(IOException e){
                    System.out.println("При записи файла возникло исключение: ");
                    System.out.println(e.getMessage());
                }

                System.out.println("Для остановки работы приложения (exit) введите, пожалуйста, 'e'.\nДля продолжения работы - любой символ или ввод.");
                String strExit = iSc.nextLine();
                if (strExit.trim().equals("e") | strExit.trim().equals("E")) exit = true;

            }
        }
    }

    

   







    private static Boolean checkedName(String surname_name_patronymic) {

        String[] name = surname_name_patronymic.trim().replace("  ", " ").split(" ");
        if (name.length <= 1){
            System.out.println("Должны быть указаны как минимум фамилия и имя");
            return false;
        }
        return true;
    } 
    
    private static Boolean checkedDateOfBirth(String dateOfBirth) {
        
        String[] date = dateOfBirth.split("\\.");
        if (date.length != 3) {
            System.out.println(date.length);
            System.out.println("Введите дату рождения, состоящую из 3х цифр, разделенных точкой");
            return false;
        }
        try {
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            if (day <= 0 && day > 32 && month <= 0 && month >12 && year > 2024 && year <1910) {
                System.out.println("Дней в месяце должно быть не более 31, месяцев не более 12, год рождения не ранее 1910");
                return false;
            }
            LocalDate currentDate = LocalDate.now();
            LocalDate date1 = LocalDate.of(year, month, day);
            if (date1.isAfter(currentDate)) {
                System.out.println("Дата рождения должна быть должна быть ранее тукещей");
                return false;
        }
        } catch (DateTimeException e) {
            System.out.println("Такой даты не существует");
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Введите, пожалуйста, корректную дату без использования символов в числовом формате написания через точку(dd.mm.yyyy)");
            return false;
        }
        return true;
    }


    private static boolean checkedPhoneNumb(String phoneNumber) {

        if (phoneNumber.trim().length() != 10) {
            System.out.println("Длина номера телефона должна быть 10 символов");
            return false;
        }
        if (!phoneNumber.chars().allMatch(Character::isDigit)){
            System.out.println("В номере телефона не должно быть символов");
            return false;
        }
        return true;
    }



    private static boolean checkedSex(String sex) {
        if (sex.toLowerCase().trim().equals("f") | sex.toLowerCase().trim().equals("m")) return true;
        else{
            System.out.println("Введите, пожалуйста, один символ f или m");
            return false;
        }
    }


        
}



