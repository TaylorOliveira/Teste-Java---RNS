package com.cisne.util;

import com.cisne.payload.generic.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utils {

    public static ResponseEntity<?> created(Boolean sucess, String message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(sucess, message));
    }

    public static ResponseEntity<?> ok(Boolean sucess, String message) {
        return ResponseEntity.ok().body(new ApiResponse(sucess, message));
    }

    public static ResponseEntity<?> badRequest(Boolean sucess, String message) {
        return ResponseEntity.badRequest().body(new ApiResponse(sucess, message));
    }

    public static ResponseEntity<?> forbidden(Boolean success, String message){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiResponse(success, message));
    }

    public static ResponseEntity<?> deleted(Boolean success, String message) {
        return ResponseEntity.status(410).body(new ApiResponse(success, message));
    }
}
