#!/bin/bash
mysql -u root -p HelloMySql<<EOF
show tables;
select * from myclass;
EOF
