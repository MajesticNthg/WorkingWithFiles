import java.io.*;
import java.util.ArrayList;
import java.util.Random;
class Cat { // Объект котик
    String name; // имя котика
    double weight; // вес котика
    int fq; // частота мурлыканья котика
}
public class Main {
    static int sumResult(int[] random1, String path) throws Exception {
        int sum = 0; // сумма всех чисел из трех файлов
        int count = 0; // счетчик строк в файле

        try {
            for(int z = 0; z < random1.length; z++) {
                File my_fil1 = new File(path + random1[z] + ".txt");
                BufferedReader br1 = new BufferedReader(new FileReader(my_fil1));
                String st1 = br1.readLine();
                while (count < 3) {
                    if (st1 == null) {
                        count = -1;
                    }
                    sum += Integer.valueOf(st1);
                    st1 = br1.readLine();
                    count++;
                }
                count = 0;
                br1.close(); // сумма чисел из первого файла
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Файл поврежден " + e); // сообщение об испорченном файле
        }
        catch (NumberFormatException e) {
            if (count == -1) {
                System.out.println("Строк в файле меньше трех  " + e); // строк в файле меньше трех
            }
            else
                System.out.println("Не числовой формат " + e); // значение не число
        }

        return sum;
    }
    public static void main(String[] args) {
        try {
            Random rand = new Random();

            String path = "F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\14 Работа с файлами\\";

            for (int n = 1; n < 11; n++) {
                File my_fil = new File(path + n + ".txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(my_fil));
                for (int x = n; x < n + 3; x++) {
                    String s = Integer.toString(rand.nextInt(10) + 1);
                    bw.write(s);
                    bw.newLine();
                }
                bw.close();
            }

            int[] random1 = new int[] {1, 2, 3};
            int random2 = rand.nextInt(10) + 1;
            System.out.println(sumResult(random1, "F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\14 Работа с файлами\\"));




        }
        catch (Exception e) {
            System.out.println("ERROR " + e);
        }

    }
}