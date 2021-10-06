Данное приложение развертывал через Tomcat 9.0.43, использовал Maven для сборки и загрузки зависимостей.
Если запускать через IDEA:
- клонируем репозиторий
- подгружаем зависимости через Maven
- Настраиваем Tomcat:
 - Edit Conficuraruons - + - Tomcat server Local
 - Gonfigure... указываем путь до папки где находиться Tomcat на вашем компьютере
 - Во вкладке Deployment - + - выбераем  FFINBankTesting_war_exploded
 - из  Aplication context все удаляем
 - OK
- Run Tomcat
- в поисковой строке браезера набераем http://localhost:8080/

Второй способ:
- Собираем WAR с помщью Maven
- Собранный WAR помещаем в ПУТЬ_ДО_TOMCAT/Tomcat/apache-tomcat-9.0.43/webapps
- запускаем cmd
- в cmd переходим в УТЬ_ДО_TOMCAT/Tomcat/apache-tomcat-9.0.43/webapps/bin
- startup для запуска Tomcat
- в поисковой строке браезера набераем http://localhost:8080/FFINBank/

Приложение читает фаил формата GSON и выводит данные в браузер в виде таблицы в соответствии с задаными критериями которые разделяются между собой символом &
Если критерии указаны не верно - выводятся все данные

Критерии:
1. category возможные варианты (wired-headphones,wireless-headphones,smart-watches) - фильтрует по категориям
2. sort возможные варианты (price,date) - сортирует price или date . По умолчанию сортирует в порядке убывания
3. order=asc порядок сортировки по возрастанию

Например http://localhost:8080/?sort=price&order=asc&category=wired-headphones выведет все категориии ired-headphones отсортированные по price по возростанию


