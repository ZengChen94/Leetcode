# Write your MySQL query statement below
update salary set sex = CHAR(ASCII('f') ^ ASCII('m') ^ ASCII(sex));

#update salary set sex = IF(sex='m', 'f', 'm')