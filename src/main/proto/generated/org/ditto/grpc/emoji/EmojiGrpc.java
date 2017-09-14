package org.ditto.grpc.emoji;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The emoji service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.5.0)",
    comments = "Source: emoji.proto")
public final class EmojiGrpc {

  private EmojiGrpc() {}

  public static final String SERVICE_NAME = "Emoji";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.ditto.grpc.emoji.EmojiOuterClass.EmojiRequest,
      org.ditto.grpc.emoji.EmojiOuterClass.EmojiResponse> METHOD_LIST_EMOJIS =
      io.grpc.MethodDescriptor.<org.ditto.grpc.emoji.EmojiOuterClass.EmojiRequest, org.ditto.grpc.emoji.EmojiOuterClass.EmojiResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "Emoji", "ListEmojis"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.ditto.grpc.emoji.EmojiOuterClass.EmojiRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.ditto.grpc.emoji.EmojiOuterClass.EmojiResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmojiStub newStub(io.grpc.Channel channel) {
    return new EmojiStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmojiBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EmojiBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmojiFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EmojiFutureStub(channel);
  }

  /**
   * <pre>
   * The emoji service definition.
   * </pre>
   */
  public static abstract class EmojiImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Emojis whose status are after the given lastUpdated.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the lastUpdated maybe an very old time and contain a
     * huge number of emojis.
     * </pre>
     */
    public void listEmojis(org.ditto.grpc.emoji.EmojiOuterClass.EmojiRequest request,
        io.grpc.stub.StreamObserver<org.ditto.grpc.emoji.EmojiOuterClass.EmojiResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_EMOJIS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LIST_EMOJIS,
            asyncServerStreamingCall(
              new MethodHandlers<
                org.ditto.grpc.emoji.EmojiOuterClass.EmojiRequest,
                org.ditto.grpc.emoji.EmojiOuterClass.EmojiResponse>(
                  this, METHODID_LIST_EMOJIS)))
          .build();
    }
  }

  /**
   * <pre>
   * The emoji service definition.
   * </pre>
   */
  public static final class EmojiStub extends io.grpc.stub.AbstractStub<EmojiStub> {
    private EmojiStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmojiStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmojiStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmojiStub(channel, callOptions);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Emojis whose status are after the given lastUpdated.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the lastUpdated maybe an very old time and contain a
     * huge number of emojis.
     * </pre>
     */
    public void listEmojis(org.ditto.grpc.emoji.EmojiOuterClass.EmojiRequest request,
        io.grpc.stub.StreamObserver<org.ditto.grpc.emoji.EmojiOuterClass.EmojiResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_EMOJIS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The emoji service definition.
   * </pre>
   */
  public static final class EmojiBlockingStub extends io.grpc.stub.AbstractStub<EmojiBlockingStub> {
    private EmojiBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmojiBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmojiBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmojiBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Emojis whose status are after the given lastUpdated.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the lastUpdated maybe an very old time and contain a
     * huge number of emojis.
     * </pre>
     */
    public java.util.Iterator<org.ditto.grpc.emoji.EmojiOuterClass.EmojiResponse> listEmojis(
        org.ditto.grpc.emoji.EmojiOuterClass.EmojiRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_EMOJIS, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The emoji service definition.
   * </pre>
   */
  public static final class EmojiFutureStub extends io.grpc.stub.AbstractStub<EmojiFutureStub> {
    private EmojiFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmojiFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmojiFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmojiFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_LIST_EMOJIS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmojiImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmojiImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_EMOJIS:
          serviceImpl.listEmojis((org.ditto.grpc.emoji.EmojiOuterClass.EmojiRequest) request,
              (io.grpc.stub.StreamObserver<org.ditto.grpc.emoji.EmojiOuterClass.EmojiResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class EmojiDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.ditto.grpc.emoji.EmojiOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EmojiGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmojiDescriptorSupplier())
              .addMethod(METHOD_LIST_EMOJIS)
              .build();
        }
      }
    }
    return result;
  }
}
