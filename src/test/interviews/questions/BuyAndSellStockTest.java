package interviews.questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyAndSellStockTest {

    BuyAndSellStock bst;
    int[] prices1;
    int[] prices2;

    @BeforeEach
    void init() {
        bst = new BuyAndSellStock();
        prices1 = new int[] {7,1,5,3,6,4};
        prices2 = new int[] {7,6,4,3,1};
    }

    @Test
    void maxProfit() {
        assertEquals(5,bst.maxProfit(prices1));
        assertEquals(0,bst.maxProfit(prices2));
    }

    @Test
    void bfMaxProfit() {
        assertEquals(5,bst.bfMaxProfit(prices1));
        assertEquals(0,bst.bfMaxProfit(prices2));
    }
}