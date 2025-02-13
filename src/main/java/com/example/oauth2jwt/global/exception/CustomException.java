package com.example.oauth2jwt.global.exception;
import com.example.oauth2jwt.global.error.ErrorCode;



import lombok.Getter;
@Getter
public class CustomException extends  RuntimeException{


        private ErrorCode errorCode;
        private String message;


        public CustomException(ErrorCode errorCode) {
            this.errorCode = errorCode;
        }
        public CustomException(ErrorCode errorCode, String message) {
            this.errorCode = errorCode;
            this.message = message;
        }
}