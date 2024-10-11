package com.callback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.time.LocalDateTime;

import static java.util.Collections.emptyMap;
import static com.callback.CallbackDetails.errorCallback;

public class CallbackDetailsTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void should_get_null_sent_time_when_error_code_is_set() {
        LocalDateTime sentTime = errorCallback(1L, emptyMap()).getSentTime();
    }
}
