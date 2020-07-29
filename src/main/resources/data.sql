CREATE TABLE users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL,
    is_locked BOOLEAN NOT NULL DEFAULT false,
    is_expired BOOLEAN NOT NULL DEFAULT false
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE,
    CONSTRAINT authorities_idx_1 UNIQUE(username, authority)
);

create table cart (
       id CHAR not null,
        created_at timestamp,
        customer_id varchar(255),
        primary key (id)
);

create table cart_item (
   id CHAR not null,
    quantity double,
    total_price double,
    cart_id CHAR,
    product_id CHAR,
    primary key (id)
);

create table files (
   id varchar(255) not null,
    data blob,
    file_name varchar(255),
    file_type varchar(255),
    is_default boolean not null,
    product_id CHAR not null,
    primary key (id)
);

create table order_details (
   quanity integer not null,
    order_id CHAR not null,
    product_id CHAR not null,
    primary key (order_id, product_id)
);

create table orders (
   	id CHAR not null,
    city varchar(255),
    country varchar(255),
    last_used boolean,
    line1 varchar(255),
    line2 varchar(255),
    state varchar(255),
    zip_code varchar(255),
    comments varchar(255),
    customer_email varchar(255) not null,
    customer_name varchar(255) not null,
    customer_phone varchar(255) not null,
    delivery_date timestamp,
    order_date timestamp not null,
    order_quantity integer,
    order_status varchar(255),
    total_price double,
    customer_id varchar(255) not null,
    primary key (id)
);


create table product (
   	id CHAR not null,
    created_at timestamp,
    description varchar(255),
    name varchar(255),
    price double,
    sku varchar(255),
    stock integer,
    unit double,
    unit_of_measure varchar(255),
    category_id CHAR not null,
    primary key (id)
);

create table product_category (
   id CHAR not null,
    description varchar(255),
    name varchar(255),
    primary key (id)
);

create table shipping_address (
   id CHAR not null,
    city varchar(255),
    country varchar(255),
    last_used boolean,
    line1 varchar(255),
    line2 varchar(255),
    state varchar(255),
    zip_code varchar(255),
    user_id varchar(255) not null,
    primary key (id)
);

create table user_profile (
    cell_phone varchar(255),
    email_address varchar(255),
    home_phone varchar(255),
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    middle_name varchar(255),
    username varchar(255) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);

alter table cart
   add constraint FK9mocisyryuqas1xrlbl8872lb
   foreign key (customer_id)
   references users;


alter table cart_item
   add constraint FK1uobyhgl1wvgt1jpccia8xxs3
   foreign key (cart_id)
   references cart;

alter table cart_item
   add constraint FKjcyd5wv4igqnw413rgxbfu4nv
   foreign key (product_id)
   references product;

alter table files
   add constraint FKqb8swd9nf1l796hkg1fq2urau
   foreign key (product_id)
   references product;

alter table order_details
   add constraint FKjyu2qbqt8gnvno9oe9j2s2ldk
   foreign key (order_id)
   references orders;

alter table order_details
   add constraint FKinivj2k1370kw224lavkm3rqm
   foreign key (product_id)
   references product;

alter table orders
   add constraint FK14n2jkmoyhpimhracvcdy7sst
   foreign key (customer_id)
   references users;

alter table product
   add constraint FK5cypb0k23bovo3rn1a5jqs6j4
   foreign key (category_id)
   references product_category;

alter table shipping_address
   add constraint FKqijab83dlbj00gytfswvh7ri9
   foreign key (user_id)
   references users;