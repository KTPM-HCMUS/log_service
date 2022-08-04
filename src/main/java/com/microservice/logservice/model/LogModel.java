package com.microservice.logservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "log_service")
public class LogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "uri")
    private String uri;

    @Column(name = "header")
    private String header;

    @Column(name = "http_request")
    private String httpRequest;

    @Column(name = "response_data")
    private String responseData;

    @Column(name = "request_data")
    private String requestData;

    @Column(name = "request_date")
    private String requestDate;

    @Column(name = "response_date")
    private String responseDate;

    @Column(name = "process_time")
    private long processTime;

    @Column(name = "http_result")
    private String httpResult;

    @Column(name = "request_IP")
    private String requestIP;
}
