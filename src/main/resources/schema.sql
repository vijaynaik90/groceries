--
drop table if exists groceriesdb.authorities;
-- drop table if exists groceriesdb.cart_item;
-- drop table if exists groceriesdb.files;
-- drop table if exists groceriesdb.order_details;
-- drop table if exists groceriesdb.orders;
-- drop table if exists groceriesdb.product;
-- drop table if exists groceriesdb.product_category;
-- drop table if exists groceriesdb.shipping_address;
-- -- drop table if exists groceriesdb.cart CASCADE;
-- drop table if exists groceriesdb.user_profile;
drop table if exists groceriesdb.users;

SET GLOBAL default_storage_engine = 'InnoDb';
--
CREATE TABLE groceriesdb.users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL,
    is_locked BOOLEAN NOT NULL DEFAULT false,
    is_expired BOOLEAN NOT NULL DEFAULT false
);
-- --
CREATE TABLE groceriesdb.authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE,
    CONSTRAINT authorities_idx_1 UNIQUE(username, authority)
);
-- --
-- create table groceriesdb.product_category (
--   id CHAR not null,
--   description varchar(255),
--   name varchar(255),
--   primary key (id)
-- );
-- create table groceriesdb.product (
--   id CHAR not null,
--   created_at timestamp,
--   description varchar(255),
--   name varchar(255),
--   price double,
--   sku varchar(255),
--   stock integer,
--   unit double,
--   unit_of_measure varchar(255),
--   category_id CHAR not null,
--   primary key (id),
--   FOREIGN KEY (category_id) REFERENCES groceriesdb.product_category(id) ON DELETE CASCADE
-- );
-- --
-- create table groceriesdb.cart (
--   id CHAR not null,
--   created_at timestamp,
--   customer_id varchar(255),
--   primary key (id),
--   FOREIGN KEY (customer_id) REFERENCES groceriesdb.users(username) ON DELETE CASCADE
-- );
-- create table groceriesdb.cart_item (
--   id CHAR not null,
--   quantity double,
--   total_price double,
--   cart_id CHAR,
--   product_id CHAR,
--   primary key (id),
--   FOREIGN KEY (cart_id) REFERENCES groceriesdb.cart(id) ON DELETE CASCADE,
--   FOREIGN KEY (product_id) REFERENCES groceriesdb.product(id) ON DELETE CASCADE
-- );
-- create table groceriesdb.files (
--   id CHAR not null,
--   data blob,
--   file_name varchar(255),
--   file_type varchar(255),
--   is_default boolean not null,
--   product_id CHAR not null,
--   primary key (id),
--   FOREIGN KEY (product_id) REFERENCES groceriesdb.product(id) ON DELETE CASCADE
-- );
-- create table groceriesdb.orders (
--   id CHAR not null,
--   city varchar(50),
--   country varchar(50),
--   last_used boolean,
--   line1 varchar(100),
--   line2 varchar(100),
--   state varchar(50),
--   zip_code varchar(10),
--   comments varchar(255),
--   customer_email varchar(50) not null,
--   customer_name varchar(50) not null,
--   customer_phone varchar(20) not null,
--   delivery_date timestamp,
--   order_date timestamp not null,
--   order_quantity integer,
--   order_status varchar(50),
--   total_price double,
--   customer_id varchar(50) not null,
--   primary key (id)
-- );
-- create table groceriesdb.order_details (
--   quanity integer not null,
--   order_id CHAR not null,
--   product_id CHAR not null,
--   FOREIGN KEY (order_id) REFERENCES groceriesdb.orders(id) ON DELETE CASCADE,
--   FOREIGN KEY (product_id) REFERENCES groceriesdb.product(id) ON DELETE CASCADE,
--   primary key (order_id, product_id)
-- );
-- create table groceriesdb.shipping_address (
--   id CHAR not null,
--   city varchar(50),
--   country varchar(50),
--   last_used boolean,
--   line1 varchar(100),
--   line2 varchar(100),
--   state varchar(50),
--   zip_code varchar(10),
--   user_id varchar(50) not null,
--   primary key (id),
--   FOREIGN KEY (user_id) REFERENCES groceriesdb.users(username) ON DELETE CASCADE
-- );
-- create table groceriesdb.user_profile (
--     cell_phone varchar(50),
--     email_address varchar(50),
--     home_phone varchar(20),
--     first_name varchar(50) NOT NULL,
--     last_name varchar(50) NOT NULL,
--     middle_name varchar(50),
--     username varchar(50) NOT NULL,
--     FOREIGN KEY (username) REFERENCES groceriesdb.users(username) ON DELETE CASCADE
-- );