package herokuapp_smoketest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        S1_Post.class,
        S3_Put.class,
        S4_Get.class,
        S5_Patch.class,
        S6_Delete.class,
        S7_Get_Negative.class
})

public class Runner {

}