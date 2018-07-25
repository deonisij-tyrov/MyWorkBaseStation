create table BASE_STATION
(
  ID   int(5)   not null,
  NAME char(10) not null
  constraint `PRIMARY`
  primary key
);

create table CELL
(
  ID        int      not null
  constraint `PRIMARY`
  primary key,
  CELL_NAME char(10) not null,
  SECTOR    int      not null,
  POWER_ID  int(3)   null,
  BS_ID     int(5)   not null,
  BAND_ID   int(2)   not null
);

create table user
(
  USER_ID  int(10) auto_increment
  constraint `PRIMARY`
  primary key,
  NAME     varchar(20)               null,
  LOGIN    varchar(20)               not null,
  PASSWORD varchar(25)               not null,
  BIRTHDAY date                      null,
  STATUS   char(10) default 'ACTIVE' not null,
  ROLE     char(5) default 'USER'    not null,
  constraint USER_LOGIN_uindex
  unique (LOGIN)
);
