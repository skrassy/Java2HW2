public class Main {

    public static void main(String[] args) {
        String[][] arr = {
                {"12", "10", "6", "3"},
                {"12", "10", "6", "3"},
                {"12", "10", "6", "3"},
                {"12", "10", "6", "3"}
        };
        String[][] arr2 = {
                {"12", "10", "6", "3"},
                {"12", "10", "6", "3"},
                {"12", "10", "6", "3"},
        };
        String[][] arr3 = {
                {"12", "10", "6", "3"},
                {"12", "Это не число", "6", "3"},
                {"12", "10", "6", "3"},
                {"12", "10", "6", "3"}
        };

        try {
            checkArraySize4x4(arr);
            int result = transformationArrayStringToInt(arr);
            System.out.println("Сумма всех элементов массива равна " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkArraySize4x4(arr2);
            int result = transformationArrayStringToInt(arr2);
            System.out.println("Сумма всех элементов массива равна " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkArraySize4x4(arr3);
            int result = transformationArrayStringToInt(arr3);
            System.out.println("Сумма всех элементов массива равна " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkArraySize4x4(String[][] arr) throws MyArraySizeException {
        if ((arr.length != 4) || (arr[0].length != 4))
            throw new MyArraySizeException("Введен массив неверного размера");
    }

    public static int transformationArrayStringToInt(String[][] arr) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                   int element = Integer.parseInt(arr[i][j]);
                   sum = sum + element;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Элемент массива [" + i + "][" + j + "] не может быть преобразован в число!");
                }
            }
        }
        return sum;
    }
}
