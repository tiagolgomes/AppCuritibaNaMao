-- TABELA TIPO_USUARIO

INSERT INTO TIPO_USUARIO ( IDTIPO_USUARIO, NOME_TIPO_USUARIO) 
VALUES (1,'ADMINISTRADOR');

INSERT INTO TIPO_USUARIO (IDTIPO_USUARIO, NOME_TIPO_USUARIO) 
VALUES (2,'PROMOTER');

INSERT INTO TIPO_USUARIO (IDTIPO_USUARIO, NOME_TIPO_USUARIO) 
VALUES (3,'USUARIO');

-- TABELA USUARIO

INSERT INTO USUARIO (
IDUSUARIO, 
IDTIPO_USUARIO, 
NOME_USUARIO, 
CIDADE_USUARIO, 
DDD_TELEFONE_USUARIO, 
TELEFONE_USUARIO, 
EMAIL_USUARIO, 
LOGIN_USUARIO, 
SENHA_USUARIO
) 
VALUES (
1,
1,
'TIAGO GOMES',
'CURITIBA',
41,
995465560,
'TIAGOLACERDAGOMES@GMAIL.COM',
'1',
'1'
);

INSERT INTO USUARIO (
IDUSUARIO, 
IDTIPO_USUARIO, 
NOME_USUARIO, 
CIDADE_USUARIO, 
DDD_TELEFONE_USUARIO, 
TELEFONE_USUARIO, 
EMAIL_USUARIO, 
LOGIN_USUARIO, 
SENHA_USUARIO
) 
VALUES (
2,
2,
'VANESSA MACHADO',
'CURITIBA',
41,
999154885,
'VANESSA.NIROM@GMAIL.COM',
'2',
'2'
);

INSERT INTO USUARIO (
IDUSUARIO, 
IDTIPO_USUARIO, 
NOME_USUARIO, 
CIDADE_USUARIO, 
DDD_TELEFONE_USUARIO, 
TELEFONE_USUARIO, 
EMAIL_USUARIO, 
LOGIN_USUARIO, 
SENHA_USUARIO
) 
VALUES (
3,
3,
'VANESSA MACHADO',
'CURITIBA',
41,
999154885,
'VANESSA.NIROM@GMAIL.COM',
'3',
'3'
);

-- TABELA CATEGORIA_ESTABELECIMENTO

INSERT INTO CATEGORIA_ESTABELECIMENTO (IDCATEGORIA_ESTABELECIMENTO, NOME_CATEGORIA_ESTABELECIMENTO) 
VALUES (1,'BAR');

INSERT INTO CATEGORIA_ESTABELECIMENTO (IDCATEGORIA_ESTABELECIMENTO, NOME_CATEGORIA_ESTABELECIMENTO) 
VALUES (2,'BALADA');

INSERT INTO CATEGORIA_ESTABELECIMENTO (IDCATEGORIA_ESTABELECIMENTO, NOME_CATEGORIA_ESTABELECIMENTO) 
VALUES (3,'RESTAURANTE');

-- TABELA ESTABELECIMENTO

INSERT INTO ESTABELECIMENTO (
IDESTABELECIMENTO, 
IDCATEGORIA_ESTABELECIMENTO, 
NOME_ESTABELECIMENTO, 
ENDERECO_ESTABELECIMENTO, 
CIDADE_ESTABELECIMENTO, 
DDD_TELEFONE_ESTABELECIMENTO, 
TELEFONE_ESTABELECIMENTO, 
EMAIL_ESTABELECIMENTO, 
ESTILO_ESTABELECIMENTO, 
VALOR_ESTABELECIMENTO
) 
VALUES (
1,
1,
'BAR DO ALEMAO',
'LARGO DA ORDEM, 123',
'CURITIBA',
41,
33333333,
'BAR@ALEMAO.COM.BR',
'ALEMAO',
0
);

-- TABELA USUARIO_ESTABELECIMENTO

INSERT INTO USUARIO_ESTABELECIMENTO (IDUSUARIO, IDESTABELECIMENTO, CRIACAO_ESTABELECIMENTO) 
VALUES (2, 1, '09/06/2018');







