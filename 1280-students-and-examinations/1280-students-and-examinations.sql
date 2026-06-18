# Write your MySQL query statement below
select s.student_id , s.student_name , sub.subject_name , count(e.subject_name)as attended_exams 
from Students s 
CROSS JOIN Subjects sub
LEFT JOIN Examinations e
on s.student_id=e.student_id
and sub.subject_name=e.subject_name
GROUP BY student_id , student_name , subject_name
ORDER BY  student_id , student_id
