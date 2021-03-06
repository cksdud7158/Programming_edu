select * from emp;
select * from dept;
/* 간단한 데이타 타입 정리
-----------------------정수
tinyint		아주 작은 범위의 정수 		-128~127(0~255)
smallint	작은 범위의 정수			-32768~32768(0~65535)
int									-20억~+20억
decimal		고정소수					전체 자리수와 소수점 자리를 가진다.
			decimal(5,1)
-----------------------문자
char(3)		고정형
varchar(20) 문자수가 최대 n개인 문자열
text 		문자수가 최대 65535개인 문자열

------------ 날짜
date 		년, 월, 일
datetime	년, 월, 일, 시, 분, 초
*/
   
-- [1. Projection | Selection]
-- Projection : 컬럼명을 지정해서 데이타를 가져오는 쿼리문
select * from emp;
select empno, ename, job, deptno from emp;

-- emp 테이블에서 모든 사원의 이름과 입사일을 검색
select ename,hiredate from emp;

-- emp 테이블에서 부서 번호만 검색, 중복 제외 키워드(distinct)사용, 위치 select 바로 다음에 온다.
select distinct deptno from emp; -- 정렬이 안되서 출력

-- 정렬은 오름차순(ASC, 기본)| 내림차순(DESC)
select distinct deptno from emp order by deptno ASC;
select distinct deptno from emp order by deptno ; -- 정렬의 기본은 ASC이기에 안해도 나옴 

-- 사원 중에서 입사일이 가장 빠른 사원순으로 출력.. (가장 빠른 사원이 가장 먼저 나오도록)
select ename, hiredate from emp order by hiredate ;

-- 사원중에서 월급을 가장 많이 받는 사원순으로 검색되도록
select ename, job, sal from emp order by sal desc;

-- 사원 중 가장 입사일이 빠른 2명만 출력, limit
select ename, job, hiredate from emp order by HIREDATE desc limit 0,2;
/*
limit
::
출력하는 라인수를 제한 
limit 0,2 (시작은 0부터 2개만 출력) 
limit 3 ( 시작은 0 부터 3개만 출력)
*/

-- selection : 해당하는 조건을 만족하는 행을 검색
select * from emp where deptno=10;

-- emp 테이블에서 업무가 salesman 인 사원의 이름, 급여, 연봉을 검색
select ename, sal, sal*12+COMM from emp where job= 'SALESMAN';

-- Alias (별칭) 지정하는 방법 -- 1) 컬럼명 as Alias, 2) 컬럼명 Alias, 3)컬럼명 "Alias"
-- Alias 로 정렬은 먹힘, ""안에서는 안먹힘 
select ename, sal, sal*12+comm as AnnualSalary from emp where job= 'SALESMAN';
select ename, sal, sal*12+comm AnnualSalary from emp where job= 'SALESMAN';
select ename, sal, sal*12+comm 일년_총급여 from emp where job= 'SALESMAN';
select ename, sal, sal*12+comm "일년총급여" from emp where job= 'SALESMAN';
select ename, sal, sal*12+comm "일년 총급여" from emp where job= 'SALESMAN' order by sal*12+comm;
select ename, sal, sal*12+comm "일년 총급여" from emp where job= 'SALESMAN' order by "일년 총급여"; -- 이렇게는 안됨
select ename, sal, sal*12+comm AnnualSalary 
from emp 
where job= 'SALESMAN' 
order by AnnualSalary;

/*
-문법 순서-
SELECT		- 1
FROM		- 2
WHERE		- 3
GROUP BY	- 4
HAVING		- 5
ORDER BY 	- 6

-실행 순서-
FROM		- 1
WHERE		- 2
GROUP BY	- 3
HAVING		- 4
SELECT		- 5
ORDER BY	- 6
*/
-- emp 테이블에서 모든 사원의 이름, 급여, 연봉을 검색
-- null 값은 나름의 의미를 가지지만 **연산이 안된다.
-- 따라서 comm이 null일 경우 연산할 때 0으로 치환해야한다. 
-- sql에서 null값을 다루는게 가장 어렵다. 
select ename, sal, sal*12+comm "연봉"  from emp 
order by sal*12+comm;
/*
ifnull(comm,0)
::
comm이 null 이면 0으로
comm이 null이 아니면 comm으로
*/
select ename, sal, sal*12+ifnull(comm,0) "연봉"  from emp 
order by sal*12+comm;

-- comm이 null 인사원들의 이름, 업무, 급여, comm을 검색
-- null은 비교연산이 안됨 
select ename, job, sal, comm from emp where comm is null;
select ename, job, sal, comm from emp where comm is not null;-- null이 아닌 

-- 상사 번호만 출력
-- null은 제일 작은 값
select distinct (mgr) 상사번호 from emp order by mgr desc;
/*
NUll 값에 대하여alter
::
1) 자격없음
2) 미확정
::
1) 사칙연산 적용 안됨 Ifnull()을 사용하여 다른 값으로 치환해야함
2) 비교연산 적용안됨 is 혹은 is not
3) MySQL에서는 null값을 가장 작은 값으로 지정(Oracle에서는 반대 )

*/

-- [2. 함수 -날짜관련 함ㅅ - year(날짜) | Month(날짜)]
-- emp 사원중에서 81년도에 입사한 사원들의 정보를 디스플레이 
select * from emp;
select ename, hiredate, year(hiredate) 입사년도 from Emp;
select ename, hiredate, month(hiredate) 입사월 from Emp where month(hiredate) =5;

-- [3. like 연산자와 와이드카드 % _]
-- 사원의 이름 중에서 A라는 이름이 들어가있는 사원을 검색할 때 like 연산자와 와이들카드를 같이 써야함
select ename, job, deptno
from emp
where ename like 'A'; 

select ename, job, deptno
from emp
where ename like '%A%';

select ename, job, deptno
from emp
where ename like '_A%'; -- '_' 는 한문자와 랩핑됨
-- 사원중 마지막 철자가 G로 끝나는 사원을 검색
select ename, job, deptno
from emp
where ename like '%G';


-- 1. 문자관련 함수 : concat(), substr()
select concat(ename,' is a ' ,job) message from emp;
select ename, substr(hiredate, 1,4) 년도, hiredate  from emp;
select ename, substr(hiredate,6,2) 월 from emp;
select ename, substr(hiredate,9,2) 일 from emp;

select ename, year(hiredate) 년도, month(hiredate) 월 from emp;
select hiredate from emp;

-- 2. 숫자관련함수 : abs(), mod(분자, 분모)= 나머지, round(숫자, 자릿수)= 반올림, celling(숫자)= 올림, floor()=내림, truncate(숫자 자릿수)=내림
-- Blake 와 Smith의 월급의 차이를 검색
select distinct abs((select sal from emp where ename='smith')-(select sal from emp where ename= 'blake'))
월급차이
from emp;

-- 사원번호가 홀수인 사원의 정보를 검색 mod()
select empno, ename from emp where mod(empno,2)=1; 

-- 업무가 salesman인 모든 사원에 대해서 comm에 대한 급여 비율의 나머지를 검색
select ename, sal, comm, mod(sal,comm) "급여 비율의 나머지" from emp 
where job='salesman';

 select round(45.922,2);
 select round(45.922); -- ==  select round(45.922,0);
 select round(45.922,-1);
 
 -- select floor(45.922,3); 자릿수 지정 안됨
 select floor(45.922);
 
 select truncate(45.922,2);
 select truncate(45.922,0); 
select truncate(45.922); -- 자릿수를 지정 안하면 안됨

-- 3. 날짜 관련 함수
select now();
select sysdate();
select curdate();
select current_time();

-- 막내 오세훈이 오늘까지 살아온 일수를 구하세요 : 변환 함수
select (curdate()-(1997-6-19)); -- 안됨
select (curdate() - str_to_date('1997-6-19','%Y-%m-%d')); -- 안됨
select datediff(curdate(),'1997-6-19');

-- emp 테이블에서 모든 사원들이 지금까지 근무한 일수
select ename, datediff(curdate(), hiredate) 근무일수 from emp;

-- emp 테이블에서 모든 사원드이 근무한 weeks

select ename, floor(datediff(curdate(), hiredate)/7) weeks from emp;

-- 오늘부터 그녀를 만난지 100째 되는 날을 검색
select date_add(curdate(), interval 100 day);

-- 날짜 - 날짜 = 일수
-- 날짜 + 숫자 = 날짜  | 날짜 - 숫자 = 날짜

-- 4. 그룹 함수 : count(), sum(), avg(), max, min()
select count(*) from emp; -- 기본키가 가진 모든 raw 수
select count(-1) from emp; 
select count(empno) from emp; 
select count(mgr) from emp; -- null값은 그룹함수 수에서 제외됨

select min(hiredate) from emp; -- 가장 빠른 입사일
select max(hiredate) from emp; -- 가장 최근 입사일

select sum(sal) 사원총급여 from emp;
select round(avg(sal)) 사원평균급여 from emp;

-- 업무가 manager인 사원의 퍙균 급여를 검색
select round(avg(sal)) from emp where job='manager';
-- 모든 사원의 보너스의 평균을 검색
select round(avg(ifnull(comm,0))) from emp ;
-- 사원 테이블에서 모든 부서의 갯수를 출력 
select count(distinct(deptno)) from emp;

-- 부서 번호가 10번이거나 20번인 사원의 인원수 
select count(deptno) from emp where deptno= 10 or deptno =20;

select * from emp where empno in(10);

-- 부서 번호가 10번이거나 20번이 아닌 사원의 인원수 
select count(deptno) from emp where deptno!= 10 and deptno !=20;
select count(deptno) from emp where deptno not in(10,20);
-- 각부서의 평균 급여를 검색 avg() 
-- 그룹함수의 적용되지 않은 컬럼이 select절에 나열되면 반드시 group by 절 뒤에 명시해줘야한다. 
select deptno, avg(sal) from emp;
select deptno, round(avg(sal)) from emp group by deptno;

-- 부서별 급여의 총합
select deptno, round(sum(sal)) from emp group by deptno;

-- 입사년도별 사원의 인원수를 출력  count 출력
select year(hiredate) 입사년도, count(*) 인원수 from emp group by year(hiredate);
select year(hiredate) 입사년도, count(*) 인원수 from emp group by 입사년도;

-- 부서별 평균 급여를 구하는데 20번 부서는 제외하고 구하세요
select deptno, round(avg(sal)) from emp where DEPTNO != 20 group by deptno order by deptno;
-- 부서별 평균 급여가 2000 달러 이상인 부서의 부서번호와 평균 급여를 구하세요
-- where 절에서는 그룹함수를 못쓴다, -> 실행 순서상의 문제로
-- 그룹핑하기전에 where에서 거름, 그룹핑하기전 추려서 출력시 having을 사용
select deptno, round(avg(sal)) from emp 
group by deptno
having round(avg(sal))>=2000 
order by deptno;

-- 부서별 평균 급여가 2000 달러 이상인 부서의ㅏ 부서번호와 평균 급여를 구하세요
-- 이때 단 10 번부서는 제외합니다. 
select deptno, round(avg(sal)) from emp 
where deptno != 10
group by deptno
having round(avg(sal))>=2000 
order by deptno;

/*

*/
show databases;
use scott;
/*
- 테이블 생성
create table myTable(
    -> id tinyint not null,
    -> name varchar(10),
    -> addr varchar(50),
    -> birthDate date);
- 값 주입(columm)    
Insert Into myTable(id, name,addr, birthDate) values(1,'박찬영','서초동', '1989-02-11');
Insert Into myTable(id, name,addr, birthDate) values(2,'아이유','장안동', curdate());
- 테이블 값 삭제 (columm)
delete from myTable; // 모든행 삭제
delete from myTable where id=1;
- 테이블 컬럼값 수정
update myTab set 수정할 컴럼명 = 값 이 들어감 where id=1;

*/

show databases;
drop table mytable;
create table mytable(
	id tinyint not null,
    name varchar(10),
    addr varchar(50),
    birthdate date);
desc mytable;
insert into mytable(id,name,addr,birthdate) values(1,'아이유', '장안동',curdate());
select * from mytable;
delete from mytable where id=1;
update mytable set addr='소초구' where id=1;

create table test01(
	num int auto_increment primary key,
    name varchar(20),
    age tinyint,
    height decimal(5,1),
    birthday datetime,
    hiredate date);
desc test01;
-- 데이타 추가하기 
insert into test01(name,age, height,birthday,hiredate) values('홍길동',29,179.5,now(),now());
insert into test01(name,age, height,birthday,hiredate) values('김준현',30,180.5,now(),now());
insert into test01(name,age, height,birthday,hiredate) values('이영자',50,190.5,now(),now());
insert into test01(name,age, height,birthday,hiredate) values('야야야',20,190.5,now(),now());

select * from test01;
-- 컬렴명 변경 : alter
alter table test01 change birthday birthdate datetime;
-- 컬럼 데이타 타입 변경하기 
alter table test01 change birthdate birthdate date;

-- num이 3번인 데이타를 삭제
delete from test01 where num=3;
-- num이 2번인 데이타의 키와 나이를 수정 
-- 기본키는 update의 대상이 아니다. 기본키를 제외한 나머지 컬럼들만 수정의 대상 
update test01 set height='150', age='10' where num=2;

/*
delete from test01;			- 테이블 구조는 남음
truncate table test01; 		- 통쨰로 삭제해버림, delete 는 한줄씩 지움
drop table test01;			-

SQL
::
DM (Manupulation)L - insert, update, delete
DD(define)L - create, drop, alter

*/

-- Sub Query----------------------------------------
/*
1. 서브 쿼리는 반드시 ()로 쌓여져야한다. 
2. 서브쿼리가 먼저 돌아간 결과값을 가지고 메인쿼리가 실행된다.
3. 서브쿼리는 ?에 해당하는 것을 먼저 해결할 때 사용한다. 
4. 서브쿼리는 from절 뒤 | where절 뒤 | having절 뒤 --3가지 유형으로 나뉜다. 
5. 단일행 서브쿼리  + 단일행 연산자와 사용됨  | 다중행 서브쿼리 + 다중행 연산자 
	스칼라 서브쿼리 - 1 row 1 colum
  서브 쿼리에 order by절을 사용할 필요가 없다. 
	
*/
 
-- CLARK의 급여보다 더 많은 급여를 받는 사원을 검색하세요 
select sal from emp where ename='CLARK';
select ename, sal from emp where sal>2450;

select ename, sal from emp where sal>(select sal from emp where ename='CLARK'); -- MainQuery(SubQuery)

-- 급여를 가장 많이 받는 사원 을 5명 검색
select * from emp order by sal desc limit 5;

-- ename이 KING인 사원과 같은 부서에서 근무하는 사원을 검색 
select * from emp where deptno = (select deptno from emp where ename='king');

-- 10번 부서에서 근무하는 사원 중에서 사원 전체의 평균 급여보다 더 많은 급여를 받는 사원을 검색 
select avg(sal) from emp; -- ?에 해당하는 쿼리 
select * from emp where deptno= 10 and
sal>(select avg(sal) from emp);

-- job별 가장 적은 평균급여를 검색 -- ?는 
select job, avg(sal) from emp group by job; -- 이중에서 가장 작은 적은 평균 급여는 1037.5
select job, MIN(avg(sal)) from emp group by job; -- 실행 안됨, MySQL에선 그룹함수 중첩이 안된다. 오라클 경우와 다르다. 

select job, avg(sal) from emp group by job
having avg(sal)=(select job, MIN(avg(sal)) from emp group by job); -- 실행 안됨, MySQL에선 그룹함수 중첩이 안된다. 오라클 경우와 다르다. 

select job, avg(sal) from emp group by job order by avg(sal) limit 1;

-- scott의 급여보다 더 많은 급여를 받는 사원을 검색 ( 테이블 알리야스를 사용하는 방법을 추가) 
-- 1) 
select * from emp where sal>(select sal from emp where ename= 'scott');
-- 2)
select * from emp a, (select sal from emp where ename= 'scott') b
where a.sal > b.sal;

-- 직속 상관이 King인 사원의 이름과 급여를 검색
select * from emp where mgr=(select empno from emp where ename='king');

-- job이 사원 7369의 업무와 같고, 급여가 사원 7876보다 많은 사원을 검색
select * from emp where job=(select job from emp where empno=7369)
and sal>(select sal from emp where empno= 7876);

-- 부서별 최소급여 중에서 20번 부서의 최소 급여보다 더 큰 최소급여를 검색 (?는 20번 부서의 최소 급여)
select deptno, min(sal) from emp 
group by deptno
having min(sal)> (select min(sal) from emp where deptno=20);

-- 부서별 최소 급여와 같은 급여를 가지는 사원을 검색  ( ? 는 부서별 최소급여)
select * from emp where sal in (select min(sal) from emp group by deptno); -- 다중 행 연산자 in 사용

-- 급여를 3000 이상 받는 사원이 소속된 부서와 동일한 부서에 근무하는 사원을 검색 (? 는 급여를 3000 이상 받는 사원이 소속된 부서)
select distinct * from emp where deptno in (select distinct deptno from emp where sal>=3000);
/*
in - A or B or c -> 여러개 중에서 같은 값을 찾음
any	- 메인 쿼리의 비교 조건이 서브쿼리 검색 결과와 하나 이상만 일치하면 참이됨
all  - 메인 쿼리의 비교 조건이 서브쿼리 검색 결과와 모두 일치하면 참이됨
*/


-- 급여가 어떤 점원(clerk)보다 작으면서 clerk이 아닌 사원을 검색
-- 1
-- any 사용
select sal from emp where job= 'clerk';
-- 2)
select * from emp 
where sal < any ( select sal from emp where job= 'clerk')
and
job <> 'clerk'; -- !=

-- 급여가 모든 부서의 평균보다 많은 사원을 검색 ( ? 부서별 평균)
select avg(sal) from emp group by deptno;
select * from emp where sal > all(select avg(sal) from emp group by deptno);

-- Q1
-- 급여가 10번 부서에 속한 어떤 사원의 급여보다 더 많은 급여를 받는 사원을 검색. 이떄 10 번 부서에 속한 사원은 제외 
-- 정렬은 사원 번호순으로 한다.
select min(sal) from emp where deptno=10; 
select * from emp where sal > any (select sal from emp where deptno=10) and deptno <> 10
order by empno;
-- Q2
-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 검색하세요 
select max(sal) from emp where deptno=30;
select deptno ,max(sal) from emp 
group by deptno
having deptno = 30
;

select ename, sal, deptno from emp
where sal >(select max(sal) from emp 
group by deptno
having deptno = 30);
select * from emp;
-- 부하직원을 거느린 사원을 검색 == empno가 mgr에 있는 사원
select distinct mgr from emp;
select * from emp where empno in ( select mgr from emp);

select e.ename 상사이름, e.empno 상사의사원번호 from emp e
where e.empno in (select m.mgr from emp m);

-- 부하직원을 거느리지않은 사원을 검색 == empno가 mgr에 없는 사원 not in 사용
select * from emp where empno not in (select mgr from emp); -- 값이 안나옴, null값 때문
-- 2) 서브 쿼리에서 null값을 핸들링하는 문제가 가장 어려운 문제로 취급됨.
select * from emp where empno not in (select ifnull(mgr,0) from emp);



select * from cust;
select * from cust where id='1' and pass= '1234';

-- Join ----------------------------------------------------------------------------------------------
select * from emp;
select distinct deptno from emp;
select * from dept;

-- 특정 사원인 소속된 부서의 정보의 정보를 검색( 사원의 정보 + 부서의 정보)
select * from emp, dept;
/*
Cartesian Product
단순 데이타의 곱으로 결과를 산출하는 방식
14*4 =56
Cartesian Product가 도출되는 경우
1) 조인 조건을 안줬거나
2) 조인 조건을 잘못 줬거나 

join 조건 부여하는 방법 
1) where 절을 이용해서 각각 테이블에서의 공통의 컬럼을 명시한다. 
2) whwere emp.deptno =dept.detno

*/
-- 1) 컬럼명을 일일이 명시해야한다. 불필요한 컬럼이 출력되는 것을 방지한다.
select * from emp, dept where emp.deptno= dept.DEPTNO;

-- 2) deptno 가 양쪽 테이블에 존재하기떄문에 어디에서 가져올지 정확히 명시해야한다. 
-- 컬럼명 앞에 table alias를 부여한다.
select empno, ename, sal, deptno, dname, loc 
from emp, dept 
where emp.deptno= dept.DEPTNO;

-- 3) 컬럼명 앞에 테이블 명을 일일히 붙이는 것이 매우 번거로움
select emp.empno, emp.ename, emp.sal, emp.deptno, dept.dname, dept.loc 
from emp, dept 
where emp.deptno= dept.DEPTNO;

-- 4)
select e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc 
from emp e, dept d  
where e.deptno= d.DEPTNO;

-- 사원의 이름, 급여, 부서번호, 부서명을 검색. 단 급여가 2000이상이고 30번 부서에 한해서만
-- where 절에서 조인 조건과 함께 비조인 조건이 쓰인다. 
select e.ename, e.sal, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno and e.sal>2000 and e.deptno=30;

select empno, ename, mgr from emp where ename='blake'; -- e
select empno,ename from emp where empno= 7839; -- m

-- BLAKE 라는 사원의 상사의 이름을 검색.. 사원번호, 사원 이름, 상사번호 , 상사 이름 
-- 특정 사원의 상사 이름을 검색 
-- 1)
select empno, enmae, mgr from emp; -- 해당사원의 상사번호를 검색 
select empno, ename from emp; -- 위의 상사번호가 사원 번호인 사람의 이름을 검색 

-- 2)
select * from (select empno, ename, mgr from emp) e, (select empno, ename from emp) m
where e.mgr = m.empno;

-- 3)
select * from (select empno, ename, mgr from emp where ename= 'blake') e, (select empno, ename from emp) m
where e.mgr = m.empno;

-- OUTER JOIN -----------------------------------------------
/*
 A,B 테이블을 조인할 경우, 조건에 맞지않는 데이타는 디스플레이 되지않는데 
 이 경우도 디스플레이 하고 싶을 때 outer join을 사용한다. 
 
 OUTER JOIN 종류
 1) LEFT OuTER JOIN 2) RIGHT OUTER JOIN 3) FULL OUTER JOIN
 (데이타가 어느쪽에 있는가에 따라서 종류의 이름이 정해짐 )
 
*/
-- 사원의 이름, 부서번호, 부서 이름 검색 
select e.ename, e.deptno, d.dname from emp e, dept d where e.deptno= d.deptno ;

-- 1) 위 경우에 right outer join을 사용
-- 조인 수행시 우측테이블이 기준이 되어서 결과를 생산하도록 해준다. 

select e.ename, e.deptno, d.dname 
from emp e right outer join dept d on e.deptno= d.deptno ;
-- left outer join을 사용
select e.ename, e.deptno, d.dname 
from emp e left outer join dept d on e.deptno= d.deptno ;

-- 특정 사원의 상사 이름을 검색 ... 13줄 검색
/*
self 조인의 결과 king의 사원 정보가 빠져있다. 
king의 상사번호는 null이기때문

*/
select concat(e.ename, '의 매니저는', m.ename,'입니다.') info
from emp e right outer join emp m 
on e.mgr = m.empno;

select concat(e.ename, '의 매니저는', m.ename,'입니다.') info
from emp e left outer join emp m 
on e.mgr = m.empno;

-- A 10,20, 30 full outer join  B 10, 20, 40 -- 10,20, 30, 40 도출됨 
-- full outer join 이 실행되지않음으로 union 연산자를 mysql에서 사용해야 한다. 
create table outer1(sawonid int);
create table outer2(sawonid int);

insert into outer1 value(10);
insert into outer1 value(20);
insert into outer1 value(40);

insert into outer2 value(10);
insert into outer2 value(20);
insert into outer2 value(30);

select * from outer1;
select * from outer2;

-- full outer join 
select sawonid from outer1 union select sawonid from outer2;

select * from customer ;
select * from stock;
select * from shares, stock;

insert into shares(ssn,symbol,quantity) values('1234','sunw',10);
select * from shares where ssn='1234';


update customer set cust_name='박찬영', address= '사가정' where ssn='1234';

delete from shares where ssn='1234' and symbol= 'duke';
insert into shares values('111-111', 'jdk', 300);

-- 포렌키 넣는 방법
alter table shares add constraint fk_shares_ssn foreign key(ssn) references customer(ssn);
/* 포렌을 주지 않으면 일일이 다 삭제해야함 
자식(포렌키를 가진)을 가진 부모의 경우 삭제가 되지않음
따라서 자식을 먼저 삭제하고 부모를 삭제하면됨 or 자식의 값을 다 null값으로 바꾸고 부모를 죽음  
*/
select * from customer;

/*
mySql 분석 함수 
- 순위 함수 : rank, dense_rank,row_number, ntitle
- 집계 함수(그룹 함수) : sum, min, max, avg, count
- 기타 함수 : lead, lag, first_value, last_value, ratio_to_report(Maria DB 지원 안됨 
*/

-- rank 
-- order by 절을 포함한 쿼리문에서 특정한 항목에 대한 순위를 지정할 때 사용하는 함수 
select empno, ename, deptno, sal,
rank() over(order by sal desc ) 급여순위
from emp;
-- dense_rank ------- 차이 확인 3,3 4/ rank의 경우 3,3 5
-- rank 함수와 흡사하지만, 동일한 순위를 하나의 건수로 취급하는 것이 차이 
select empno, ename, deptno, sal,
dense_rank() over(order by sal desc) 급여순위
from emp;
-- ntile 특정 숫자만큼 나눠줌
select empno, ename, deptno, sal,
ntile(10) over(order by sal desc) 소득등급
from emp;

-- row_number : 일련번호 출력
select empno, ename, hiredate,
row_number() over() Numbering from emp; -- where numbering =2 는 안됨 where에 알리야스 못옴
select empno, ename, hiredate,
row_number() over() Numbering from emp limit 2;

select empno, ename, hiredate,
row_number() over(order by hiredate) Numbering from emp limit 2;
-- sum()
select empno, ename, sal, hiredate, deptno,
sum(sal) over() 총급여,
sum(sal) over(partition by deptno) 부서별총급여
from emp
order by 부서별총급여;

select empno, ename, sal,
avg(sal) over(partition by job) 업무별_평균급여,
max(sal) over(partition by job) 업무별_최대급여
from emp;

create table encore(no int primary key auto_increment, name varchar(30));
desc encore;
insert into encore values('박찬영'); --  이렇게 쓰면 안됨
insert into encore(name) values('설경구');
select * from encore;
delete from encore where no =3;
drop table encore;

create table bank(id varchar(20) primary key, name varchar(30), bankname varchar(30), balance int(10));
desc bank;
insert into bank(id, name, bankname, balance) values('111', '윤아', '신한은행', 1000000);
insert into bank(id, name, bankname, balance) values('222', '승기', '국민은행', 2000000);





























































