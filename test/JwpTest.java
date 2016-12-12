import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by YG-MAC on 2016. 12. 12..
 */
public class JwpTest {

    JwpCalculator cal;

    @Before
    public void setup(){
        cal = new JwpCalculator();
    }

    @Test
    public void add_0이_들어오면_null을_리턴() throws Exception {
        assertEquals(0, cal.add(null));

    }
    @Test
    public void add_1이_들어오면_1을_리턴() throws Exception {
        assertEquals(1, cal.add("1"));
    }
    @Test
    public void add_일반_구분자1로_더하기() throws Exception {
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    public void add_일반_구분자2로_더하기() throws Exception {
        assertEquals(3, cal.add("1:2"));
    }

    @Test
    public void add_복합_일반_구분자로_더하기() throws Exception {
        assertEquals(6, cal.add("1:2,3"));
    }

    @Test
    public void add_커스텀_테그_테스트() throws Exception {
        assertEquals(7, cal.add("//;\n4;3"));
    }

    @Test
    public void add_커스텀_테그와_복합_일반_구분자로_더하기() throws Exception {
        assertEquals(10, cal.add("//;\n4:3;2,1"));
    }

    @Test(expected = RuntimeException.class)
    public void add_음수가_들어오면_RuntimeException_발생() throws Exception {
        cal.add("-1");
    }
}
