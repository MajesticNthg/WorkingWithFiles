import org.junit.Test;
import java.io.*;
import java.io.IOException;
import java.util.Random;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;


import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    public void testZero() throws Exception { // в файле записано три нуля

        for (int n = 1; n < 11; n++) {
            File my_fil = new File("F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\14 Работа с файлами\\" + n + ".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(my_fil));
            for (int x = n; x < n + 3; x++) {
                String s = Integer.toString(0);
                bw.write(s);
                bw.newLine();
            }
            bw.close();

            BufferedReader br1 = new BufferedReader(new FileReader(my_fil));
            String st1 = br1.readLine();
            while (st1 != null) {
                assertEquals(Integer.valueOf(st1), 0);
                st1 = br1.readLine();
            }
            br1.close();
        }
    }

    @org.junit.jupiter.api.Test
    public void testZeroIteration() throws Exception {
        for (int n = 1; n < 11; n++) {
            File my_fil = new File("F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\14 Работа с файлами\\" + n + ".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(my_fil));
            for (int x = n; x < n; x++) {
                String s = Integer.toString(0);
                bw.write(s);
                bw.newLine();
            }
            bw.close();


            BufferedReader br1 = new BufferedReader(new FileReader(my_fil));
            String st1 = br1.readLine();
            while (st1 != null) {
                st1 = br1.readLine();
            }
            assertEquals(Integer.valueOf(st1), 0);
            br1.close();
        }

    }
}