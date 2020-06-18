package xin.qust.kg.utils;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.util.List;

public class WorkUtil {

    public static void readWord(String fileName) throws Exception{
        FileInputStream inputStream = new FileInputStream(fileName);
        XWPFDocument xwpfDocument = new XWPFDocument(inputStream);
        List<XWPFTable> tables = xwpfDocument.getTables();
        for(XWPFTable table: tables) {
            List<XWPFTableRow> rows = table.getRows();
            for (XWPFTableRow row: rows) {
                List<XWPFTableCell> cells = row.getTableCells();
                for (XWPFTableCell cell: cells) {
                    List<XWPFParagraph> paragraphs = cell.getParagraphs();
                    for (XWPFParagraph paragraph: paragraphs) {
                        System.out.print("\t" + paragraph.getText());
                    }
                }
                System.out.println("");
            }
        }
    }
}
