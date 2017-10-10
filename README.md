# Expensereport backend

## API endpoints

#### /projects (GET)
Returns a list of all reports

#### /projects/{id} (GET)
Returns the report with ID {id}  - i.e. /projects/5


##Sample JSON object
A sample report object returned from a GET request

```
{
  "id": "1",
  "employee": "Ants Lamp",
  "startDate": "17/8/17",
  "endDate": "27/8/17",
  "documents":
  [
      {
		        "docId": "1",
		        "date": "2/9/17",
		        "issuer": "Radisson",
		        "content": "Housing",
		        "field": "Development",
		        "project": "ExpenseReport",
		        "sum": "150",
		        "currency": "USD",
		        "creditCard": "false"
      },
      {
		        "docId": "2",	
		        "date": "3/9/17",
		        "issuer": "Finnair",
		        "content": "Travel",
		        "field": "Development",
		        "project": "ExpenseReport",
		        "sum": "100",
		        "currency": "EUR",
		        "creditCard": "false"
      }
  ],
  "creditSum": "0",
  "expenseSum": "250",
  "totalSum": "250"
}
```