/* Write your PL/SQL query statement below */
select request_at as day, 
round(sum(case when status in ('cancelled_by_driver','cancelled_by_client') then 1 else 0 end)/count(id),2) "cancellation rate"
from trips
where driver_id in(select users_id from users where banned='No')
and client_id in(select users_id from users where banned='No')
and request_at between '2013-10-01' and '2013-10-03'
group by request_at
order by request_at;
