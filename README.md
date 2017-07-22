
# Script do banco de dados:

* Este script criará as tabelas necessárias.
* A estrutura criada não deve ser alterada!

`-- -----------------------------------------------------`<br/>
`-- Table Pessoa`<br/>
`-- -----------------------------------------------------`<br/>
`CREATE TABLE pessoa`<br/>
`( id bigserial NOT NULL,`<br/>
`nome character varying(100) NOT NULL,`<br/>
`datanascimento date,`<br/>
`cpf character varying(14),`<br/>
`funcionario boolean,`<br/>
`CONSTRAINT pk_pessoa PRIMARY KEY (id));`<br/>


`-- -----------------------------------------------------`<br/>
`-- Table Projeto`<br/>
`-- -----------------------------------------------------`<br/>
`CREATE TABLE  projeto (`<br/>
`  id bigserial NOT NULL,`<br/>
`  nome VARCHAR(200) NOT NULL,`<br/>
`  data_inicio DATE ,`<br/>
`  data_previsao_fim DATE ,`<br/>
`  data_fim DATE ,`<br/>
`  descrição VARCHAR(5000) ,`<br/>
`  status VARCHAR(45) ,`<br/>
`  orcamento FLOAT ,`<br/>
`  risco VARCHAR(45) ,`<br/>
`  idgerente bigserial NOT NULL,`<br/>
`  CONSTRAINT pk_projeto PRIMARY KEY (id),`<br/>
`  CONSTRAINT fk_gerente FOREIGN KEY (idgerente)`<br/>
`  REFERENCES pessoa (id) MATCH SIMPLE`<br/>
`  ON UPDATE NO ACTION ON DELETE NO ACTION) `<br/>


`-- -----------------------------------------------------`<br/>
`-- Table Membros`<br/>
`-- -----------------------------------------------------`<br/>
`CREATE TABLE membros`<br/>
`( idprojeto bigserial NOT NULL, `<br/>
`idpessoa bigint NOT NULL,  `<br/>
`CONSTRAINT pk_membros_projeto PRIMARY KEY (idprojeto, idpessoa),`<br/>
`CONSTRAINT fk_membros_projeto FOREIGN KEY (idprojeto)`<br/>
`REFERENCES projeto (id) MATCH SIMPLE`<br/>
`ON UPDATE NO ACTION ON DELETE NO ACTION,`<br/>
`CONSTRAINT fk_pessoa FOREIGN KEY (idpessoa)`<br/>
`REFERENCES pessoa (id) MATCH SIMPLE`<br/>
`ON UPDATE NO ACTION ON DELETE NO ACTION);`<br/>

