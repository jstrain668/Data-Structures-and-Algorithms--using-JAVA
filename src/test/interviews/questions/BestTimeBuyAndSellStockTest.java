package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeBuyAndSellStockTest {

    BestTimeBuyAndSellStock ss;

    @BeforeEach
    void init(){
        ss = new BestTimeBuyAndSellStock();
    }

    @Test
    void simpleMaxProfit() {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};

        assertEquals(7,ss.simpleMaxProfit(prices1));
        assertEquals(4,ss.simpleMaxProfit(prices2));
        assertEquals(0,ss.simpleMaxProfit(prices3));
    }
}