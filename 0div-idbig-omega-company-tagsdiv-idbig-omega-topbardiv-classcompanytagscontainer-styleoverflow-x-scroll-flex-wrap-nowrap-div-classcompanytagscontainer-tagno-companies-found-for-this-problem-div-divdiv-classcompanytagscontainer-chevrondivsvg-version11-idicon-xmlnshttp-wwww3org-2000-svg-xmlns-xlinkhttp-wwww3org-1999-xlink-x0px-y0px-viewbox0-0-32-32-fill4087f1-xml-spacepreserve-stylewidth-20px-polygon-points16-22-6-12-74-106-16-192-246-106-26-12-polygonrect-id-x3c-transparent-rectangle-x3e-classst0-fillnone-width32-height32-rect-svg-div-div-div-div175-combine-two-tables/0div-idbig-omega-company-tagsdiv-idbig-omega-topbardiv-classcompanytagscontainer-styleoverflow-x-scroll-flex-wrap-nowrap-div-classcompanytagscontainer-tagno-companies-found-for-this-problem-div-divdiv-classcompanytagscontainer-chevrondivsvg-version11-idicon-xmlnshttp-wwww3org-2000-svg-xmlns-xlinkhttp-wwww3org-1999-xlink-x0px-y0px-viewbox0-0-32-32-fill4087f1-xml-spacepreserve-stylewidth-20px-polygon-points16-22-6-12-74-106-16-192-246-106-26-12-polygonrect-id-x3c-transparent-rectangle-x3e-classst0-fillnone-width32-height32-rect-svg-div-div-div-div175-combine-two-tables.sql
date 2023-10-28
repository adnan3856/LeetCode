# Write your MySQL query statement below
SELECT P.firstName, P.lastName, A.city, A.state
FROM PERSON P left join ADDRESS A
on P.PERSONID = A.PERSONID;