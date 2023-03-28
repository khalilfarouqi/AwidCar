create table if not exists photos (
    id bigserial primary key,
    photo1 varchar(255),
    photo2 varchar(255),
    photo3 varchar(255),
    photo4 varchar(255)
    );
create table if not exists cars (
    id               bigserial primary key,
    air_bag          boolean,
    bluetooth        boolean,
    boot_size        integer,
    brande           varchar(255),
    bris_glace_pneus boolean,
    cdm              boolean,
    consumption      double precision,
    door             integer,
    fuel             varchar(255),
    gear_box         varchar(255),
    hors_power       integer,
    matricule        varchar(255),
    mileage          double precision,
    model            integer,
    name             varchar(255),
    price            double precision,
    protection_vol   boolean,
    rate             double precision,
    respo_civile     boolean,
    seat             integer,
    style            varchar(255),
    photo_id         bigint references photos(id)
    );
create table if not exists users (
    id            bigserial primary key,
    last_check_in timestamp(6),
    pass_word     varchar(255),
    user_name     varchar(255),
    adress        varchar(255),
    roles         varchar(255),
    age           integer,
    cin           varchar(255),
    city          varchar(255),
    country       varchar(255),
    date_creation timestamp(6),
    date_licence  timestamp(6),
    email         varchar(255),
    first_name    varchar(255),
    gender        varchar(255),
    last_name     varchar(255),
    licence       varchar(255),
    tel           varchar(255),
    vol_number    integer
    );
create table if not exists Clients (
    FirstName       varchar(255),
    LastName        varchar(255),
    Gender          varchar(255),
    Age             integer,
    Adress          varchar(255),
    Tel             varchar(255),
    City            varchar(255),
    Tel             varchar(255),
    Country         varchar(255),
    CIN             varchar(255),
    Licence         varchar(255),
    DateLicence     timestamp(6),
    DateCreation    timestamp(6),
    Email           varchar(255),
    isActive         boolean,
    VolNumber       integer
    ) INHERITS (users);
create table if not exists orders (
    id             bigserial primary key,
    booking_city   varchar(255),
    client_age     integer,
    contry         varchar(255),
    end_date       timestamp(6),
    order_status   varchar(255),
    return_city    varchar(255),
    start_date     timestamp(6),
    type_insurance varchar(255),
    isActive         boolean,
    car_id         bigint not null references cars(id),
    user_id        bigint not null references users(id)
    );
create table if not exists notificationGroups (
    id                  bigserial primary key,
    object              varchar(255),
    body                varchar(255),
    notificationType    varchar(255),
    notificationWeb     boolean,
    dateEnvoy           timestamp(6)
    );
create table if not exists notifications (
    id                      bigserial primary key,
    object                  varchar(255),
    body                    varchar(255),
    isRead                  boolean,
    notificationWeb         boolean,
    notificationGroup_id    bigint not null references cars,
    user_id                bigint not null references users
    );
