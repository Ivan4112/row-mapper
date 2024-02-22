package com.epam.rd.autocode;

import com.epam.rd.autocode.domain.Employee;
import com.epam.rd.autocode.domain.FullName;
import com.epam.rd.autocode.domain.Position;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RowMapperImpl implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet) {
        Employee employee = null;
        try {
            String id = String.valueOf(resultSet.getLong("ID"));
            String firstName = resultSet.getString("FIRSTNAME");
            String lastName = resultSet.getString("LASTNAME");
            String middleName = resultSet.getString("MIDDLENAME");
            Position position = Position.valueOf(resultSet.getString("POSITION"));
            LocalDate localDate = resultSet.getObject("HIREDATE", LocalDate.class);
            String salary = resultSet.getString("SALARY");

            employee = new Employee(new BigInteger(id),
                    new FullName(firstName, lastName, middleName),
                    position, localDate, new BigDecimal(salary));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }
}
