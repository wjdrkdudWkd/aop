package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId){
        TraceStatus status = null;
        try {
            status = this.trace.beginSync(traceId, "OrderServiceV1.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            this.trace.end(status);
        } catch (Exception e){
            this.trace.exception(status, e);
            throw e;
        }
    }
}
