package org.ditto.emoji;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerInterceptor;
import io.grpc.stub.StreamObserver;
import org.ditto.grpc.emoji.EmojiGrpc;
import org.ditto.grpc.emoji.EmojiOuterClass;
import org.ditto.grpc.emoji.GreeterGrpc;
import org.ditto.grpc.emoji.GreeterOuterClass;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationSpringBoot.class, TestConfig.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmojiGrpcServiceTests {


    private ManagedChannel channel;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    @Qualifier("globalInterceptor")
    private ServerInterceptor globalInterceptor;


    @Before
    public void setup() {
        channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext(true)
                .build();
    }

    @After
    public void tearDown() {
        channel.shutdown();
    }

    @Test
    public void interceptorsTest() throws ExecutionException, InterruptedException {

        EmojiGrpc.newStub(channel)
                .listEmojis(EmojiOuterClass.EmojiRequest.newBuilder().setPageSize(10).build(),
                        new StreamObserver<EmojiOuterClass.EmojiResponse>() {
                            @Override
                            public void onNext(EmojiOuterClass.EmojiResponse value) {

                            }

                            @Override
                            public void onError(Throwable t) {

                            }

                            @Override
                            public void onCompleted() {

                            }
                        });

        EmojiGrpc.newBlockingStub(channel)
                .listEmojis(EmojiOuterClass.EmojiRequest.newBuilder().setPageSize(10).build())
                .forEachRemaining(new Consumer<EmojiOuterClass.EmojiResponse>() {
                    @Override
                    public void accept(EmojiOuterClass.EmojiResponse emojiResponse) {

                    }
                });


        // global interceptor should be invoked once on each service
        Mockito.verify(globalInterceptor, Mockito.times(2))
                .interceptCall(Mockito.any(), Mockito.any(), Mockito.any());


        // log interceptor should be invoked only on GreeterService and not CalculatorService
        outputCapture.expect(CoreMatchers.containsString(EmojiGrpc.METHOD_LIST_EMOJIS.getFullMethodName()));

    }

}
