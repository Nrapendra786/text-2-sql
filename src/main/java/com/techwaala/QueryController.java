package com.techwaala;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/text-to-sql")
public class QueryController {

    private SqlGenerator sqlGenerator;

    private SqlExecutor sqlExecutor;

    @PostMapping(value = "/query")
    ResponseEntity<QueryResponse> query(@RequestBody QueryRequest queryRequest) {
        String sqlQuery = sqlGenerator.generate(queryRequest.question());
        List<?> result = sqlExecutor.execute(sqlQuery);
        return ResponseEntity.ok(new QueryResponse(result));
    }

    record QueryRequest(String question) {
    }

    record QueryResponse(List<?> result) {
    }
}
