package org.example.hw2tests;

import org.example.sem2.hw.Car;
import org.example.sem2.hw.Motorcycle;
import org.example.sem2.hw.Vehicle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * c). Написать следующие тесты:
 * - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
 * - проверка того, объект Car создается с 4-мя колесами
 * - проверка того, объект Motorcycle создается с 2-мя колесами
 * - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
 * - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
 * - проверить, что в режиме парковки (сначала testDrive, потом park,
 * т.е эмуляция движения транспорта) машина останавливается (speed = 0)
 * - проверить, что в режиме парковки (сначала testDrive, потом park
 * т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
 */
class VehicleTest {
    private static Car car;
    private static Motorcycle moto;

    @BeforeAll
    public static void init() {
        car = new Car("Volvo", "V90", 2020);
        moto = new Motorcycle("Kolbasaki", "Liver", 2022);
    }

    /**
     * проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
     */
    @Test
    void carIsVehicle() {
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    /**
     * проверка того, объект Car создается с 4-мя колесами
     */
    @Test
    void carWithFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /**
     * проверка того, объект Motorcycle создается с 2-мя колесами
     */
    @Test
    void motoWithTwoWheels() {
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }

    /**
     * проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
     */
    @Test
    void carTestSpeedIs60() {
        car.testDrive();

        assertThat(car.getSpeed()).isEqualTo(60);
    }

    /**
     * проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
     */
    @Test
    void motoTestSpeedIs75() {
        moto.testDrive();

        assertThat(moto.getSpeed()).isEqualTo(75);

    }

    /**
     * проверить, что в режиме парковки (сначала testDrive, потом park,
     * т.е эмуляция движения транспорта) машина останавливается (speed = 0)
     */
    @Test
    void carStopsCorrectly() {
        car.testDrive();
        car.park();

        assertThat(car.getSpeed()).isEqualTo(0);
    }

    /**
     * проверить, что в режиме парковки (сначала testDrive, потом park
     * т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
     */
    @Test
    void motoStopsCorrectly() {
        moto.testDrive();
        moto.park();

        assertThat(moto.getSpeed()).isEqualTo(0);
    }
}