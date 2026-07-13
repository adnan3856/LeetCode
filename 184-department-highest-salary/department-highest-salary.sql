select name as Department,
       ename as Employee, 
       salary as Salary
from (
    select d.name, e.name as ename, e.salary,
    dense_rank() over (partition by E.departmentId order by e.salary desc) as rnk
    from employee e
    left join department d
    on e.departmentId = d.id
)
WHERE RNK = 1