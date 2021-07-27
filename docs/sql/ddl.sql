create sequence hibernate_sequence start with 1 increment by 1;

create table project
(
    project_id bigint       not null,
    created    timestamp    not null,
    name       varchar(255) not null,
    creator_id bigint       not null,
    primary key (project_id)
);

create table sample
(
    sample_id bigint       not null,
    created   timestamp    not null,
    file      varchar(255) not null,
    name      varchar(255) not null,
    type      integer      not null,
    primary key (sample_id)
);

create table sample_track
(
    sample_id bigint not null,
    track_id  bigint not null
);

create table track
(
    track_id   bigint    not null,
    created    timestamp not null,
    creator_id bigint    not null,
    project_id bigint    not null,
    primary key (track_id)
);

create table user_profile
(
    user_id   bigint       not null,
    connected timestamp    not null,
    created   timestamp    not null,
    oauth_key varchar(255) not null,
    user_name varchar(255) not null,
    primary key (user_id)
);

create index IDXakmwux4w2swsj69pg3ignha1v on user_profile (created);

create index IDX7amnj5kvh6ct9ihfmqctn97s1 on user_profile (connected);

alter table user_profile
    add constraint UK_6f815wi5o4jq8p1q1w63o4mhd unique (oauth_key);

alter table user_profile
    add constraint UK_l6wgfhqrwuy4m1o7bs81ivg6x unique (user_name);

alter table project
    add constraint FKe3bhqhfjvvnskfbp586tbsuhn foreign key (creator_id) references user_profile;

alter table sample_track
    add constraint FK44sltppjj6w3k20j3dbxam2r8 foreign key (track_id) references track;

alter table sample_track
    add constraint FKs9mr84aiw33qgpp6prw11pnu1 foreign key (sample_id) references sample;

alter table track
    add constraint FKmgahp5fisbacgqhiahqwm1uom foreign key (creator_id) references user_profile;

alter table track
    add constraint FKoaqblypih2vik49ss6ttmxxpl foreign key (project_id) references project;

