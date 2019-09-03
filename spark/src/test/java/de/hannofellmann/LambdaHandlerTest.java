package de.hannofellmann;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.hannofellmann.LambdaHandler;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LambdaHandlerTest {
    @Test
    public void testDownload() throws IOException {
        String request = IOUtils.toString(getClass().getResourceAsStream("/event.json"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        new LambdaHandler().handleRequest(new ByteArrayInputStream(request.getBytes(StandardCharsets.UTF_8)),
                outputStream,
                null);

        JsonNode resultNode = new ObjectMapper().readTree(outputStream.toByteArray());
        Assert.assertTrue(resultNode.get("statusCode").asInt() == 200);
    }

    @Test
    public void testIndex() throws IOException {
        String request = IOUtils.toString(getClass().getResourceAsStream("/eventIndex.json"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        new LambdaHandler().handleRequest(new ByteArrayInputStream(request.getBytes(StandardCharsets.UTF_8)),
                outputStream,
                null);

        String body = new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
        Assert.assertTrue(body.contains("<form"));
    }
}
