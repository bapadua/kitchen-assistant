CREATE TABLE IF NOT EXISTS `TB_INGREDIENT` (
    `id` VARCHAR(36) NOT NULL DEFAULT (UUID),
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


insert into TB_INGREDIENT (name, description) VALUES ('Tapioca', 'Tapioca da terra');