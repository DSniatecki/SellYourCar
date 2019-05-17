package com.dsniatecki.sellyourcar.auction.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
@RestController
class ExceptionController {

    @ExceptionHandler({AuctionNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleAuctionNotFoundException(
            AuctionNotFoundException exception, WebRequest webRequest){
        return new ExceptionResponse(LocalDateTime.now(),  exception.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler({NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleMultipleBadRequestExceptions(
            Exception exception, WebRequest webRequest){
        return new ExceptionResponse(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false));
    }


}
