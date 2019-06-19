import com.vmly.model.JianDaoShiTouBuEnum;
import com.vmly.model.JudgeResult;
import com.vmly.model.Result;
import com.vmly.model.User;
import com.vmly.service.GameService;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;


public class GameServiceTest {


    GameService gameService = new GameService();

    @Test
    public void testWanttopay() {

        Result jay = gameService.wanttopay(new User("jay"));
        assertEquals(jay, Result.OK);

        Result tom = gameService.wanttopay(new User("tom"));
        assertEquals(tom, Result.OK);

        Result tomCopy = gameService.wanttopay(new User("tom"));
        Set<User> players = gameService.getPlayers();

        assertEquals(players.size(), 2);

    }



    /**
     * 1 jiandao
     * 2 shitou
     * 2 win
     */
    @Test
    public void testResult1(){//
        Result jay = gameService.wanttopay(new User("jay"));
        assertEquals(jay, Result.OK);

        Result tom = gameService.wanttopay(new User("tom"));
        assertEquals(tom, Result.OK);

        Result choiceJay = gameService.choice(JianDaoShiTouBuEnum.JIANDAO.ordinal(), new User("jay"));
        Result choiceTom = gameService.choice(JianDaoShiTouBuEnum.SHITOU.ordinal(), new User("tom"));


        JudgeResult result = gameService.judge();

        assertEquals(JudgeResult.Result.WIN,result.getResult());



        assertEquals("tom",result.getName());
    }





    /**
     * 1 jiandao
     * 3 bu
     * 1 win
     */
    @Test
    public void testResult2(){
        Result jay = gameService.wanttopay(new User("jay"));
        assertEquals(jay, Result.WAITING);

        Result tom = gameService.wanttopay(new User("tom"));
        assertEquals(tom, Result.OK);

        Result choiceJay = gameService.choice(JianDaoShiTouBuEnum.JIANDAO.ordinal(), new User("jay"));
        Result choiceTom = gameService.choice(JianDaoShiTouBuEnum.BU.ordinal(), new User("tom"));


        JudgeResult result = gameService.judge();

        assertEquals(JudgeResult.Result.WIN,result.getResult());

        assertEquals("jay",result.getName());
    }


    /**
     * 1 jiandao
     * 3 bu
     * 1 win
     */
    @Test
    public void testResult3(){//
        Result jay = gameService.wanttopay(new User("jay"));
        assertEquals(jay, Result.OK);

        Result tom = gameService.wanttopay(new User("tom"));
        assertEquals(tom, Result.OK);

        Result choiceJay = gameService.choice(JianDaoShiTouBuEnum.BU.ordinal(), new User("jay"));
        Result choiceTom = gameService.choice(JianDaoShiTouBuEnum.JIANDAO.ordinal(), new User("tom"));


        JudgeResult result = gameService.judge();

        assertEquals(JudgeResult.Result.WIN,result.getResult());
        assertEquals("tom",result.getName());
    }


    /**
     * 2 shitou
     * 3 bu
     */
    @Test
    public void testResult4(){//
        Result jay = gameService.wanttopay(new User("jay"));
        assertEquals(jay, Result.OK);

        Result tom = gameService.wanttopay(new User("tom"));
        assertEquals(tom, Result.OK);

        Result choiceTom = gameService.choice(JianDaoShiTouBuEnum.BU.ordinal(), new User("tom"));
        Result choiceJay = gameService.choice(JianDaoShiTouBuEnum.SHITOU.ordinal(), new User("jay"));


        JudgeResult result = gameService.judge();

        assertEquals(JudgeResult.Result.WIN,result.getResult());

        assertEquals("tom",result.getName());
    }


    /**
     * 2 shitou
     * 3 bu
     */
    @Test
    public void testResult5(){

        Result jay = gameService.wanttopay(new User("jay"));
        assertEquals(jay, Result.OK);

        Result tom = gameService.wanttopay(new User("tom"));
        assertEquals(tom, Result.OK);

        Result choiceTom = gameService.choice(JianDaoShiTouBuEnum.SHITOU.ordinal(), new User("tom"));
        Result choiceJay = gameService.choice(JianDaoShiTouBuEnum.BU.ordinal(), new User("jay"));

        JudgeResult result = gameService.judge();

        //jaywin
        assertEquals("jay",result.getName());
        assertEquals(JudgeResult.Result.WIN,result.getResult());
    }



}
