import com.annotation.Time;

/**
 * Created by Gene on 2017/11/12.
 */
public class TestSpringContainer {
    @Time
    public void testAnnotation(){
        System.out.println("---in testAnnotation");
    }

    public static void main(String[] args) {
        TestSpringContainer test = new TestSpringContainer();
        test.testAnnotation();
    }
}
