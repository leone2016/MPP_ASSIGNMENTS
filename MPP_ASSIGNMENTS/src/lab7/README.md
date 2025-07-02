# Lab 7
> Page 230 – 6.7 through 6.19 (time very well spent learning SQL), 6.22 through 6.24

## Simple queries
6.7 List full details of all hotels.

```sql
SELECT * FROM Hotel;
```

6.8 List full details of all hotels in London.

```sql
SELECT * FROM Hotel WHERE City = 'London';
```

6.9 List the names and addresses of all guests living in London, alphabetically ordered by name.

```sql
SELECT GuestName, Address FROM Guest WHERE Address LIKE '%London%' ORDER BY GuestName ASC;

```

6.10 List all double or family rooms with a price below £40.00 per night, in ascending order of price.

```sql
SELECT * FROM Room WHERE (RoomType = 'Double' OR RoomType = 'Family') AND Price < 40.00 ORDER BY Price ASC;
```

6.11 List the bookings for which no dateTo has been specified.

```sql
SELECT * FROM Booking WHERE CheckOutDate IS NULL;
```

## Aggregate functions
6.12 How many hotels are there?

```sql
SELECT COUNT(*) FROM Hotel;
```

6.13 What is the average price of a room?

```sql
SELECT AVG(Price) FROM Room;
```

6.14 What is the total revenue per night from all double rooms?

```sql
SELECT SUM(Price) FROM Room WHERE RoomType = 'Double';
```

6.15 How many different guests have made bookings for August?

```sql
SELECT COUNT(DISTINCT GuestID) FROM Booking WHERE MONTH(CheckInDate) = 8;
```



## Subqueries and joins

6.16 List the price and type of all rooms at the Grosvenor Hotel.

```sql
SELECT Price, RoomType FROM Room WHERE HotelID = (SELECT HotelID FROM Hotel WHERE HotelName = 'Grosvenor Hotel');

```

6.17 List all guests currently staying at the Grosvenor Hotel.

```sql
SELECT g.GuestName
FROM Guest g
JOIN Booking b ON g.GuestID = b.GuestID
WHERE b.HotelID = (SELECT HotelID FROM Hotel WHERE HotelName = 'Grosvenor Hotel')
  AND b.CheckOutDate IS NULL;
```

6.18 List the details of all rooms at the Grosvenor Hotel, including the name of the guest staying in the room, if the
room is occupied.

```sql
SELECT r.*, g.GuestName
FROM Room r
LEFT JOIN Booking b ON r.RoomID = b.RoomID
LEFT JOIN Guest g ON b.GuestID = g.GuestID
WHERE r.HotelID = (SELECT HotelID FROM Hotel WHERE HotelName = 'Grosvenor Hotel')
  AND b.CheckOutDate IS NULL;
```

6.19 What is the total income from bookings for the Grosvenor Hotel today?

```sql
SELECT SUM(r.Price)
FROM Booking b
JOIN Room r ON b.RoomID = r.RoomID
WHERE b.HotelID = (SELECT HotelID FROM Hotel WHERE HotelName = 'Grosvenor Hotel')
  AND DATE(b.CheckInDate) = DATE('now');
```



## Grouping

6.22 List the number of rooms in each hotel.

```sql
SELECT HotelID, COUNT(*) AS NumberOfRooms
FROM Room GROUP BY HotelID;
```

6.23 List the number of rooms in each hotel in London.

```sql
SELECT h.HotelName, COUNT(*) AS NumberOfRooms
FROM Hotel h
JOIN Room r ON h.HotelID = r.HotelID
WHERE h.City = 'London' GROUP BY h.HotelName;
```

6.24 What is the average number of bookings for each hotel in August?

```sql
SELECT h.HotelName, AVG(booking_count) AS AverageBookings
FROM Hotel h
JOIN (SELECT HotelID, COUNT(*) AS booking_count FROM Booking WHERE MONTH(CheckInDate) = '08' GROUP BY HotelID) AS august_bookings ON h.HotelID = august_bookings.HotelID
GROUP BY h.HotelName;
```



