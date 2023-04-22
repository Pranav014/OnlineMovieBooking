# OnlineMovieBooking
Movie booking
### Here are the main classes of the Movie Ticket Booking System:

1. **Account**: Admin will be able to add/remove movies and shows, as well as block/unblock accounts. Customers can search for movies and make bookings for shows. FrontDeskOffice can book tickets for movie shows.
2. **Guest**: Guests can search and view movies descriptions. To make a booking for a show they have to become a registered member.
3. **Cinema**: The main part of the organization for which this software has been designed. It has attributes like ‘name’ to distinguish it from other cinemas.
4. **CinemaHall**: Each cinema will have multiple halls containing multiple seats.
5. **City**: Each city can have multiple cinemas.
6. **Movie**: The main entity of the system. Movies have attributes like title, description, language, genre, release date, city name, etc.
7. **Show**: Each movie can have many shows; each show will be played in a cinema hall.
8. **CinemaHallSeat**: Each cinema hall will have many seats.
9. **ShowSeat**: Each ShowSeat will correspond to a movie Show and a CinemaHallSeat. Customers will make a booking against a ShowSeat.
10. **Booking**: A booking is against a movie show and has attributes like a unique booking number, number of seats, and status.
11. **Payment**: Responsible for collecting payments from customers.
12. **Notification**: Will take care of sending notifications to customers.
