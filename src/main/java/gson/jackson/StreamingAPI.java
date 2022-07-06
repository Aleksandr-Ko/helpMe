package gson.jackson;

import com.fasterxml.jackson.core.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static com.fasterxml.jackson.core.JsonToken.VALUE_STRING;

/**
 * Example of StreamingAPI (write and read)
 *
 * Из 3 основных режимов обработки, которые поддерживает Jackson, потоковая обработка (также известная как инкрементная обработка)
 * является наиболее эффективным способом обрабатывать содержимое JSON. Он имеет наименьшие затраты памяти и обработки
 * и часто может соответствовать производительности многих доступных двоичных форматов данных. На платформе Java.
 *
 * Created by vvedenin on 4/24/2016.
 */
public class StreamingAPI {
    public static void main(String[] args) throws IOException {
        System.out.print("readJson: ");
        readJson();
        System.out.println();
        System.out.print("writeJson: ");
        writeJson();
    }

    /**
     *  Example to readJson using StreamingAPI
     */
    private static void readJson() throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser jsonParser = jsonFactory.createParser("{\"message\":\"Hi\",\"place\":{\"name\":\"World!\"}}");
        JsonToken jsonToken = jsonParser.nextToken();
        while(jsonParser.hasCurrentToken()) {
            if(jsonToken == VALUE_STRING) {
                System.out.print(jsonParser.getText() + " "); // print "Hi World!"
            }
            jsonToken = jsonParser.nextToken();
        }
        System.out.println();
    }

    /**
     * Example to writeJson using StreamingAPI
     */
    private static void writeJson() throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        OutputStream outputStream = new ByteArrayOutputStream();
        JsonGenerator jsonGenerator = jsonFactory.createGenerator(outputStream, JsonEncoding.UTF8); // or Stream, Reader
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("message", "Hi");
        jsonGenerator.writeFieldName("place");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", "World!");
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
        jsonGenerator.close();
        System.out.println(outputStream.toString()); // print "{"message":"Hi","place":{"name":"World!"}}"
    }
}
