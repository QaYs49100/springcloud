import java.time.ZonedDateTime;

public class Test {

    public static void main(String[] args) {

        ZonedDateTime now = ZonedDateTime.now(); //获取时区时间
        System.out.println(now);//2021-03-09T21:55:01.909+08:00[Asia/Shanghai]
    }

}

