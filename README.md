# diligentrobotics

The Application.java file includes the main method of the project, where the calls to the TaskService class are made. The TaskService class includes the business logic. It utilizes the TaskRepository class as a representation of the database. Similarly, other model classes including the Task class as well as required Enums are included in the project.


## High Level Components

A relational database can be a suitable solution for this problem. This is primarily because the tasks would be transactional in nature.

A service would have to be deployed in a production environment to listen to the dispatch requests made by the end users.

The Java code in itself can follow the Entity, Model, Controller structure. The builder pattern can be used to construct the objects.
