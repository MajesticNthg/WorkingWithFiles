import java.io.*;
import java.util.ArrayList;
import java.util.Random;
class Cat { // Объект котик
        String name; // имя котика
        double weight; // вес котика
        int fq; // частота мурлыканья котика
}
public class Main {
    static int sumResult(int random1, int random2) throws Exception {
            int sum = 0; // сумма всех чисел из двух файлов

        try {
            File my_fil1 = new File("F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\14 Работа с файлами\\" + random1 + ".txt");
            BufferedReader br1 = new BufferedReader(new FileReader(my_fil1));
            String st1 = br1.readLine();
            while (st1 != null) {
                sum += Integer.valueOf(st1);
                st1 = br1.readLine();
            }
            br1.close(); // сумма чисел из первого файла

            File my_fil2 = new File("F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\14 Работа с файлами\\" + random2 + ".txt");
            BufferedReader br2 = new BufferedReader(new FileReader(my_fil2));
            String st2 = br2.readLine();
            while (st2 != null) {
                sum += Integer.valueOf(st2);
                st2 = br2.readLine();
            }
            br2.close(); // сумма чисел из второго файла
        }
        catch (NumberFormatException e) {
            System.out.println("Файл поврежден " + e); // сообщение об ошибке в файле
        }
            return sum;
    }
    public static void main(String[] args) {
        try {
            Random rand = new Random();

            for (int n = 1; n < 11; n++) {
                 File my_fil = new File("F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\14 Работа с файлами\\" + n + ".txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(my_fil));
                for (int x = n; x < n + 3; x++) {
                    String s = Integer.toString(rand.nextInt(10) + 1);
                    bw.write(s);
                    bw.newLine();
                }
                bw.close();
            }

            int random1 = 1;
            int random2 = rand.nextInt(10) + 1;
            System.out.println(sumResult(random1, random2)); // сумма содержания двух случайных файлов


            File my_filCat = new File("F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\14 Работа с файлами\\Cat.txt");
            BufferedWriter bwCat = new BufferedWriter(new FileWriter(my_filCat));
            String catArgs = "Барсик 5.0 75";

            String[] words = catArgs.split(" ");
            for (String word : words) {
                bwCat.write(word);
                bwCat.newLine();
            }
            bwCat.close(); // строка с характеристиками котика поделена на строки

            Cat my_cat1;
            my_cat1 = new Cat();
            File my_filMyCat = new File("F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\14 Работа с файлами\\Cat.txt");
            BufferedReader brMyCat = new BufferedReader(new FileReader(my_filMyCat));
            String MyCat = brMyCat.readLine();
            my_cat1.name = MyCat;
            MyCat = brMyCat.readLine();
            double weight = Double.valueOf(MyCat);
            my_cat1.weight = weight;
            MyCat = brMyCat.readLine();
            int fq = Integer.valueOf(MyCat);
            my_cat1.fq = fq;
            brMyCat.close(); // построение объекта "Первый котик"


            File my_filCat2 = new File("F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\14 Работа с файлами\\Cat2.txt");
            BufferedWriter bw2Cat = new BufferedWriter(new FileWriter(my_filCat2));
            String cat2Args = "Василий 6.0 75";

            String[] words2 = cat2Args.split(" ");
            for (String word2 : words2) {
                bw2Cat.write(word2);
                bw2Cat.newLine();
            }
            bw2Cat.close(); // строка с характеристиками котика поделена на строки

            Cat my_cat2;
            my_cat2 = new Cat();
            File my_filMyCat2 = new File("F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\14 Работа с файлами\\Cat2.txt");
            BufferedReader brMyCat2 = new BufferedReader(new FileReader(my_filMyCat2));
            String MyCat2 = brMyCat2.readLine();
            my_cat2.name = MyCat2;
            MyCat2 = brMyCat2.readLine();
            double weight2 = Double.valueOf(MyCat2);
            my_cat2.weight = weight;
            MyCat2 = brMyCat2.readLine();
            int fq2 = Integer.valueOf(MyCat2);
            my_cat2.fq = fq;
            brMyCat2.close(); // построение объекта "Второй котик"

            ArrayList arrayList = new ArrayList();
            arrayList.add(my_cat1); // Добавление первого котика в список объектов
            arrayList.add(my_cat2); // Добавление второго котика в список объектов

        }
        catch (Exception e) {
            System.out.println("ERROR " + e);
        }

    }
}