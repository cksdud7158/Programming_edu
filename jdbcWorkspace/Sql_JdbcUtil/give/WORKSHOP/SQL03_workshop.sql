====================================================================
		SubQuery
=====================================================================
-----------------------SQLD, ADsP, 빅데이터기사자격증 -subquery 
1. 'ACCOUNTING'부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오.

select ename, sal, hiredate, deptno from emp where deptno=(select deptno from  dept where dname='ACCOUNTING');

2. 'TURNER' 와 같은 부서에서 근무하는 직원의 이름과 부서id를 조회하시오.
select ename, deptno from emp where deptno in ( select deptno from emp where ename = 'TURNER' );
select ename, deptno from emp where deptno =(select deptno from emp where ename = 'TURNER');
select ename, deptno from emp where deptno= ANY(select deptno from emp where ename='TURNER');
						
						
3. 10번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서번호, 급여를 조회하시오.
select ename, deptno, sal from emp where sal>(select avg(sal) from emp where deptno=10); 


4.  King에게 보고하는 모든 사원의 이름과 급여를 표시하시오.사원의 이름은 알리야스 직원으로 하시오
select ename , sal from emp where mgr in(select empno from emp where ename='KING');


5. 평균 급여보다 많은 급여를 받고 이름에 u가 포함된 사원과 같은 부서에서 근무하는 모든 사원의 사원 번호, 이름 및 급여를 표시하는 질의를 작성하십시오.
select empno,ename,sal from emp where sal>(select avg(sal) from emp)
and deptno in (select deptno from emp where ename like '%u%');

6. 평균 급여보다 높고 최대 급여보다 낮은 월급을 받는 사원의 정보를조회
select * from emp  where sal>(select avg(sal) from emp) and sal < (select max(sal) from emp);


