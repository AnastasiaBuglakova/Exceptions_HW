import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Задание 1 
// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
public class exceptionsHW2 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите дробное число");
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println(sc.nextFloat());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неправильный тип данных");
            }
        }
    }
}


// // Задание 2
// Если необходимо, исправьте данный код (https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
// public class exceptionsHW2 {
//     public static void main (String[]args){
//         try {
//             int d = 0;
//             int[] intArray = new int[d];
//             double catchedRes1 = intArray[8] / d;
//             System.out.println("catchedRes1 = " + catchedRes1);
//         } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
//             System.out.println("Catching exception: " + e);
//         } catch (Throwable e) {
//             System.out.println("You've got following problems: " + e);
//         }
//     }
// }


// Задание 3
//  Если необходимо, исправьте данный код (https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
// public class exceptionsHW2 {
//     public static void main (String[]args) throws Exception {
//         try {
//             int a = 90;
//             int b = 3;
//             System.out.println(a / b);
//             printSum(23, 234);
//             int[] abc = {1, 2};
//             abc[3] = 9;
//         } catch (IndexOutOfBoundsException ex) {
//             System.out.println("Массив выходит за пределы своего размера!");
//         } catch (NullPointerException ex) {
//             System.out.println("Указатель не может указывать на null!");
//         } catch (Throwable ex) {
//             System.out.println("Что-то пошло не так...");
//         }
//     }

//     public static void printSum (Integer a, Integer b) throws FileNotFoundException {
//         System.out.println(a + b);
//     }
// }




// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

// public class exceptionsHW2 {
//     public static void main (String[]args) throws Exception {
//         System.out.println("Введите сообщение");
//             Scanner sc = new Scanner(System.in);
    
//             String insert = sc.nextLine();
//             if (insert.equals("")){
//                 try {
//                     throw new Exception();
//                 } catch (Exception e) {
//                     System.out.println("пустая строка недопустима");;
//                 }
//             } else {
//                 System.out.println(insert);
//             }
//         }
//     }
