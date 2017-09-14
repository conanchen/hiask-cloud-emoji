package org.ditto.emoji.grpc;

import io.grpc.stub.StreamObserver;
import org.ditto.grpc.emoji.GreeterGrpc;
import org.ditto.grpc.emoji.GreeterOuterClass;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService(interceptors = { LogInterceptor.class })
public class GreeterService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(GreeterOuterClass.HelloRequest request, StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
        final GreeterOuterClass.HelloReply.Builder replyBuilder = GreeterOuterClass.HelloReply.newBuilder().setMessage("Hello " + request.getName());
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}