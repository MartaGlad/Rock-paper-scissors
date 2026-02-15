import com.kodilla.rps.Result;
import com.kodilla.rps.ResultCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultCounterTestSuite {

    @Test
    void testDraw() {

        assertEquals(Result.DRAW, ResultCounter.computeResult(0, 0));
        assertEquals(Result.DRAW, ResultCounter.computeResult(1, 1));
        assertEquals(Result.DRAW, ResultCounter.computeResult(2, 2));
    }


    @Test
    void testComputerWin() {

        assertEquals(Result.COMPUTER_WIN, ResultCounter.computeResult(1, 2));
        assertEquals(Result.COMPUTER_WIN, ResultCounter.computeResult(2, 3));
        assertEquals(Result.COMPUTER_WIN, ResultCounter.computeResult(3, 1));
    }


    @Test
    void testUserWin() {

        assertEquals(Result.USER_WIN, ResultCounter.computeResult(2, 1));
        assertEquals(Result.USER_WIN, ResultCounter.computeResult(3, 2));
        assertEquals(Result.USER_WIN, ResultCounter.computeResult(1, 3));
    }
}

