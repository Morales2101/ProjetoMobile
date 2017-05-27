use sisreclama;

show tables;

drop database sisreclama;

drop database sisreclama_jpa;

use sisreclama_jpa;	

select * from usuario;

select * from reclamacao;
insert into usuario values (2, null, 43118328856, "renan@adm.com", "Renan Verna", "teste", "adm");


select * from solucionador;

alter table reclamacao change datahora datahora TIMESTAMP;