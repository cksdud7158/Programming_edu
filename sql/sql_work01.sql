-- 1. 급여가 1500 이상인 직원들의 이름, 급여, 부서번호를 조회하시오
select ename, sal, deptno from emp where sal>1500;

-- 2. 직원 중에서 연봉이 2000 이상인 직원들의 이름, 연봉을 조회하시오
select ename, sal*12+comm "연봉" from emp where sal*12+comm>2000;

-- 3. 직원 중에서 comm이 없는 직원의 이름과 급여, 업무, comm를 조회하시오
select ename, sal, job from emp where comm is null;

-- 4.입사한지 가장 오래된 직원 순으로 5명을 조회하시오
select ename, hiredate from emp order by hiredate limit 5;

-- 5. 1981년에 입사한 직원들 중에서 급여가 1500 이상 2500 이하인 직원들의 이름, 급여, 부서번호,입사일을 조회하시오
select ename,sal, deptno, hiredate, year(hiredate) 입사년도 from Emp where year(hiredate) =1981 and 
sal>=1500 and sal<=2500; -- -> sal between 1500 and 2500;

-- 6. 이름이 A로 시작하는 직원의 이름, 급여, 입사일을 조회하시오.
select ename, sal, hiredate from emp where ename like 'A%';

-- 7. 05월에 입사한 직원의 이름, 급여, 입사일을 조회하시오
select ename, sal, hiredate from emp where month(HIREDATE)=5;

-- 8. 세 번째 이름에 A 가 들어간 직원의 이름, 급여, 입사일을 조회하시오.
select ename, sal, hiredate from emp where ename like '__A%';

-- 9. 이름이 K로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.
select ename, sal, hiredate from emp where ename like '%K';

-- 10. 커미션을 받는 직원의 이름, 커미션, 급여를 조회하시오.
select ename, comm, sal from emp where comm is not null;




