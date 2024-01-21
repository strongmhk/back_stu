package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j //Logger를 선언하지 않고도 사용가능
@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);
        log.info(" info log = " + name); // 프로젝트에 설정해둔 로그 레벨에 포함되지않아 출력이 되지 않는다면, 연산을 일어나 서버에서 리소스를 할당해 가지고 있지만 출력은 되지않아 리소스의 낭비가 발생함

        log.trace(" trace log = {} " ,name);
        log.debug(" debug log = {} " ,name);
        log.info(" info log = {} " ,name);
        log.warn(" warn log = {} " ,name);
        log.error(" error log = {} " ,name);

        return "ok";
    }




}
