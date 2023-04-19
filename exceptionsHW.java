import java.util.Arrays;

// 1 Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
// 2 Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
// Возможно, я не поняла вопрос, тут реализовано 4 метода и 4 вида исключений можно реализовать:
// 1 java.lang.ArithmeticException: / by zero
// 2 java.lang.NullPointerException
// 3 java.lang.NumberFormatException.forInputString
// 4 java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
public class exceptionsHW {
    public static void main(String[] args) {
        // divZero();
        // System.out.println(nullStr());
        // System.out.println(parser());
        System.out.println(castInt());

    }
    static void divZero(){
        System.out.println(3/(5-5));
    }
    public static int nullStr(){
        String str1 = null;
        return str1.length();
    }
    public static int parser(){
        String str2 = "к567";
        return Integer.parseInt(str2);
    }
    public static String castInt() {
        Object x = 77;
        return (String)x;
    }
}

// 3 Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
// каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны,
// необходимо как-то оповестить пользователя.
// public class exceptionsHW {
//     public static void main(String[] args) {
//         System.out.println(Arrays.toString(sumOfArrays(new int[] {1,22,55}, new int[] {4,29,8,9})));
//     }

//     public static int[] sumOfArrays(int[] arr1, int[] arr2){
//         int[] newArr = new int [Math.max(arr1.length, arr2.length)];
//         try {
//             for (int index = 0; index < newArr.length; index++) {
//                 newArr[index] = arr1[index] + arr2[index];
//                 System.out.println(newArr[index]);
//             }
//             return newArr;
//         } catch (RuntimeException e) {
//             System.out.println("Разные длины массивов: " + arr1.length + " и " + arr2.length);
//             return new int[] {0,0,0};
//         }
//     }
// }
// *4 Реализуйте метод, принимающий в качестве аргументов два целочисленных
// массива, и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той
// же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода
// единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.

// public class exceptionsHW {
//         public static void main(String[] args) {
//             System.out.println(Arrays.toString(sumOfArrays(new int[] {1,22,55}, new int[] {4,29,9, 7})));
//         }
    
//         public static float[] sumOfArrays(int[] arr1, int[] arr2){
//             float[] newArr = new float [Math.max(arr1.length, arr2.length)];
//             try {
//                 for (int index = 0; index < newArr.length; index++) {
//                     newArr[index] = ((float) arr1[index]) / ((float) arr2[index]);
//                     System.out.println(newArr[index]);
//                 }
//                 return newArr;
//             } catch (RuntimeException e) {
//                 System.out.println("Разные длины массивов: " + arr1.length + " и " + arr2.length);
//                 return new float[] {0};
//             }
//         }
//     }