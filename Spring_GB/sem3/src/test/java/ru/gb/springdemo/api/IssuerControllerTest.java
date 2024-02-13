package ru.gb.springdemo.api;

import org.junit.jupiter.api.Test;
import ru.gb.springdemo.FrameForTests;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;

import static org.junit.jupiter.api.Assertions.*;

class IssuerControllerTest extends FrameForTests {

    @Test
    void issueBook() {
        long reader = readerService.getAllReaders().getFirst().getId();
        long book = bookService.getAllBooks().getFirst().getId();
        IssueRequest issueRequest = new IssueRequest(reader, book);
        Issue expected = issuerService.issue(issueRequest);

        Issue response = webTestClient.post()
                .uri("/api/issue")
                .bodyValue(issueRequest)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Issue.class)
                .returnResult().getResponseBody();

        assertNotNull(response);
        assertEquals(expected.getBookId(), response.getBookId());
        assertEquals(expected.getReaderId(), response.getReaderId());
    }

    @Test
    void getIssueDescription() {
        Issue issue = issuerService.getAllIssues().getFirst();
        String expected = issuerService.getInfoById(issue.getId());

        String response = webTestClient.get()
                .uri("/api/issue/" + issue.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult().getResponseBody();

        assertEquals(expected, response);
    }
}