package com.epam.springboot.SwaggerDemo.controller;

import com.epam.springboot.SwaggerDemo.model.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Api(value = "BookResource", description = "Api related to Books" )
@RestController
@RequestMapping("/api/v1/books")
public class BookResource {

    ConcurrentMap<String, Book> books = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    public Book getBook(@PathVariable String id){
        return books.get(id);
    }

    @ApiOperation(value = "Get list of Books in the System ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @GetMapping("/")
    public List<Book> getAllBooks(){
        return new ArrayList<Book>(books.values());
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        books.put(book.getId(),book);
        return book;
    }

    @GetMapping("/msg")
    public String message(){
        return "Welcome to Books Resource Application";
    }
}
