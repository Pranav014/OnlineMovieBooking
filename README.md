# Online Movie Booking System

This is a repository for an Online Movie Booking System implemented using Spring Boot, Hibernate, SQL, and utilizing DAO patterns.

## Requirements

- Java 8 or higher
- Apache Maven 3.6.0 or higher
- MySQL 8.0.26 or higher

## Setup

1. Clone the repository to your local machine.
2. Import the project into your preferred IDE.
3. Create a MySQL database named `bookingsystem`.
4. In the `application.properties` file, update the `spring.datasource.username` and `spring.datasource.password` fields with your MySQL credentials.
5. Run the following command to build the project:
   ```
   mvn clean install
   ```
6. Run the following command to start the application:
   ```
   mvn spring-boot:run
   ```

## Endpoints

The following endpoints are available:

- GET `/movie` - Retrieve a list of all movies.
- POST `/movies/add` - Create a new movie.
- PUT `/movies/put/{id}` - Update a movie.
- DELETE `/movies/delete/{id}` - Delete a movie.
- GET `/book` - Retrieve a list of all bookings.
- GET `/bookings/{id}` - Retrieve a specific booking by ID.
- POST `/book` - Create a new booking and generate Ticket.
- PUT `/bookings/{id}` - Update a booking.
- DELETE `/bookings/{id}` - Delete a booking.
- GET `/home` - Displays home page
- GET `/profile` - Displays Profile page with logged in users details
- GET `/admin/dashboard` - Displays a page where admin can perform CRUD operations on MOvie Database
- GET `/login` - Displays a page to enter credentials to Login to site
- POST `/register` - Checks credential and logins the user
- GET `/register` -  Gives  page to signup to website
- POST `/users/add` - Adds a user
- GET `/users/getAll` - retrieves all Users
- DELETE `/user/delete/{id}` - Deletes specific user
- PUT `/users/put/{id}` - Updates Specific User

## License

[MIT](https://github.com/Pranav014/OnlineMovieBooking/blob/main/LICENSE.txt)

