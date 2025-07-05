# MED-TERM-EXAM PRACTICE

## EX 4

Create a sequence diagram based on the flow that occurs when an actor invokes the reserveRoom method on ReservationForm. You must use correct numbering and activation bars (in the correct way!). You must show all parameters.

```java
public void reserveRoom() {
  reservationController.reserve(selectedRoom, currentGuest);
  displayReservationInfo();
  clearReservationFields();
}

// FROM CLASS ReservationController
public void reserve(Room room, Guest guest) {
  Reservation reservation = guest.createReservation(room);
  double totalCost = calculateCost(reservation);
  room.setReserved(true);
  hotelDB.saveReservation(guest.getID(), reservation);
}
```



**Instructions:**

- Identify all objects involved and the order of method calls.
- Show all parameters in your sequence diagram.
- Use activation bars and proper sequence numbering.

```mermaid
sequenceDiagram
  autonumber

  actor User
  participant form as ReservationForm
  participant controller as ReservationController
  participant guest as Guest
  participant room as Room
  participant db as HotelDB

  %% Step 1: User triggers reservation
  User ->> form: reserveRoom()

  activate form
  form ->> controller: reserve(selectedRoom, currentGuest)

  activate controller
  controller ->> guest: createReservation(room)
  activate guest
  guest -->> controller: Reservation
  deactivate guest

  controller ->> controller: calculateCost(reservation)

  controller ->> room: setReserved(true)
  activate room
  room -->> controller: void
  deactivate room

  controller ->> guest: getID()
  activate guest
  guest -->> controller: guestID
  deactivate guest

  controller ->> db: saveReservation(guestID, reservation)
  activate db
  db -->> controller: void
  deactivate db
  deactivate controller

  form ->> form: displayReservationInfo()
  form ->> form: clearReservationFields()
  deactivate form

```

