====================================================================
		SubQuery
=====================================================================
-----------------------SQLD, ADsP, �����ͱ���ڰ��� -subquery 
1. 'ACCOUNTING'�μ����� �ٹ��ϴ� �������� �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.

select ename, sal, hiredate, deptno from emp where deptno=(select deptno from  dept where dname='ACCOUNTING');

2. 'TURNER' �� ���� �μ����� �ٹ��ϴ� ������ �̸��� �μ�id�� ��ȸ�Ͻÿ�.
select ename, deptno from emp where deptno in ( select deptno from emp where ename = 'TURNER' );
select ename, deptno from emp where deptno =(select deptno from emp where ename = 'TURNER');
select ename, deptno from emp where deptno= ANY(select deptno from emp where ename='TURNER');
						
						
3. 10���μ��� ��ձ޿����� ���� �޿��� �޴� ������ �̸�, �μ���ȣ, �޿��� ��ȸ�Ͻÿ�.
select ename, deptno, sal from emp where sal>(select avg(sal) from emp where deptno=10); 


4.  King���� �����ϴ� ��� ����� �̸��� �޿��� ǥ���Ͻÿ�.����� �̸��� �˸��߽� �������� �Ͻÿ�
select ename , sal from emp where mgr in(select empno from emp where ename='KING');


5. ��� �޿����� ���� �޿��� �ް� �̸��� u�� ���Ե� ����� ���� �μ����� �ٹ��ϴ� ��� ����� ��� ��ȣ, �̸� �� �޿��� ǥ���ϴ� ���Ǹ� �ۼ��Ͻʽÿ�.
select empno,ename,sal from emp where sal>(select avg(sal) from emp)
and deptno in (select deptno from emp where ename like '%u%');

6. ��� �޿����� ���� �ִ� �޿����� ���� ������ �޴� ����� ��������ȸ
select * from emp  where sal>(select avg(sal) from emp) and sal < (select max(sal) from emp);


