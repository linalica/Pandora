package by.itransition.pandora.util;


import javax.servlet.http.HttpServletRequest;

public class URIAnalyzer {

    private static final String URI_AND_PATH_PARAMETER_DELIMITER = "?";
    private static final String REFERER_HEADER = "Referer";
    private static final String HOST_HEADER = "Host";

    private static String cleanURI(String uri) {
        int pathParameterIndex = uri.indexOf(URI_AND_PATH_PARAMETER_DELIMITER);
        if (pathParameterIndex >= 0) {
            uri = uri.substring(0, pathParameterIndex);
        }
        return uri;
    }

    public static String getCurrentPage(HttpServletRequest request){
        String host = "http://" + request.getHeader(HOST_HEADER);
        return cleanURI(request.getHeader(REFERER_HEADER).replace(host, ""));

    }

}
