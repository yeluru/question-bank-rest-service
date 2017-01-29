#Simple Rest Service using Java, Postgres. 

This example mimics question bank service where a subject will have 1 or more topics, a topic will have 1 or more questions.

Pre-requisites: git, maven, java, tomcat, postgres

Step 1: check out the code

git clone https://github.com/yeluru/rest-examples

Step 2: build the code

cd question-bank-rest-service

mvn clean package

Step 3: deploy the code

cp target/qb.war <tomcat-installation-directory>/webapps

Step 4: make db ready

1: Create table subject

id     | integer | not null  | 

name   | text    |           |

Indexes:

"Subject_pkey" PRIMARY KEY, btree (id)

Referenced by:

TABLE "topic" CONSTRAINT "Topic_subject_id_fkey" FOREIGN KEY (subject_id) REFERENCES subject(id)

2: Create table topic

id         | integer | not null  | plain    |              | 

name       | text    |           | extended |              | 

subject_id | integer |           | plain    |              | 

Indexes:

"Topic_pkey" PRIMARY KEY, btree (id)

Foreign-key constraints:

"Topic_subject_id_fkey" FOREIGN KEY (subject_id) REFERENCES subject(id)

Referenced by:

TABLE "question" CONSTRAINT "Questions_topic_id_fkey" FOREIGN KEY (topic_id) REFERENCES topic(id)

3: Create table question
 
 id       | integer | not null  | plain    |              | 
 
 name     | text    |           | extended |              | 
 
 topic_id | integer |           | plain    |              | 

Indexes:
    "Questions_pkey" PRIMARY KEY, btree (id)

Foreign-key constraints:

"Questions_topic_id_fkey" FOREIGN KEY (topic_id) REFERENCES topic(id)

#Testing

After deploying qb.war in the tomcat container and the database tables and test data is ready, this service can be tested at that returns a JSON as below

[{"id":1,"name":"What is the Area of a circle?","topic":{"id":1,"name":"Geometry","subject":{"id":1,"name":"Math"}}},{"id":2,"name":"if condition","topic":{"id":2,"name":"Conditions","subject":{"id":2,"name":"Java"}}},{"id":3,"name":"Area of Triangle","topic":{"id":1,"name":"Geometry","subject":{"id":1,"name":"Math"}}}]

http://localhost:8080/qb/webapi/qb/questions/list
