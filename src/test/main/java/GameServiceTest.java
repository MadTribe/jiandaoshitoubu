import com.vmly.model.JudgeResult;
import com.vmly.model.Result;
import com.vmly.service.GameService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class GameServiceTest {


    GameService gameService = new GameService();

    @Test
    public void testWanttopay() {
        Result jay = gameService.wanttopay("jay");
        assertEquals(jay.getMsg(), "ok");

        Result tom = gameService.wanttopay("tom");
        assertEquals(tom.getMsg(), "ok");

        Result tomCopy = gameService.wanttopay("tom");
        Set<String> players = gameService.getPlayers();

        assertEquals(players.size(), 2);
        assertTrue(players.contains("tom"));
        assertTrue(players.contains("jay"));
    }



    /**
     * 1 jiandao
     * 2 shitou
     * 2 win
     */
    @Test
    public void testResult1(){//
        Result jay = gameService.wanttopay("jay");
        assertEquals(jay.getMsg(), "ok");

        Result tom = gameService.wanttopay("tom");
        assertEquals(jay.getMsg(), "ok");

        Result choiceJay = gameService.choice(1, "jay");
        Result choiceTom = gameService.choice(2, "tom");


        JudgeResult result = gameService.judge("jay");

        assertEquals(JudgeResult.Result.SUCCESS,result.getResult());



        assertEquals("tom",result.getUsername());
    }





    /**
     * 1 jiandao
     * 3 bu
     * 1 win
     */
    @Test
    public void testResult2(){//
        Result jay = gameService.wanttopay("jay");
        assertEquals(jay.getMsg(), "ok");

        Result tom = gameService.wanttopay("tom");
        assertEquals(jay.getMsg(), "ok");

        Result choiceJay = gameService.choice(1, "jay");
        Result choiceTom = gameService.choice(3, "tom");


        JudgeResult result = gameService.judge("jay");

        assertEquals(JudgeResult.Result.SUCCESS,result.getResult());

        assertEquals("jay",result.getUsername());
    }


    /**
     * 1 jiandao
     * 3 bu
     * 1 win
     */
    @Test
    public void testResult3(){//
        Result jay = gameService.wanttopay("jay");
        assertEquals(jay.getMsg(), "ok");

        Result tom = gameService.wanttopay("tom");
        assertEquals(jay.getMsg(), "ok");

        Result choiceJay = gameService.choice(3, "jay");
        Result choiceTom = gameService.choice(1, "tom");


        JudgeResult result = gameService.judge("jay");

        assertEquals(JudgeResult.Result.SUCCESS,result.getResult());
        assertEquals("tom",result.getResult());
    }


    /**
     * 2 shitou
     * 3 bu
     */
    @Test
    public void testResult4(){//
        Result jay = gameService.wanttopay("jay");
        assertEquals(jay.getMsg(), "ok");

        Result tom = gameService.wanttopay("tom");
        assertEquals(jay.getMsg(), "ok");

        Result choiceTom = gameService.choice(3, "tom");
        Result choiceJay = gameService.choice(2, "jay");


        JudgeResult result = gameService.judge("jay");

        assertEquals(JudgeResult.Result.SUCCESS,result.getResult());

        assertEquals("tom",result.getUsername());
    }


    /**
     * 2 shitou
     * 3 bu
     */
    @Test
    public void testResult5(){//
        Result jay = gameService.wanttopay("jay");
        assertEquals(jay.getMsg(), "ok");

        Result tom = gameService.wanttopay("tom");
        assertEquals(jay.getMsg(), "ok");

        Result choiceTom = gameService.choice(2, "tom");
        Result choiceJay = gameService.choice(3, "jay");

        JudgeResult result = gameService.judge("jay");

        //jaywin
        assertEquals("jay",result.getUsername());
        assertEquals(JudgeResult.Result.SUCCESS,result.getResult());
    }















}
