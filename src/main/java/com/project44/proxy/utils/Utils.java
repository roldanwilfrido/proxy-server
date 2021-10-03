package com.project44.proxy.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Utils {

    public static String httpServletRequestToString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n ");
        sb.append("Request Method = [" + request.getMethod() + "]\n ");
        sb.append("Request URL Path = [" + request.getRequestURL() + "]\n ");

        String headers =
                Collections.list(request.getHeaderNames()).stream()
                        .map(headerName -> headerName + " : " + Collections.list(request.getHeaders(headerName)) )
                        .collect(Collectors.joining("\n "));

        if (headers.isEmpty()) {
            sb.append("Request headers: NONE\n ");
        } else {
            sb.append("Request headers: ["+headers+"]\n ");
        }

        String parameters =
                Collections.list(request.getParameterNames()).stream()
                        .map(p -> p + " : " + Arrays.asList( request.getParameterValues(p)) )
                        .collect(Collectors.joining("\n "));

        if (parameters.isEmpty()) {
            sb.append("Request parameters: NONE\n ");
        } else {
            sb.append("Request parameters: [" + parameters + "]\n ");
        }
        sb.append("\n ");

        return sb.toString();
    }
}
