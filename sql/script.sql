create table log_service(
                            id int NOT NULL PRIMARY KEY,
                            uri varchar(100),
                            header varchar(500),
                            http_request varchar(50),
                            response_data varchar(1000),
                            request_data varchar(1000),
                            request_date varchar(50),
                            response_date varchar(50),
                            process_time long,
                            http_result varchar(50),
                            request_IP varchar(100)
);