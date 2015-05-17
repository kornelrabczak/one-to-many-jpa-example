One2Many JPA
====================
 
OrderBy vs InMemory Sorting Example

OrderBy
---------------------
Curl for creating entities in orderBy example

    curl -iX POST http://localhost:8080/One2ManyJpaExample/resources/entities/order -H "Content-Type: application/json" -d '{"value":"test1", "images":[{"url":"test url 1", "priority":41},{"url":"url test 5","priority":2}, {"url":"url 999","priority":99}, {"url":"url 1","priority":1}, {"url":"url 21","priority":21}]}'
    
    curl http://localhost:8080/One2ManyJpaExample/resources/entities/order

###example data :

    {
    id: 1,
    value: "test1",
    images: [
            {
                id: 6,
                url: "url 1",
                priority: 1
            },
            {
                id: 4,
                url: "url test 5",
                priority: 2
            },
            {
                id: 7,
                url: "url 21",
                priority: 21
            },
            {
                id: 3,
                url: "test url 1",
                priority: 41
            },
            {
                id: 5,
                url: "url 999",
                priority: 99
            }
        ]
    }

###hibernate query :

    12:01:45,843 INFO  [stdout] [] (default task-18) Hibernate:
    12:01:45,843 INFO  [stdout] [] (default task-18)     select
    12:01:45,843 INFO  [stdout] [] (default task-18)         images0_.images_id as images_i4_2_0_,
    12:01:45,843 INFO  [stdout] [] (default task-18)         images0_.id as id1_0_0_,
    12:01:45,843 INFO  [stdout] [] (default task-18)         images0_.id as id1_0_1_,
    12:01:45,844 INFO  [stdout] [] (default task-18)         images0_.priority as priority2_0_1_,
    12:01:45,844 INFO  [stdout] [] (default task-18)         images0_.url as url3_0_1_
    12:01:45,844 INFO  [stdout] [] (default task-18)     from
    12:01:45,844 INFO  [stdout] [] (default task-18)         GameImageOrder images0_
    12:01:45,844 INFO  [stdout] [] (default task-18)     where
    12:01:45,844 INFO  [stdout] [] (default task-18)         images0_.images_id=?
    12:01:45,844 INFO  [stdout] [] (default task-18)     order by
    12:01:45,844 INFO  [stdout] [] (default task-18)         images0_.priority


Sort (in-memory sorting)
---------------------

    curl -iX POST http://localhost:8080/One2ManyJpaExample/resources/entities/sort -H "Content-Type: application/json" -d '{"value":"test1", "images":[{"url":"test url 1", "priority":41},{"url":"url test 5","priority":2}, {"url":"url 999","priority":99}, {"url":"url 1","priority":1}, {"url":"url 21","priority":21}]}'
    
    curl http://localhost:8080/One2ManyJpaExample/resources/entities/sort

###example data :

    {
    id: 1,
    value: "test1",
    images: [
            {
                id: 6,
                url: "url 1",
                priority: 1
            },
            {
                id: 4,
                url: "url test 5",
                priority: 2
            },
            {
                id: 7,
                url: "url 21",
                priority: 21
            },
            {
                id: 3,
                url: "test url 1",
                priority: 41
            },
            {
                id: 5,
                url: "url 999",
                priority: 99
            }
        ]
    }

###hibernate query :

    12:11:10,216 INFO  [stdout] [] (default task-22) Hibernate:
    12:11:10,217 INFO  [stdout] [] (default task-22)     select
    12:11:10,217 INFO  [stdout] [] (default task-22)         gamesort0_.id as id1_3_,
    12:11:10,217 INFO  [stdout] [] (default task-22)         gamesort0_.value as value2_3_
    12:11:10,217 INFO  [stdout] [] (default task-22)     from
    12:11:10,217 INFO  [stdout] [] (default task-22)         GameSort gamesort0_
    12:11:10,220 INFO  [stdout] [] (default task-22) Hibernate:
    12:11:10,220 INFO  [stdout] [] (default task-22)     select
    12:11:10,220 INFO  [stdout] [] (default task-22)         images0_.images_id as images_i4_3_0_,
    12:11:10,221 INFO  [stdout] [] (default task-22)         images0_.id as id1_1_0_,
    12:11:10,221 INFO  [stdout] [] (default task-22)         images0_.id as id1_1_1_,
    12:11:10,221 INFO  [stdout] [] (default task-22)         images0_.priority as priority2_1_1_,
    12:11:10,221 INFO  [stdout] [] (default task-22)         images0_.url as url3_1_1_
    12:11:10,221 INFO  [stdout] [] (default task-22)     from
    12:11:10,221 INFO  [stdout] [] (default task-22)         GameImageSort images0_
    12:11:10,221 INFO  [stdout] [] (default task-22)     where
    12:11:10,221 INFO  [stdout] [] (default task-22)         images0_.images_id=?
