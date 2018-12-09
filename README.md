# maprdb-cleaner
A small tool to clean MapR-DB based on queries


Installation

```bash
brew install https://raw.githubusercontent.com/anicolaspp/maprdb-cleaner/master/maprdb-cleaner.rb
```


Using this tool, we should be able to run the fallowing commands:

 
Deletes document with `_id` equals to `-1016518206699135554`
```bash
maprdbcls -t /user/mapr/tables/rnd --all false -q '{"$where": {"$eq": {"_id": "-1016518206699135554"}}}'

```

Deletes all documents

```bash
maprdbcls -t /user/mapr/tables/rnd --all true

```

Deletes all documents using id `custom_id_field`

```bash
maprdbcls -t /user/mapr/tables/rnd --all true --id custom_id_field 

```
 
`maprdbcls` executes `maprdb-cleaner-1.0.0.jar` passsing the class path `/opt/mapr/lib/*`, so `MapR` client should 
be installed in this path (defaults). 


```bash
java -cp "/opt/mapr/lib/*:/Users/nperez/IdeaProjects/maprdb-cleaner/target/scala-2.11/maprdb-cleaner-1.0.0.jar:." -Djava.library.path=/opt/mapr/lib com.github.anicolaspp.maprdbcleaner.App --tableName tables/view_counts
```
