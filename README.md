#rest-examples/question-bank-rest-service
#Simple Rest Service using Java, Postgres.
Pre-requisites: git, maven, java, tomcat, postgres
Step 1: check out the code
git clone https://github.com/yeluru/rest-examples
Step 2: build the code
cd question-bank-rest-service
mvn clean package
Step 3: deploy the code
cp target/qb.war <tomcat-installation-directory>/webapps
Step 4: make db ready
Create table subject with below structure

Column |  Type   | Modifiers | Storage  | Stats target | Description 
--------+---------+-----------+----------+--------------+-------------
 id     | integer | not null  | plain    |              | 
 name   | text    |           | extended |              | 

Indexes:
    "Subject_pkey" PRIMARY KEY, btree (id)
Referenced by:
    TABLE "topic" CONSTRAINT "Topic_subject_id_fkey" FOREIGN KEY (subject_id) REFERENCES subject(id)
Create table Topic

   Column   |  Type   | Modifiers | Storage  | Stats target | Description 
------------+---------+-----------+----------+--------------+-------------
 id         | integer | not null  | plain    |              | 
 name       | text    |           | extended |              | 
 subject_id | integer |           | plain    |              | 
Indexes:
    "Topic_pkey" PRIMARY KEY, btree (id)
Foreign-key constraints:
    "Topic_subject_id_fkey" FOREIGN KEY (subject_id) REFERENCES subject(id)
Referenced by:
    TABLE "question" CONSTRAINT "Questions_topic_id_fkey" FOREIGN KEY (topic_id) REFERENCES topic(id)
