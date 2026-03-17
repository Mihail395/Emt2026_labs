CREATE TABLE country (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         continent VARCHAR(255) NOT NULL
);

CREATE TABLE host (
                      id BIGSERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      surname VARCHAR(255) NOT NULL,
                      country_id BIGINT REFERENCES country(id),
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE accommodation (
                               id BIGSERIAL PRIMARY KEY,
                               name VARCHAR(255) NOT NULL,
                               num_rooms INTEGER NOT NULL,
                               category VARCHAR(50) NOT NULL,
                               condition_status VARCHAR(50) DEFAULT 'GOOD',
                               rented BOOLEAN DEFAULT FALSE,
                               host_id BIGINT REFERENCES host(id),
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);