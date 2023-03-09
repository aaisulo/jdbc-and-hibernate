package pl.sda.orange2.dao;

import pl.sda.orange2.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao implements DataAccess<Car, Long> {
    //CREATE TABLE CARS (
    //  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    //  COLOUR VARCHAR(255),
    //  BRAND VARCHAR(255),
    //  MODEL VARCHAR(255)
    //)

    // INSERT INTO CARS (COLOUR, BRAND, MODEL) VALUES ('Blue', 'Mazda', 'VI');
    //INSERT INTO CARS (COLOUR, BRAND, MODEL) VALUES  ('Red', 'Toyota', 'Corrolla');

    private final Connection dbConnection;

    public CarDao(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void save(Car car) { // insert i update


    }

    public List<Car> findAll() {
        var cars = new ArrayList<Car>(); // uzyta tylko po to
        // by ja zwrócic gdy odczytamy samochody z bazy

        String allCarsQuery = """
                SELECT ID, COLOUR, BRAND, MODEL
                FROM CARS
                """;

        try {
            Statement queryStatement = dbConnection.createStatement();
            ResultSet queryResult = queryStatement.executeQuery(allCarsQuery);

            while (queryResult.next()) {
                Long id = queryResult.getLong(1);
                String colour = queryResult.getString(2);
                String brand = queryResult.getString(3);
                String model = queryResult.getString(4);

                Car carFromOb = new Car(id, colour, brand, model);
                cars.add(carFromOb);

            }

        } catch (SQLException e) {
            // throw new RuntimeException(e);
            System.out.println("Uneqspected sql exeption occurred");
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        String carByIdQuery = """
                DELETE
                FROM CARS
                WHERE ID = ?
                """;

        try {
            PreparedStatement queryStatement = dbConnection.prepareStatement(carByIdQuery);
            queryStatement.setLong(1, id);
           int numberOfTouchedRecords = queryStatement.executeUpdate();
            System.out.println("Number of touche drecords: \n" + numberOfTouchedRecords);


        } catch (SQLException e) {
            System.out.println("Unexpected sql exception occurred");
            e.printStackTrace();
        }
    }
}

