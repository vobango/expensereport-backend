# Expensereport backend

## API endpoints

#### /swagger-ui.html
Auto-generated REST API docs

#### /projects (GET)
Returns a list of all reports

#### /projects/{id} (GET)
Returns the report with ID {id}  - i.e. /projects/5

## Sample JSON object
A sample report object returned from a GET request

```
{
        "reportId": 1,
        "employee": "Aino Ainus",
        "startDate": "11.10.17",
        "endDate": "11.10.17",
        "documents": [
            {
                "reportId": 1,
                "docId": 1,
                "date": "11.10.17",
                "issuer": "Radisson",
                "content": "Housing",
                "field": "Testing",
                "project": "ExpRep",
                "sum": 150,
                "currency": "GBP",
                "creditCard": true,
                "sumEur": 190.5
            },
            {
                "reportId": 1,
                "docId": 2,
                "date": "11.10.17",
                "issuer": "EasyJet",
                "content": "Travel",
                "field": "Testing",
                "project": "ExpRep",
                "sum": 100,
                "currency": "EUR",
                "creditCard": false,
                "sumEur": 100
            }
        ],
        "expenseSum": 290.5,
        "creditSum": 190.5,
        "totalSum": 100,
        "status": "ACTIVE"
    }
```

## Auto-generated REST API docs are available on URL /swagger-ui.html
