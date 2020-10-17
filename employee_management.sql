create database employee_management;
use employee_management;

# drop table ;

-- -----------------

create table address(   address_id int primary key, address1 varchar(50), address2 varchar(50), city varchar(20) not null, state varchar(2) not null,
						country char(2) not null, zip_code varchar(16));
describe address;

insert into address(address_id, address1, address2, city, state, country, zip_code)
			values('1', '6544SE Main St', 'FL 8', 'San Jose', 'CA', 'US', 95110);
insert into address values('2', '878NE 3rd St', 'UNIT 1', 'Portland', 'OR', 'US', '95110');
insert into address values('3', '34 Mills Rd', 'FL 3', 'Newcastle', 'ME', 'US', '04553');
insert into address values('4', '160 Amphitheatre Pkwy', null, 'Mountain View', 'CA', 'US', '94043');
insert into address values('5', '604 2nd Ave', 'BLDG 1', 'Seattle', 'WA', 'US', '98104');
insert into address values('6', '2502 Folsom St', 'FL 19', 'San Francisco', 'CA', 'US', '94110');
insert into address values('11', '4451SE 11th St', 'APT 4B', 'San Jose', 'CA', 'US', 95110);
insert into address values('12', '343 Main St', 'APT 305', 'San Jose', 'CA', 'US', '95110');
insert into address values('13', '6040 SE Raymond St', null, 'Portland', 'OR', 'US', '97206');
insert into address values('14', '8314 SE 16th Ave', 'APT 27', 'Portland', 'OR', 'US', '97202');
insert into address values('15', '857 Farley St', 'APT 6F', 'Mountain View', 'CA', 'US', '94043');
insert into address values('16', '7955 32nd Ave SW', null, 'Seattle', 'WA', 'US', '98126');

select * from address;

-- -----------------

create table department( department_id int not null primary key, company_name varchar(50), phone varchar(20), budget bigint, address_id int not null unique,
						  foreign key (address_id) references address(address_id));
describe department;

insert into department(department_id, company_name, phone, budget, address_id)
				values('1', 'Software', '334-234-4565', '343646', '1');
insert into department values('2', 'Hardware', '345-345-3672', '3462345', '2');
insert into department values('3', 'HR', '444-356-3345', '23455', '3');
insert into department values('4', 'Design', '223-234-2355', '223429387982', '4');
insert into department values('5', 'Legal', '555-333-6643', '29385', '5');
insert into department values('6', 'Link', '422-234-5235', '9879798', '6');

select * from department;

-- ------------------

create table employee(  employee_id int not null primary key, department_id int not null, foreign key (department_id) references department(department_id),
						first_name varchar(50) not null, last_name varchar(50) not null, age varchar(3) not null, position varchar(50),
                        salary int, email text, phone varchar(20), address_id int not null, foreign key (address_id) references address(address_id));
describe employee;

insert into employee(employee_id, department_id, first_name, last_name, age, position, salary, email, phone, address_id)
				values('1', '1', 'Joe', 'Rock', '55', 'Manager', '30000' , 'Joe.Rock@gmail.com', '345-345-3666', '11');
insert into employee values('2', '1', 'Bob', 'Lip', '23', 'Intern', '70000', 'Bob.Lip@gmail.com', '435-363-4567', '12');
insert into employee values('3', '2', 'Bob', 'Peters', '45', 'Manager', '90000' , 'bpeters@gmail.com', '555-444-5678', '13');
insert into employee values('4', '2', 'Tom', 'Cruise', '56', 'Staff', '43000' , 'TomC@gmail.com', '455-345-6223', '14');
insert into employee values('6', '4', 'Thomas', 'De Leon', '88', 'UX', '120000' , 'DeUX@gmail.com', '422-478-5686', '15');
insert into employee values('5', '5', 'Josh', 'Ember', '90', 'Lawyer', '160000' , 'JoshLaw@gmail.com', '444-333-1234', '16');

select * from employee;

-- -------------------