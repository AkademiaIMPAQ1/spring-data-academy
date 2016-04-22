insert into USER (ID, LOGIN, EMAIL, ACTIVE) values (1, 'wacek', 'wacek@o2.pl', true);
insert into USER (ID, LOGIN, EMAIL, ACTIVE) values (2, 'jacek', 'jacek@o2.pl', true);
insert into USER (ID, LOGIN, EMAIL, ACTIVE) values (3, 'placek', 'placek@o2.pl', false);

insert into POST (ID, TITLE, CONTENT, CREATION_DATE, USER_ID, POSTS_ID) values (1, 'ocena', 'dobry artykuł', '2016-04-20 12:59:52.793', 1, 1);
insert into POST (ID, TITLE, CONTENT, CREATION_DATE, USER_ID, POSTS_ID) values (2, null, 'nie zgadzam się z Tobą', '2016-04-20 18:59:52.793', 1, 2);