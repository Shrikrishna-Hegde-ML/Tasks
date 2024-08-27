Callable Statement 
mysql> delimiter //
mysql> create procedure avg_salary()
      ->BEGIN
      ->Select AVG(salary) as avg_salary from Employee;
      ->END//
mysql>delimiter ;
