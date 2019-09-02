package com.liuyq.utils.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by liuyq on 2019/9/2.
 */
public class ExcelUtil {

    public static List<Model> analay(String path) throws IOException, InvalidFormatException {

        InputStream in = new FileInputStream(new File(path));
        Workbook wb = WorkbookFactory.create(in);
        Sheet sheet = wb.getSheetAt(2);
        // 每页中的第一行为标题行，日期
        XSSFRow dateRow = (XSSFRow) sheet.getRow(0);
        //星期
        XSSFRow webRow = (XSSFRow) sheet.getRow(1);
        //白班
        XSSFRow blackRow = (XSSFRow) sheet.getRow(2);
        //晚班
        XSSFRow nightRow = (XSSFRow) sheet.getRow(3);


        List<Model> result = new ArrayList<>();

        String name = null;
        for (int i = 4; i < sheet.getLastRowNum(); i++) {
            XSSFRow row = (XSSFRow) sheet.getRow(i);

            if (row == null) break;
            if (row.getCell(0) == null) continue;

            if (!StringUtils.isEmpty(getCellValue(row.getCell(0)))) {
                name = getCellValue(row.getCell(0));//名称
            }


            for (int index = 1; index < dateRow.getPhysicalNumberOfCells(); index++) {
                Model model = null;
                //白班
                if (i % 2 == 0) {
                    model = Model.builder().name(name).date(getCellValue(dateRow.getCell(index)))
                            .num(new Double(row.getCell(index) == null || StringUtils.isEmpty(getCellValue(row.getCell(index))) ? "0" : getCellValue(row.getCell(index)))).isHoliday("节假".equals(getCellValue(blackRow.getCell(index))))
                            .isLegal("法假".equals(getCellValue(blackRow.getCell(index)))).isBlack(true).build();
                    //晚班
                } else {
                    model = Model.builder().name(name).date(getCellValue(dateRow.getCell(index)))
                            .num(new Double(row.getCell(index) == null || StringUtils.isEmpty(getCellValue(row.getCell(index))) ? "0" : getCellValue(row.getCell(index)))).isHoliday("节假".equals(getCellValue(nightRow.getCell(index))))
                            .isLegal("法假".equals(getCellValue(nightRow.getCell(index)))).isBlack(false).build();
                }

                result.add(model);

            }
        }
        return result;

    }

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        // 以下是判断数据的类型
        switch (cell.getCellType()) {
            case 0: // 数字
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
                } else {
                    cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
                }
                break;
            case 1: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case 4: // Boolean
                cellValue = cell.getBooleanCellValue() + "";
                break;
            case 2: // 公式
                cellValue = cell.getCellFormula() + "";
                break;
            case 3: // 空值
                cellValue = "";
                break;
            case 5: // 故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue.trim();
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        List<Model> models = analay("D:\\2019年6月份考勤导入 (自动保存的).xlsx");

        Map<String, List<Model>> modelMap =  models.stream().collect(Collectors.groupingBy(Model::getName));

        System.out.println(modelMap);

    }
}
