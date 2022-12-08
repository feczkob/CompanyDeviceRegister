# Company Device Register

## Description
This project is being made for the courses Advanced Java Programming and Angular of the year 2022.
The Spring Boot backend stores departments, groups, workers and their devices.
Workers can have multiple devices and each worker is assigned to a group. A department is built by a set of groups.
Users can retrieve information about departments, groups and workers using the Angular frontend.

## Github repository
The project is available at my [Github repository](https://github.com/feczkob/CompanyDeviceRegister).

## Backend

### Entity Relationship Diagram

![ERD](images/erd.png?raw=true "ERD")

### Endpoints

#### Device (/device)

| Method | Input         | Output          | Path        |
|--------|---------------|-----------------|-------------|
| POST   | DeviceRequest | DeviceResponse  | -           |
| GET    | -             | DeviceResponse  | /{id}       |
| GET    | -             | List            | /getAll[^1] |
| DELETE | -             | -               | /{id}       |

[^1]: With pagination and sorting.

#### Worker (/worker)

| Method | Input         | Output         | Path        |
|--------|---------------|----------------|-------------|
| POST   | WorkerRequest | WorkerResponse | -           |
| GET    | -             | WorkerResponse | /{id}       |
| GET    | -             | List           | /getAll[^1] |
| PUT    | WorkerRequest | WorkerResponse | /{id}       |
| DELETE | -             | -              | /{id}       |

#### Group (/group)

| Method | Input        | Output        | Path        |
|--------|--------------|---------------|-------------|
| POST   | GroupRequest | GroupResponse | -           |
| GET    | -            | GroupResponse | /{id}       |
| GET    | -            | List          | /getAll[^1] |
| DELETE | -            | -             | /{id}       |

#### Department (/department)

| Method | Input             | Output             | Path  |
|--------|-------------------|--------------------|-------|
| POST   | DepartmentRequest | DepartmentResponse | -     |
| GET    | -                 | DepartmentResponse | /{id} |

### How to run

Execute the following commands to run the service:

```console
$ mvn clean install
$ docker-compose up -d
$ mvn liquibase:update
$ mvn spring-boot:run
```

When the service has started, visit the swagger page:
[Swagger](http://localhost:8080/swagger-ui/index.html)

Credentials: pista - password

User pista has both ADMIN and USER roles, while the others have only USER. The following users are defined: juci, pista, sanyi, peti. 
The password is always 'password'.

## Frontend

### Pages

#### Workers page

![workers](images/workers.png?raw=true "workers")

- Lists workers
- User can navigate to the groups page

#### Worker page

![worker](images/worker.png?raw=true "worker")

- Shows a worker (it's name, group Id, details and list of devices)
- User can delete device
- User can add device
- User can navigate back
- User can navigate either to the groups or to the workers page
- User with role ADMIN can download worker report

#### Groups page

![groups](images/groups.png?raw=true "groups")

- Lists groups (with their workers)
- User can navigate to the group page
- User can navigate to the worker page
- User can navigate to the workers page

#### Group page

![group](images/group.png?raw=true "group")

- Shows a group (it's name, department Id, description and list of workers)
- User can navigate to the worker page
- User can navigate back
- User can navigate either to the groups or to the workers page

### How to run

Execute the following commands to run the service:

```console
$ cd company-device-registry-frontend
$ npm install
$ ng serve
```