CREATE TABLE IF NOT EXISTS TB_INGREDIENT
(
    `id` VARCHAR(36) NOT NULL PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(255)
);


insert into TB_INGREDIENT (id, name, description) VALUES ('3f9aa59f-893c-4635-909f-dd307b266bff', 'Tapioca', 'Tapioca da terra');