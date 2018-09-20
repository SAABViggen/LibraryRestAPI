package com.crud.library.controller;

import com.crud.library.domain.Book;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DbService service;
    @SpyBean
    BookMapper mapper;

    private Book book = new Book(1L, "Title", "Name", "Surname", 1999, null);
    private Gson gson = new Gson();
    private String jsonContent = gson.toJson(book);

    @Test
    public void shouldCreateBook() throws Exception {
        // Given
        // When & Then
        mockMvc.perform(post("/v1/library/books")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(service, times(1)).saveBook(book);
    }

    @Test
    public void shouldUpdateBook() throws Exception {
        // Given
        when(service.saveBook(book)).thenReturn(book);
        // When & Then
        mockMvc.perform(put("/v1/library/books")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(service, times(1)).saveBook(book);
    }

    @Test
    public void shouldDeleteBook() throws Exception {
        // Given
        // When & Then
        mockMvc.perform(delete("/v1/library/books/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(service, times(1)).deleteBook(1L);
    }

    @Test
    public void shouldFetchBookById() throws Exception {
        // Given
        when(service.getBook(1L)).thenReturn(Optional.of(book));
        // When & Then
        mockMvc.perform(get("/v1/library/books/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.authorName", is("Name")))
                .andExpect(jsonPath("$.authorSurname", is("Surname")))
                .andExpect(jsonPath("$.publicationYear", is(1999)))
                .andExpect(jsonPath("$.copies", is(0)));
    }

    @Test
    public void shouldFindBook() throws Exception {
        // Given
        List<Book> books = new ArrayList<>();
        books.add(book);
        when(service.search(ArgumentMatchers.any())).thenReturn(books);
        // When & Then
        mockMvc.perform(get("/v1/library/books/search?title=Title&authorName=Name&authorSurname=Surname")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].authorName", is("Name")))
                .andExpect(jsonPath("$[0].authorSurname", is("Surname")))
                .andExpect(jsonPath("$[0].publicationYear", is(1999)))
                .andExpect(jsonPath("$[0].copies", is(0)));
        ;
    }

    @Test
    public void shouldNotFindBook() throws Exception {
        // Given
        when(service.search(ArgumentMatchers.any())).thenReturn(new ArrayList<>());
        // When & Then
        mockMvc.perform(get("/v1/library/books/search?title=&authorName=&authorSurname=")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}