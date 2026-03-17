CREATE TABLE review (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        comment VARCHAR(255),
                        rating INT,
                        accommodation_id BIGINT,
                        CONSTRAINT fk_review_accommodation
                            FOREIGN KEY (accommodation_id)
                                REFERENCES accommodation(id)
                                ON DELETE CASCADE
);

INSERT INTO review (comment, rating, accommodation_id)
VALUES ('Great place, very clean!', 5, 1);

INSERT INTO review (comment, rating, accommodation_id)
VALUES ('Decent, but could be better.', 3, 1);