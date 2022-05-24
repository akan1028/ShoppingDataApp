CREATE TABLE shopping
(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(20) NOT NULL,
   count INT NOT NULL,
   price INT NOT NULL,
   priceadd INT NOT NULL,
   location VARCHAR(30) NOT NULL,
   date    DATE,
   PRIMARY KEY(id)
);