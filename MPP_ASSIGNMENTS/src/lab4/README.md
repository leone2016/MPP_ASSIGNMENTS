# Lab 4
#### A.  Re-draw the diagram so that it follows UML synatx rules. 

Considered points: 

* Include message numbering 
* Use proper UML syntax for the objects displayed at the top. 
* Indicate looping wherever it occurs with Iteration markers 

![](assets/lab4_2.png)

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

------------

### POLYMORPHISM
#### Payroll Calculation

Part D

Create a sequence diagram for the problem described in Lab 4, Part C; your diagram should model the use case in which the paycheck for a **Commissioned employee** is computed. Create a distributed control solution. As you distribute control, make sure that the object that handles a step of processing really should be responsible for that behavior, based on the purpose of the class that was determined in the class diagram.

```mermaid
sequenceDiagram
  participant Main
  participant emp as Commissioned
  participant ord as Orders
  participant empSuper as Employee
  participant pc as Paycheck

  Main->>emp: 1. calcCompensation(month, year)
  emp->>emp: 2. calcGrossPay(month, year)
  emp->>ord: * 3. getOrderDate()
  loop List<Orders>
    ord-->>emp: returns orderDate
    ord->>ord: getOrderAmount()
    ord-->>emp: returns orderAmount
  end
   emp-->>empSuper: 3.1. returns grossPay
   empSuper->>pc: 4. new Paycheck(grossPay)
	  pc-->>empSuper: 5. Paycheck object
  empSuper-->>Main: 6. returns Paycheck





```





