# Company Device Register

## Description
This microservice stores departments, groups, workers and their devices.
Workers can have multiple devices and each worker is assigned to a group. A department is built by a set of groups.

## Backend
### Entity Relationship Diagram
```plantuml
@startuml
entity Department {
* department_id: number
--
* name: text
description: text
}

entity Group {
* group_id: number
--
* name: text
* department_id: number <<FK>>
description
}

entity Worker {
* worker_id: number
--
* name: text
* group_id: number <<FK>>
details
}

entity Device {
* device_id: number
--
* worker_id: number <<FK>>
* name: text
* value: number
}


Department ||--o{ Group
Worker ||--|{ Device
Worker }|--|| Group
@enduml
```

### Endpoints
#### Device (/device)
| Method | Input         | Output         | Path  |
|--------|---------------|----------------|-------|
| POST   | DeviceRequest | DeviceResponse | -     |
| GET    | -             | DeviceResponse | /{id} |
| DELETE | -             | -              | /{id} |

#### Worker (/worker)
| Method | Input         | Output         | Path  |
|--------|---------------|----------------|-------|
| POST   | WorkerRequest | WorkerResponse | -     |
| GET    | -             | WorkerResponse | /{id} |
| PUT    | WorkerRequest | id             | /{id} |
| DELETE | -             | -              | /{id} |

#### Group (/group)
| Method | Input         | Output        | Path  |
|--------|---------------|---------------|-------|
| POST   | GroupRequest  | GroupResponse | -     |
| GET    | -             | GroupResponse | /{id} |
| DELETE | -             | -             | /{id} |

#### Department (/department)
| Method | Input             | Output             | Path  |
|--------|-------------------|--------------------|-------|
| POST   | DepartmentRequest | DepartmentResponse | -     |
| GET    | -                 | DepartmentResponse | /{id} |


## Frontend

