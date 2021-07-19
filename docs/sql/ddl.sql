create sequence hibernate_sequence start with 1 increment by 1
create table song_project (song_project_id bigint not null, name varchar(255) not null, song_id bigint, time_stamp timestamp not null, track bigint, user_id bigint not null, primary key (song_project_id))
create table song_track (song_track_id bigint not null, end_time timestamp not null, sound_sample_id bigint, start_time timestamp not null, time_stamp timestamp not null, primary key (song_track_id))
create table sound_sample (sound_sample_id bigint not null, sample_file varchar(255) not null, sample_name varchar(255), sample_type integer, time_stamp timestamp not null, primary key (sound_sample_id))
create table user_profile (user_id bigint not null, connected timestamp not null, created timestamp not null, oauth_key varchar(255) not null, user_name varchar(255) not null, primary key (user_id))
create index IDXakmwux4w2swsj69pg3ignha1v on user_profile (created)
create index IDX7amnj5kvh6ct9ihfmqctn97s1 on user_profile (connected)
alter table user_profile add constraint UK_6f815wi5o4jq8p1q1w63o4mhd unique (oauth_key)
alter table user_profile add constraint UK_l6wgfhqrwuy4m1o7bs81ivg6x unique (user_name)
alter table song_project add constraint FKqasm55pjnk3pemeyqnhj7yqg8 foreign key (user_id) references user_profile
create sequence hibernate_sequence start with 1 increment by 1
create table song_project (song_project_id bigint not null, name varchar(255) not null, song_id bigint, time_stamp timestamp not null, track bigint, user_id bigint not null, primary key (song_project_id))
create table song_track (song_track_id bigint not null, end_time timestamp not null, sound_sample_id bigint, start_time timestamp not null, time_stamp timestamp not null, primary key (song_track_id))
create table sound_sample (sound_sample_id bigint not null, sample_file varchar(255) not null, sample_name varchar(255), sample_type integer, time_stamp timestamp not null, primary key (sound_sample_id))
create table user_profile (user_id bigint not null, connected timestamp not null, created timestamp not null, oauth_key varchar(255) not null, user_name varchar(255) not null, primary key (user_id))
create index IDXakmwux4w2swsj69pg3ignha1v on user_profile (created)
create index IDX7amnj5kvh6ct9ihfmqctn97s1 on user_profile (connected)
alter table user_profile add constraint UK_6f815wi5o4jq8p1q1w63o4mhd unique (oauth_key)
alter table user_profile add constraint UK_l6wgfhqrwuy4m1o7bs81ivg6x unique (user_name)
alter table song_project add constraint FKqasm55pjnk3pemeyqnhj7yqg8 foreign key (user_id) references user_profile
create sequence hibernate_sequence start with 1 increment by 1
create table song_project (song_project_id bigint not null, name varchar(255) not null, song_id bigint, time_stamp timestamp not null, track bigint, user_id bigint not null, primary key (song_project_id))
create table song_track (song_track_id bigint not null, end_time timestamp not null, sound_sample_id bigint, start_time timestamp not null, time_stamp timestamp not null, primary key (song_track_id))
create table sound_sample (sound_sample_id bigint not null, sample_file varchar(255) not null, sample_name varchar(255), sample_type integer, time_stamp timestamp not null, primary key (sound_sample_id))
create table user_profile (user_id bigint not null, connected timestamp not null, created timestamp not null, oauth_key varchar(255) not null, user_name varchar(255) not null, primary key (user_id))
create index IDXakmwux4w2swsj69pg3ignha1v on user_profile (created)
create index IDX7amnj5kvh6ct9ihfmqctn97s1 on user_profile (connected)
alter table user_profile add constraint UK_6f815wi5o4jq8p1q1w63o4mhd unique (oauth_key)
alter table user_profile add constraint UK_l6wgfhqrwuy4m1o7bs81ivg6x unique (user_name)
alter table song_project add constraint FKqasm55pjnk3pemeyqnhj7yqg8 foreign key (user_id) references user_profile
