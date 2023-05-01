package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV2;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.excute(new StrategyLogic1());
        context.excute(new StrategyLogic2());
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.excute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직1실행");
            }
        });
        context.excute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직2실행");
            }
        });
    }

    /**
     전략 패턴 익명 내부 클래스 2 - 람다
     *
      */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.excute(() -> log.info("비즈니스로직1실행!"));
        context.excute(() -> log.info("비즈니스로직2실행!"));
    }
}
