package com.callback;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;
import static java.util.Collections.emptyMap;

@JsonInclude(value = Include.NON_NULL)
public class CallbackDetails {
    public static final String ERROR_MESSAGE = "errorMessage";

    private final long notificationId;
    private final Map<String, String> additionalInfo;
    private final LocalDateTime sentTime;

    private CallbackDetails(LocalDateTime sentTime,
                            long notificationId,
                            Map<String, String> additionalInfo) {
        this.notificationId = notificationId;
        this.additionalInfo = additionalInfo;
        this.sentTime = sentTime;
    }


    public static CallbackDetails errorCallback(long notificationId, Map<String, String> additionalInfo) {
        return new CallbackDetails(null, notificationId, additionalInfo);
    }

    public static CallbackDetails successCallback(LocalDateTime sentTime, long notificationId) {
        return new CallbackDetails(sentTime, notificationId, emptyMap());
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    @JsonAnyGetter
    public Map<String, String> get() {
        return additionalInfo;
    }
}
