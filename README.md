# API Poller

- API Poller system that will asynchronously poll data from the 2 APIs below every 5 seconds Use GET method. Below API's are consumed for fetching the data.

  ```https://www.thecocktaildb.com/api/json/v1/1/random.php```
  
  ```https://randomuser.me/api/```
  
- Used Kafka to send the fetched to desired topics.
- Running a Queue reader that continuously searches for data in the queue and saves the result to MongoDB.
- Dockerized the project to ensure consistent deployment and easy scalability.