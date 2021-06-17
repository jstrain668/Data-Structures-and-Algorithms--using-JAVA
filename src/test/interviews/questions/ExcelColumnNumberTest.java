package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExcelColumnNumberTest {

    ExcelColumnNumber ecn;

    @BeforeEach
    public void init(){
        ecn = new ExcelColumnNumber();
    }

    @Test
    void convertExcelColumnToNumber() {

        assertEquals(1, ecn.convertExcelColumnToNumber("A"));
        assertEquals(27, ecn.convertExcelColumnToNumber("AA"));
        assertEquals(701, ecn.convertExcelColumnToNumber("ZY"));
        assertEquals(2147483647, ecn.convertExcelColumnToNumber("FXSHRXW"));
    }
}