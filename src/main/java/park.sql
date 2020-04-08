CREATE TABLE park
(
    id INT NOT NULL,
    parking_space  VARCHAR(20) NOT NULL ,
    car_number VARCHAR(20) NOT NULL UNIQUE
);