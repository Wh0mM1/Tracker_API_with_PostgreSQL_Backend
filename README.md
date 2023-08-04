# Tracker_API_with_PostgreSQL_Backend

This API is based on Spring-Boot
Connected with PostgreSQL Database
Includes endpoints:
1) POST /tasks: Create a new task.
2) GET /tasks/{id}: Retrieve a task by its ID.
3) GET /tasks: Retrieve a list of all tasks.
4) PUT /tasks/{id}: Update an existing task by its ID.
5) DELETE /tasks/{id}: Delete a task by its ID.


To call the requests:

1) Create a Database in PostgreSQL
   - with name as trackerdb (or mention as per name mentioned in application.properties or application.yaml)
![image](https://github.com/Wh0mM1/Tracker_API_with_PostgreSQL_Backend/assets/90375499/e4ff60c4-08bd-4322-a3b1-dcfbcd6abc61)

- Once you run the TrackerService table will get created in the database

2) You can now implement different operations on it as per mentioned above
   - POST /tasks: Create a new task.
    ![image](https://github.com/Wh0mM1/Tracker_API_with_PostgreSQL_Backend/assets/90375499/028b85c3-3fa1-483a-8d10-9bf8b1e1f476)

   - GET /tasks/{id}: Retrieve a task by its ID.
     ![image](https://github.com/Wh0mM1/Tracker_API_with_PostgreSQL_Backend/assets/90375499/db2d5eb1-46f1-4168-a609-6ed9ff6b1d44)

   - GET /tasks: Retrieve a list of all tasks.
     ![image](https://github.com/Wh0mM1/Tracker_API_with_PostgreSQL_Backend/assets/90375499/dc7f8d34-443a-4755-91f7-5864bf924e44)

   - PUT /tasks/{id}: Update an existing task by its ID.
     ![image](https://github.com/Wh0mM1/Tracker_API_with_PostgreSQL_Backend/assets/90375499/856fe9f8-e657-4c87-9e6e-da834e4d7cd9)

   - DELETE /tasks/{id}: Delete a task by its ID.
     ![image](https://github.com/Wh0mM1/Tracker_API_with_PostgreSQL_Backend/assets/90375499/4dbfa2f2-2cd3-42b0-8c64-2da481f83ec3)

3) Testing is also implemented with Mocking
    You can click the play button in front of - void test_When_Task_Is_Present_Success():
   
   ![image](https://github.com/Wh0mM1/Tracker_API_with_PostgreSQL_Backend/assets/90375499/2836bf70-3ae7-4a12-b4d1-ebad1944288b)

By mistake if you hit the wrong id for operations it will show custom error as exception handling is there:

![image](https://github.com/Wh0mM1/Tracker_API_with_PostgreSQL_Backend/assets/90375499/eb08120e-7645-4742-95ca-d202080aa180)





