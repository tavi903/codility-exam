import com.tavi903.robot.Solution;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void example1() {
        String[] R = {"...X..", "....XX", "..X..."};
        Solution mySolution = new Solution();

        Assert.assertEquals(6, mySolution.solution(R));
    }

    @Test
    public void example2() {
        String[] R = {"...X", "....", "..X.", "...."};
        Solution mySolution = new Solution();

        Assert.assertEquals(6, mySolution.solution(R));
    }

}