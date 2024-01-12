import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
class Cat { // Объект котик
    String name; // имя котика
    double weight; // вес котика
    int fq; // частота мурлыканья котика
}
public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    static int[] sumResult(int[] random1, String path) throws Exception {
        int[] result = new int[2];
        result[0] = 0; // переменная, определяющая наличие или отсутствие ошибки
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
                result[1] = sum; // итоговая сумма трех файлов
            }

        }
        catch (FileNotFoundException e) {
            log.log(Level.INFO, "Файл поврежден", new Throwable()); // файл испорчен
            result[0] = 1; // переменная принимает значение, отличное от нуля - есть ошибка
        }
        catch (NumberFormatException e) {
            if (count == -1) {
                log.log(Level.INFO, "Строк в файле меньше трех", new Throwable()); // строк в файле меньше трех
                result[0] = 2;
            }
            else {
                log.log(Level.INFO, "Не числовой формат строки", new Throwable()); // значение не число
                result[0] = 3;
            }
        }

        return result;
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
            int[] res = sumResult(random1, path);
            System.out.println(res[0]);
            System.out.println(res[1]);
        }
        catch (Exception e) {
            System.out.println("ERROR " + e);
        }

    }
}