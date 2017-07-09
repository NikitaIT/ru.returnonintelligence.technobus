package springboot.ParserXLS;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelParser {


    private static String fileName = "TimeTable.xls";

    private static int[] hour_minut = new int[2];

    // коллекции хранящие расписаний движения Метро-БизнесЦентра\ БЦ - Метро
    private static ArrayList<int[]> Metro_BC;
    private static ArrayList<int[]> BC_Metro;


    // метод парсящий день№ index из filename.xls,
    public static void parseDay(int index) {


        Metro_BC = new ArrayList<>();
        BC_Metro = new ArrayList<>();


        //инициализируем потоки
        String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(index);
        Iterator<Row> it = sheet.iterator();

        // пропуск первых 2-х строк с подсказками
        it.next();
        it.next();

        //проходим по всем строкам
        while (it.hasNext()) {
            int i = 0;
            int j = 0;
            Row row = it.next();

            Iterator<Cell> cells = row.iterator();

            // проход по яцейкам в строке
            while (cells.hasNext()) {

                Cell cell = cells.next();
                int temp_result = (int) cell.getNumericCellValue();

                // распределение времени по коллекциям
                hour_minut[j] = temp_result;

                if (j == 0) {
                    j++;
                } else {
                    if (i == 0) {
                        Metro_BC.add(hour_minut.clone());
                        i++;
                    } else {
                        BC_Metro.add((hour_minut.clone()));
                    }
                    j = 0;
                }
            }
        }
    }

    public static ArrayList<int[]> getMetro_BC() {
        return (ArrayList<int[]>) Metro_BC.clone();
    }

    public static ArrayList<int[]> getBC_Metro() {
        return (ArrayList<int[]>) BC_Metro.clone();
    }
}


