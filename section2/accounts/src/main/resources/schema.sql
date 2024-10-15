create table if not exists `customer`   (
    `customer_id` int auto_increment primary key,
    `name` varchar(100) not null,
    `email` varchar(100) not null,
    `mobile_number` varchar(20) not null,
    `created_dt` date not null,
    `updated_dt` date default null,
    `created_by` varchar(100) not null,
    `updated_by` varchar(100) default null
);

create table if not exists `account`   (
    `customer_id` int not null,
    `account_number` int auto_increment primary key,
    `account_type` varchar(100) not null,
    `branch_address` varchar(200) not null,
    `created_dt` date not null,
    `updated_dt` date default null,
    `created_by` varchar(100) not null,
    `updated_by` varchar(100) default null
);