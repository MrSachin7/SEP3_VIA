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
    comments = "Source: menu.proto")
public final class MenuServiceGrpc {

  private MenuServiceGrpc() {}

  public static final String SERVICE_NAME = "menu.MenuService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.CreateMenuRequest,
      grpcProtoFiles.MenuOuterClass.CreateMenuResponse> getCreateMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMenu",
      requestType = grpcProtoFiles.MenuOuterClass.CreateMenuRequest.class,
      responseType = grpcProtoFiles.MenuOuterClass.CreateMenuResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.CreateMenuRequest,
      grpcProtoFiles.MenuOuterClass.CreateMenuResponse> getCreateMenuMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.CreateMenuRequest, grpcProtoFiles.MenuOuterClass.CreateMenuResponse> getCreateMenuMethod;
    if ((getCreateMenuMethod = MenuServiceGrpc.getCreateMenuMethod) == null) {
      synchronized (MenuServiceGrpc.class) {
        if ((getCreateMenuMethod = MenuServiceGrpc.getCreateMenuMethod) == null) {
          MenuServiceGrpc.getCreateMenuMethod = getCreateMenuMethod = 
              io.grpc.MethodDescriptor.<grpcProtoFiles.MenuOuterClass.CreateMenuRequest, grpcProtoFiles.MenuOuterClass.CreateMenuResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "menu.MenuService", "CreateMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.MenuOuterClass.CreateMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.MenuOuterClass.CreateMenuResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MenuServiceMethodDescriptorSupplier("CreateMenu"))
                  .build();
          }
        }
     }
     return getCreateMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.GetMenuRequest,
      grpcProtoFiles.MenuOuterClass.GetMenuResponse> getGetMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMenu",
      requestType = grpcProtoFiles.MenuOuterClass.GetMenuRequest.class,
      responseType = grpcProtoFiles.MenuOuterClass.GetMenuResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.GetMenuRequest,
      grpcProtoFiles.MenuOuterClass.GetMenuResponse> getGetMenuMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.GetMenuRequest, grpcProtoFiles.MenuOuterClass.GetMenuResponse> getGetMenuMethod;
    if ((getGetMenuMethod = MenuServiceGrpc.getGetMenuMethod) == null) {
      synchronized (MenuServiceGrpc.class) {
        if ((getGetMenuMethod = MenuServiceGrpc.getGetMenuMethod) == null) {
          MenuServiceGrpc.getGetMenuMethod = getGetMenuMethod = 
              io.grpc.MethodDescriptor.<grpcProtoFiles.MenuOuterClass.GetMenuRequest, grpcProtoFiles.MenuOuterClass.GetMenuResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "menu.MenuService", "GetMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.MenuOuterClass.GetMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.MenuOuterClass.GetMenuResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MenuServiceMethodDescriptorSupplier("GetMenu"))
                  .build();
          }
        }
     }
     return getGetMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.GetAllMenuRequest,
      grpcProtoFiles.MenuOuterClass.GetMenusResponse> getGetAllMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllMenu",
      requestType = grpcProtoFiles.MenuOuterClass.GetAllMenuRequest.class,
      responseType = grpcProtoFiles.MenuOuterClass.GetMenusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.GetAllMenuRequest,
      grpcProtoFiles.MenuOuterClass.GetMenusResponse> getGetAllMenuMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.GetAllMenuRequest, grpcProtoFiles.MenuOuterClass.GetMenusResponse> getGetAllMenuMethod;
    if ((getGetAllMenuMethod = MenuServiceGrpc.getGetAllMenuMethod) == null) {
      synchronized (MenuServiceGrpc.class) {
        if ((getGetAllMenuMethod = MenuServiceGrpc.getGetAllMenuMethod) == null) {
          MenuServiceGrpc.getGetAllMenuMethod = getGetAllMenuMethod = 
              io.grpc.MethodDescriptor.<grpcProtoFiles.MenuOuterClass.GetAllMenuRequest, grpcProtoFiles.MenuOuterClass.GetMenusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "menu.MenuService", "GetAllMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.MenuOuterClass.GetAllMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.MenuOuterClass.GetMenusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MenuServiceMethodDescriptorSupplier("GetAllMenu"))
                  .build();
          }
        }
     }
     return getGetAllMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest,
      grpcProtoFiles.MenuOuterClass.GetMenusResponse> getGetMenuByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMenuByName",
      requestType = grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest.class,
      responseType = grpcProtoFiles.MenuOuterClass.GetMenusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest,
      grpcProtoFiles.MenuOuterClass.GetMenusResponse> getGetMenuByNameMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest, grpcProtoFiles.MenuOuterClass.GetMenusResponse> getGetMenuByNameMethod;
    if ((getGetMenuByNameMethod = MenuServiceGrpc.getGetMenuByNameMethod) == null) {
      synchronized (MenuServiceGrpc.class) {
        if ((getGetMenuByNameMethod = MenuServiceGrpc.getGetMenuByNameMethod) == null) {
          MenuServiceGrpc.getGetMenuByNameMethod = getGetMenuByNameMethod = 
              io.grpc.MethodDescriptor.<grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest, grpcProtoFiles.MenuOuterClass.GetMenusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "menu.MenuService", "GetMenuByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.MenuOuterClass.GetMenusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MenuServiceMethodDescriptorSupplier("GetMenuByName"))
                  .build();
          }
        }
     }
     return getGetMenuByNameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MenuServiceStub newStub(io.grpc.Channel channel) {
    return new MenuServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MenuServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MenuServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MenuServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MenuServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MenuServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createMenu(grpcProtoFiles.MenuOuterClass.CreateMenuRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.CreateMenuResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMenuMethod(), responseObserver);
    }

    /**
     */
    public void getMenu(grpcProtoFiles.MenuOuterClass.GetMenuRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.GetMenuResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMenuMethod(), responseObserver);
    }

    /**
     */
    public void getAllMenu(grpcProtoFiles.MenuOuterClass.GetAllMenuRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.GetMenusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllMenuMethod(), responseObserver);
    }

    /**
     */
    public void getMenuByName(grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.GetMenusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMenuByNameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMenuMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.MenuOuterClass.CreateMenuRequest,
                grpcProtoFiles.MenuOuterClass.CreateMenuResponse>(
                  this, METHODID_CREATE_MENU)))
          .addMethod(
            getGetMenuMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.MenuOuterClass.GetMenuRequest,
                grpcProtoFiles.MenuOuterClass.GetMenuResponse>(
                  this, METHODID_GET_MENU)))
          .addMethod(
            getGetAllMenuMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.MenuOuterClass.GetAllMenuRequest,
                grpcProtoFiles.MenuOuterClass.GetMenusResponse>(
                  this, METHODID_GET_ALL_MENU)))
          .addMethod(
            getGetMenuByNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest,
                grpcProtoFiles.MenuOuterClass.GetMenusResponse>(
                  this, METHODID_GET_MENU_BY_NAME)))
          .build();
    }
  }

  /**
   */
  public static final class MenuServiceStub extends io.grpc.stub.AbstractStub<MenuServiceStub> {
    private MenuServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MenuServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MenuServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MenuServiceStub(channel, callOptions);
    }

    /**
     */
    public void createMenu(grpcProtoFiles.MenuOuterClass.CreateMenuRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.CreateMenuResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMenu(grpcProtoFiles.MenuOuterClass.GetMenuRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.GetMenuResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllMenu(grpcProtoFiles.MenuOuterClass.GetAllMenuRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.GetMenusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMenuByName(grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.GetMenusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMenuByNameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MenuServiceBlockingStub extends io.grpc.stub.AbstractStub<MenuServiceBlockingStub> {
    private MenuServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MenuServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MenuServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MenuServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpcProtoFiles.MenuOuterClass.CreateMenuResponse createMenu(grpcProtoFiles.MenuOuterClass.CreateMenuRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateMenuMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpcProtoFiles.MenuOuterClass.GetMenuResponse getMenu(grpcProtoFiles.MenuOuterClass.GetMenuRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMenuMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpcProtoFiles.MenuOuterClass.GetMenusResponse getAllMenu(grpcProtoFiles.MenuOuterClass.GetAllMenuRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllMenuMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpcProtoFiles.MenuOuterClass.GetMenusResponse getMenuByName(grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMenuByNameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MenuServiceFutureStub extends io.grpc.stub.AbstractStub<MenuServiceFutureStub> {
    private MenuServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MenuServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MenuServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MenuServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.MenuOuterClass.CreateMenuResponse> createMenu(
        grpcProtoFiles.MenuOuterClass.CreateMenuRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMenuMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.MenuOuterClass.GetMenuResponse> getMenu(
        grpcProtoFiles.MenuOuterClass.GetMenuRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMenuMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.MenuOuterClass.GetMenusResponse> getAllMenu(
        grpcProtoFiles.MenuOuterClass.GetAllMenuRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllMenuMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.MenuOuterClass.GetMenusResponse> getMenuByName(
        grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMenuByNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MENU = 0;
  private static final int METHODID_GET_MENU = 1;
  private static final int METHODID_GET_ALL_MENU = 2;
  private static final int METHODID_GET_MENU_BY_NAME = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MenuServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MenuServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_MENU:
          serviceImpl.createMenu((grpcProtoFiles.MenuOuterClass.CreateMenuRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.CreateMenuResponse>) responseObserver);
          break;
        case METHODID_GET_MENU:
          serviceImpl.getMenu((grpcProtoFiles.MenuOuterClass.GetMenuRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.GetMenuResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_MENU:
          serviceImpl.getAllMenu((grpcProtoFiles.MenuOuterClass.GetAllMenuRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.GetMenusResponse>) responseObserver);
          break;
        case METHODID_GET_MENU_BY_NAME:
          serviceImpl.getMenuByName((grpcProtoFiles.MenuOuterClass.GetMenuByNameRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.MenuOuterClass.GetMenusResponse>) responseObserver);
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

  private static abstract class MenuServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MenuServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpcProtoFiles.MenuOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MenuService");
    }
  }

  private static final class MenuServiceFileDescriptorSupplier
      extends MenuServiceBaseDescriptorSupplier {
    MenuServiceFileDescriptorSupplier() {}
  }

  private static final class MenuServiceMethodDescriptorSupplier
      extends MenuServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MenuServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MenuServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MenuServiceFileDescriptorSupplier())
              .addMethod(getCreateMenuMethod())
              .addMethod(getGetMenuMethod())
              .addMethod(getGetAllMenuMethod())
              .addMethod(getGetMenuByNameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
