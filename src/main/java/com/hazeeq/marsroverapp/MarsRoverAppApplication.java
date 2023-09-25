package com.hazeeq.marsroverapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MarsRoverAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsRoverAppApplication.class, args);
		MarsRoverManager manager = new MarsRoverManager();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("RoverID is automatically assigned.");
				System.out.print("Enter Coordinates, and Direction\ne.g. 3,4,N, f,f,r,f,f\n");
				String input = scanner.nextLine();
				String commandParts[] = input.split(" ");
				String commands = commandParts[1];
				String initialPosition[] = commandParts[0].split("[,]");

				int x = Integer.parseInt(initialPosition[0]);
				int y = Integer.parseInt(initialPosition[1]);
				System.out.println(x +  " " + y);
				String direction = initialPosition[2];

				manager.initializeRover(x, y, direction, commands);

				// Print the final state of the rover(s) or any other desired output
				manager.getAllRoversPosition();
			} catch (Exception e) {
				System.out.println("Invalid input.");
			}
		}
	}
}

