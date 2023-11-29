-- Tabla Usuario
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(10),
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    telefono VARCHAR(15),
    email VARCHAR(50) UNIQUE,
    contraseña VARCHAR(255),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla Obra
CREATE TABLE obra (
    id_obra INT AUTO_INCREMENT PRIMARY KEY,
    titulo_obra VARCHAR(100),
    descripcion_obra TEXT,
    duracion_min INT,
    imagen_obra VARCHAR(255),
    precio DECIMAL(10,2),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla Sala
CREATE TABLE sala (
    id_sala INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    capacidad INT,
    imagen_sala VARCHAR(255),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla Obra_Sala (Nueva tabla intermedia)
CREATE TABLE obra_sala (
    id_obra_sala INT AUTO_INCREMENT PRIMARY KEY,
    id_obra INT,
    id_sala INT,
    fecha DATE,
    hora TIME,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_obra) REFERENCES obra(id_obra),
    FOREIGN KEY (id_sala) REFERENCES sala(id_sala)
);

-- Tabla Compra
CREATE TABLE compra (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    fecha_compra DATE,
    precio DECIMAL(10,2),
    id_obra_sala INT,
    id_usuario INT,
    cantidad INT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_obra_sala) REFERENCES obra_sala(id_obra_sala),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

-- Tabla Valoracion
CREATE TABLE valoracion (
    id_valoracion INT AUTO_INCREMENT PRIMARY KEY,
    valoracion INT,
    id_obra INT,
    id_usuario INT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_obra) REFERENCES obra(id_obra),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(50) UNIQUE
);

INSERT INTO categoria (nombre_categoria) VALUES ('Drama'), ('Comedia'), ('Aventura'), ('Romance'), ('Suspense'), ('Fantasía'), ('Acción'), ('Humor'), ('Amor'), ('Familia');

CREATE TABLE obra_categoria (
    id_obra_categoria INT AUTO_INCREMENT PRIMARY KEY,
    id_obra INT,
    id_categoria INT,
    FOREIGN KEY (id_obra) REFERENCES obra(id_obra),
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

INSERT INTO obra_categoria (id_obra, id_categoria) VALUES
    (1, 1), (1, 9),  
    (2, 2), (2, 8),  
    (3, 1), (3, 5),  
    (4, 3), (4, 7),   
    (5, 5), (5, 6),   
    (6, 8), (6, 9),   
    (7, 2), (7, 8),   
    (8, 5), (8, 7),   
    (9, 9), (9, 10),  
    (10, 2), (10, 8), 
    (11, 9), (11, 10),
    (12, 5), (12, 7), 
    (13, 3), (13, 6), 
    (14, 7), (14, 10),
    (15, 2), (15, 10),
    (16, 5), (16, 7), 
    (17, 2), (17, 8), 
    (18, 9), (18, 10),
    (19, 3), (19, 6), 
    (20, 8), (20, 10);


INSERT INTO usuario (dni, nombre, apellidos, telefono, email, contraseña)
VALUES
    ('123456789', 'Juan', 'Pérez', '123456789', 'juan.perez@email.com', 'contraseña123'),
    ('987654321', 'María', 'Gómez', '987654321', 'maria.gomez@email.com', 'password456'),
    ('456789012', 'Luis', 'Martínez', '456789012', 'luis.martinez@email.com', 'securepass789'),
    ('789012345', 'Laura', 'Sánchez', '789012345', 'laura.sanchez@email.com', 'pass1234'),
    ('234567890', 'Carlos', 'Hernández', '234567890', 'carlos.hernandez@email.com', 'password5678'),
    ('890123456', 'Ana', 'López', '890123456', 'ana.lopez@email.com', 'securepass901'),
    ('345678901', 'David', 'Ramírez', '345678901', 'david.ramirez@email.com', 'pass5678'),
    ('567890123', 'Sofía', 'García', '567890123', 'sofia.garcia@email.com', 'password9012'),
    ('123890456', 'Miguel', 'Díaz', '123890456', 'miguel.diaz@email.com', 'securepass345'),
    ('456123789', 'Elena', 'Rodríguez', '456123789', 'elena.rodriguez@email.com', 'pass9012'),
    ('789234012', 'Javier', 'Fernández', '789234012', 'javier.fernandez@email.com', 'password345'),
    ('234567890', 'Isabel', 'Santos', '234567890', 'isabel.santos@email.com', 'securepass678'),
    ('890123456', 'Diego', 'Luna', '890123456', 'diego.luna@email.com', 'pass1239'),
    ('345678901', 'Carmen', 'Ruiz', '345678901', 'carmen.ruiz@email.com', 'password6789'),
    ('567890123', 'Pablo', 'Ortega', '567890123', 'pablo.ortega@email.com', 'securepass234'),
    ('123890456', 'Rocío', 'Cabrera', '123890456', 'rocio.cabrera@email.com', 'pass7890'),
    ('456123789', 'Hugo', 'Gutiérrez', '456123789', 'hugo.gutierrez@email.com', 'password234'),
    ('789234012', 'Natalia', 'Moreno', '789234012', 'natalia.moreno@email.com', 'securepass567'),
    ('234567890', 'Francisco', 'Vega', '234567890', 'francisco.vega@email.com', 'pass2345'),
    ('890123456', 'Raquel', 'Jiménez', '890123456', 'raquel.jimenez@email.com', 'password678'),
    ('345678901', 'Gabriel', 'Pardo', '345678901', 'gabriel.pardo@email.com', 'securepass890');

INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 1', 'Una emocionante obra de teatro', 120, 'obra1.jpg', 25.99);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 2', 'Una comedia hilarante', 90, 'obra2.jpg', 19.99);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 3', 'Drama con giros inesperados', 150, 'obra3.jpg', 29.99);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 4', 'Aventuras en el escenario', 105, 'obra4.jpg', 22.50);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 5', 'Suspense y misterio', 135, 'obra5.jpg', 27.75);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 6', 'Amor y desamor', 110, 'obra6.jpg', 24.50);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 7', 'Risas aseguradas', 100, 'obra7.jpg', 21.00);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 8', 'Intriga y acción', 120, 'obra8.jpg', 26.50);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 9', 'Emociones a flor de piel', 95, 'obra9.jpg', 20.75);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 10', 'Humor inteligente', 80, 'obra10.jpg', 18.99);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 11', 'Amor eterno en el escenario', 140, 'obra11.jpg', 28.50);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 12', 'Atrapa al público desde el primer minuto', 115, 'obra12.jpg', 25.25);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 13', 'Aventuras en un mundo imaginario', 125, 'obra13.jpg', 26.99);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 14', 'Un viaje a través del tiempo', 110, 'obra14.jpg', 23.75);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 15', 'Comedia romántica para toda la familia', 95, 'obra15.jpg', 20.50);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 16', 'Intriga y revelaciones sorprendentes', 130, 'obra16.jpg', 27.25);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 17', 'Risas garantizadas', 85, 'obra17.jpg', 19.50);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 18', 'Historia de amor imposible', 150, 'obra18.jpg', 29.75);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 19', 'Aventuras en un mundo fantástico', 120, 'obra19.jpg', 25.00);
INSERT INTO obra (titulo_obra, descripcion_obra, duracion_min, imagen_obra, precio) VALUES ('Obra 20', 'Humor y reflexión', 105, 'obra20.jpg', 22.99);



INSERT INTO sala (nombre,capacidad)
VALUES
    ('Sala A',100),
    ('Sala B',80),
    ('Sala C',120),
    ('Sala D',90),
    ('Sala E',110),
    ('Sala F',150);  

-- Generación de registros adicionales para obra_sala
INSERT INTO obra_sala (id_obra, id_sala, fecha, hora)
VALUES
    (1, 1, '2023-01-15', '20:00:00'),
    (2, 2, '2023-02-20', '18:30:00'),
    (3, 3, '2023-03-10', '15:45:00'),
    (4, 4, '2023-04-05', '21:15:00'),
    (5, 5, '2023-05-12', '19:30:00'),
    (6, 6, '2023-06-18', '17:00:00'),
    (7, 1, '2023-07-22', '16:15:00'),
    (8, 2, '2023-08-30', '14:45:00'),
    (9, 3, '2023-09-08', '22:00:00'),
    (10, 4, '2023-10-14', '19:00:00'),
    (1, 2, '2023-01-20', '19:30:00'),
    (2, 3, '2023-02-25', '20:45:00'),
    (3, 4, '2023-03-15', '16:30:00'),
    (4, 5, '2023-04-10', '22:30:00'),
    (5, 6, '2023-05-15', '18:45:00'),
    (6, 1, '2023-06-20', '15:30:00'),
    (7, 2, '2023-07-25', '17:45:00'),
    (8, 3, '2023-08-31', '21:00:00'),
    (9, 4, '2023-09-10', '20:15:00'),
    (10, 5, '2023-10-20', '19:30:00'),
    (1, 3, '2023-01-25', '18:00:00'),
    (2, 4, '2023-02-28', '19:15:00'),
    (3, 5, '2023-03-20', '20:30:00'),
    (4, 6, '2023-04-15', '21:45:00'),
    (5, 1, '2023-05-20', '22:00:00'),
    (6, 2, '2023-06-25', '18:30:00'),
    (7, 3, '2023-07-30', '16:00:00'),
    (8, 4, '2023-08-31', '19:15:00'),
    (9, 5, '2023-09-15', '20:30:00'),
    (10, 6, '2023-10-25', '21:45:00');

-- Generación de registros adicionales para compra
INSERT INTO compra (fecha_compra, precio, id_obra_sala, id_usuario, cantidad)
VALUES
    ('2023-01-15', 20.00, 1, 1, 2),
    ('2023-02-20', 25.00, 2, 2, 1),
    ('2023-03-10', 30.00, 3, 3, 3),
    ('2023-04-05', 15.00, 4, 4, 1),
    ('2023-05-12', 18.00, 5, 5, 2),
    ('2023-06-18', 22.00, 6, 6, 1),
    ('2023-07-22', 27.00, 7, 7, 3),
    ('2023-08-30', 35.00, 8, 8, 2),
    ('2023-09-08', 40.00, 9, 9, 1),
    ('2023-10-14', 32.00, 10, 10, 3),
    ('2023-01-20', 25.00, 11, 11, 2),
    ('2023-02-25', 30.00, 12, 12, 1),
    ('2023-03-15', 18.00, 13, 13, 3),
    ('2023-04-10', 20.00, 14, 14, 1),
    ('2023-05-15', 22.00, 15, 15, 2),
    ('2023-06-20', 28.00, 16, 16, 1),
    ('2023-07-25', 25.00, 17, 17, 3),
    ('2023-08-31', 30.00, 18, 18, 2),
    ('2023-09-10', 18.00, 19, 19, 1),
    ('2023-10-20', 22.00, 20, 20, 3),
    ('2023-01-25', 30.00, 21, 1, 2),
    ('2023-02-28', 22.00, 22, 2, 1),
    ('2023-03-20', 28.00, 23, 3, 3),
    ('2023-04-15', 35.00, 24, 4, 1),
    ('2023-05-20', 40.00, 25, 5, 2),
    ('2023-06-25', 32.00, 26, 6, 1),
    ('2023-07-30', 18.00, 27, 7, 3),
    ('2023-08-31', 20.00, 28, 8, 2),
    ('2023-09-15', 22.00, 29, 9, 1),
    ('2023-10-25', 28.00, 30, 10, 3);

-- Generación de registros adicionales para valoracion
INSERT INTO valoracion (valoracion, id_obra, id_usuario)
VALUES
    (5, 1, 1),
    (4, 2, 2),
    (3, 3, 3),
    (5, 4, 4),
    (4, 5, 5),
    (5, 6, 6),
    (3, 7, 7),
    (4, 8, 8),
    (5, 9, 9),
    (3, 10, 10),
    (4, 1, 11),
    (5, 2, 12),
    (3, 3, 13),
    (4, 4, 14),
    (5, 5, 15),
    (4, 6, 16),
    (3, 7, 17),
    (5, 8, 18),
    (4, 9, 19),
    (5, 10, 20),
    (5, 1, 1),
    (4, 2, 2),
    (3, 3, 3),
    (5, 4, 4),
    (4, 5, 5),
    (5, 6, 6),
    (3, 7, 7),
    (4, 8, 8),
    (5, 9, 9)