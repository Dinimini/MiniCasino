package pa.minicasino.util;

import jakarta.servlet.http.HttpServletRequest;

public class Util {
    public static String extractTokenFromHeader(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        } else {
            throw new IllegalArgumentException("Invalid or missing Authorization header");
        }
    }

}
