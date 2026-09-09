CREATE TABLE IF NOT EXISTS ganado (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    peso DOUBLE NOT NULL
);

INSERT INTO ganado (nombre, peso) VALUES
    ('manchada-vaca', 60),
    ('blanca-chiva', 40),
    ('micky-curi', 20),
    ('clara-gallina', 10),
    ('rex-lombriz', 5);