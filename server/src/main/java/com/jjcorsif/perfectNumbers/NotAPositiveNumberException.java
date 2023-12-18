package com.jjcorsif.perfectNumbers;

class NotAPositiveNumberException extends Exception {

    NotAPositiveNumberException(String errorMessage) {
        super(errorMessage);
    }

    NotAPositiveNumberException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
