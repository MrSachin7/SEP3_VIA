using Google.Protobuf.Collections;

namespace GrpcService.converters; 

public static class AbstractConverter {

    public static List<T> ToList<T>(RepeatedField<T> repeatedField) {
        List<T> list = new();
        list.AddRange(repeatedField);
        return list;
    }

}