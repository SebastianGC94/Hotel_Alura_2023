select * from huespedes;
select * from usuarios;
select * from reservas;

describe huespedes;
describe usuarios;
describe reservas;



delete from huespedes;
delete from usuarios;
delete from reservas;

ALTER TABLE huespedes AUTO_INCREMENT = 1;
ALTER TABLE reservas AUTO_INCREMENT = 1;
ALTER TABLE usuarios AUTO_INCREMENT = 1;

ALTER TABLE usuarios
ADD id INT AUTO_INCREMENT PRIMARY KEY;

