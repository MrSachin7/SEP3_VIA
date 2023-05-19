package grpcProtoFiles;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: reservation.proto")
public final class ReservationServiceGrpc {

  private ReservationServiceGrpc() {}

  public static final String SERVICE_NAME = "reservation.ReservationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.CreateReservationRequest,
      grpcProtoFiles.ReservationOuterClass.CreateReservationResponse> getCreateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createReservation",
      requestType = grpcProtoFiles.ReservationOuterClass.CreateReservationRequest.class,
      responseType = grpcProtoFiles.ReservationOuterClass.CreateReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.CreateReservationRequest,
      grpcProtoFiles.ReservationOuterClass.CreateReservationResponse> getCreateReservationMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.CreateReservationRequest, grpcProtoFiles.ReservationOuterClass.CreateReservationResponse> getCreateReservationMethod;
    if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
          ReservationServiceGrpc.getCreateReservationMethod = getCreateReservationMethod = 
              io.grpc.MethodDescriptor.<grpcProtoFiles.ReservationOuterClass.CreateReservationRequest, grpcProtoFiles.ReservationOuterClass.CreateReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "reservation.ReservationService", "createReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.ReservationOuterClass.CreateReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.ReservationOuterClass.CreateReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("createReservation"))
                  .build();
          }
        }
     }
     return getCreateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.GetReservationRequest,
      grpcProtoFiles.ReservationOuterClass.GetReservationResponse> getGetReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getReservation",
      requestType = grpcProtoFiles.ReservationOuterClass.GetReservationRequest.class,
      responseType = grpcProtoFiles.ReservationOuterClass.GetReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.GetReservationRequest,
      grpcProtoFiles.ReservationOuterClass.GetReservationResponse> getGetReservationMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.GetReservationRequest, grpcProtoFiles.ReservationOuterClass.GetReservationResponse> getGetReservationMethod;
    if ((getGetReservationMethod = ReservationServiceGrpc.getGetReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservationMethod = ReservationServiceGrpc.getGetReservationMethod) == null) {
          ReservationServiceGrpc.getGetReservationMethod = getGetReservationMethod = 
              io.grpc.MethodDescriptor.<grpcProtoFiles.ReservationOuterClass.GetReservationRequest, grpcProtoFiles.ReservationOuterClass.GetReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "reservation.ReservationService", "getReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.ReservationOuterClass.GetReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.ReservationOuterClass.GetReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("getReservation"))
                  .build();
          }
        }
     }
     return getGetReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest,
      grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse> getGetAllReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllReservations",
      requestType = grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest.class,
      responseType = grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest,
      grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse> getGetAllReservationsMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest, grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse> getGetAllReservationsMethod;
    if ((getGetAllReservationsMethod = ReservationServiceGrpc.getGetAllReservationsMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetAllReservationsMethod = ReservationServiceGrpc.getGetAllReservationsMethod) == null) {
          ReservationServiceGrpc.getGetAllReservationsMethod = getGetAllReservationsMethod = 
              io.grpc.MethodDescriptor.<grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest, grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "reservation.ReservationService", "getAllReservations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("getAllReservations"))
                  .build();
          }
        }
     }
     return getGetAllReservationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest,
      grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse> getGetReservationsByUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getReservationsByUser",
      requestType = grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest.class,
      responseType = grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest,
      grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse> getGetReservationsByUserMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest, grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse> getGetReservationsByUserMethod;
    if ((getGetReservationsByUserMethod = ReservationServiceGrpc.getGetReservationsByUserMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservationsByUserMethod = ReservationServiceGrpc.getGetReservationsByUserMethod) == null) {
          ReservationServiceGrpc.getGetReservationsByUserMethod = getGetReservationsByUserMethod = 
              io.grpc.MethodDescriptor.<grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest, grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "reservation.ReservationService", "getReservationsByUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("getReservationsByUser"))
                  .build();
          }
        }
     }
     return getGetReservationsByUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReservationServiceStub newStub(io.grpc.Channel channel) {
    return new ReservationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReservationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReservationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReservationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ReservationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createReservation(grpcProtoFiles.ReservationOuterClass.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.CreateReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReservationMethod(), responseObserver);
    }

    /**
     */
    public void getReservation(grpcProtoFiles.ReservationOuterClass.GetReservationRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.GetReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationMethod(), responseObserver);
    }

    /**
     */
    public void getAllReservations(grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllReservationsMethod(), responseObserver);
    }

    /**
     */
    public void getReservationsByUser(grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationsByUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.ReservationOuterClass.CreateReservationRequest,
                grpcProtoFiles.ReservationOuterClass.CreateReservationResponse>(
                  this, METHODID_CREATE_RESERVATION)))
          .addMethod(
            getGetReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.ReservationOuterClass.GetReservationRequest,
                grpcProtoFiles.ReservationOuterClass.GetReservationResponse>(
                  this, METHODID_GET_RESERVATION)))
          .addMethod(
            getGetAllReservationsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest,
                grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse>(
                  this, METHODID_GET_ALL_RESERVATIONS)))
          .addMethod(
            getGetReservationsByUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest,
                grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse>(
                  this, METHODID_GET_RESERVATIONS_BY_USER)))
          .build();
    }
  }

  /**
   */
  public static final class ReservationServiceStub extends io.grpc.stub.AbstractStub<ReservationServiceStub> {
    private ReservationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceStub(channel, callOptions);
    }

    /**
     */
    public void createReservation(grpcProtoFiles.ReservationOuterClass.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.CreateReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservation(grpcProtoFiles.ReservationOuterClass.GetReservationRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.GetReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllReservations(grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllReservationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservationsByUser(grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationsByUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReservationServiceBlockingStub extends io.grpc.stub.AbstractStub<ReservationServiceBlockingStub> {
    private ReservationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpcProtoFiles.ReservationOuterClass.CreateReservationResponse createReservation(grpcProtoFiles.ReservationOuterClass.CreateReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpcProtoFiles.ReservationOuterClass.GetReservationResponse getReservation(grpcProtoFiles.ReservationOuterClass.GetReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse getAllReservations(grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllReservationsMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse getReservationsByUser(grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationsByUserMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReservationServiceFutureStub extends io.grpc.stub.AbstractStub<ReservationServiceFutureStub> {
    private ReservationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.ReservationOuterClass.CreateReservationResponse> createReservation(
        grpcProtoFiles.ReservationOuterClass.CreateReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.ReservationOuterClass.GetReservationResponse> getReservation(
        grpcProtoFiles.ReservationOuterClass.GetReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse> getAllReservations(
        grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllReservationsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse> getReservationsByUser(
        grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationsByUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RESERVATION = 0;
  private static final int METHODID_GET_RESERVATION = 1;
  private static final int METHODID_GET_ALL_RESERVATIONS = 2;
  private static final int METHODID_GET_RESERVATIONS_BY_USER = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReservationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReservationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RESERVATION:
          serviceImpl.createReservation((grpcProtoFiles.ReservationOuterClass.CreateReservationRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.CreateReservationResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVATION:
          serviceImpl.getReservation((grpcProtoFiles.ReservationOuterClass.GetReservationRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.GetReservationResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_RESERVATIONS:
          serviceImpl.getAllReservations((grpcProtoFiles.ReservationOuterClass.GetAllReservationsRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.GetAllReservationsResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVATIONS_BY_USER:
          serviceImpl.getReservationsByUser((grpcProtoFiles.ReservationOuterClass.GetReservationsByUserRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.ReservationOuterClass.GetReservationsByUserResponse>) responseObserver);
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

  private static abstract class ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpcProtoFiles.ReservationOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationService");
    }
  }

  private static final class ReservationServiceFileDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier {
    ReservationServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationServiceMethodDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReservationServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ReservationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReservationServiceFileDescriptorSupplier())
              .addMethod(getCreateReservationMethod())
              .addMethod(getGetReservationMethod())
              .addMethod(getGetAllReservationsMethod())
              .addMethod(getGetReservationsByUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
