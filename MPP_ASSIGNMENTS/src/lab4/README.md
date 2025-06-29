# Lab 4



#### A.  Re-draw the diagram so that it follows UML synatx rules. 

Considered points: 

* Include message numbering 
* Use proper UML syntax for the objects displayed at the top. 
* Indicate looping wherever it occurs with Iteration markers 

![](lab4_2.png)

#### **B**. Create a sequence diagram based on the flow that occurs when an actor invokes the checkoutBook() method on CheckoutForm

```mermaid
sequenceDiagram
    actor User
    participant CheckoutForm
    participant CheckoutController
    participant CheckoutRecord
    participant LibraryMember
    participant ILibraryDBSubsystem

    User ->> CheckoutForm: 1. checkoutBook()

    CheckoutForm ->> CheckoutController: 2. checkoutBook(m_book, m_member)

    CheckoutController ->> CheckoutRecord: 3. create new CheckoutRecord()

    CheckoutController ->> CheckoutRecord: 4. setDueDate(m_member.getCheckoutPeriod())

    CheckoutController ->> CheckoutRecord: 5. addBook(m_book)

    CheckoutController ->> LibraryMember: 6. addCheckoutRecord(CheckoutRecord)

    CheckoutController ->> ILibraryDBSubsystem: 7. addCheckoutRecord(m_member.getMemberID(), CheckoutRecord)

    CheckoutForm ->> CheckoutForm: 8. displayCheckoutInfo()

    CheckoutForm ->> CheckoutForm: 9. clearCheckoutFields()

```

ß