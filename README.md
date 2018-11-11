# README #

Это проект - телефонная книга, реализованная на следующих технологиях

клиентская часть: html, css, js, knockout, jquery, jquery-ui, bootstrap, underscore

серверная часть: spring-framework

Связь БД и Java: hibernate

БД: MySQL установленная на компьютере, схема phonebook, логин и пароль root

сборка: spring + maven

запуск: spring + tomcat

Что умеет делать проект:
отображать сущетсвующие контакты
добавлять новые контакты
удалять контакты из БД

Что нужно добавить в проект:
Таблицу звонков + апи для получения звонков по контакту

Как запустить проект
Run PhoneBookSpringApplication - данная команда собирает проект и запускает PhoneBookSpringApplication main
Debug PhoneBookSpringApplication - данная команда собирает проект в режиме дебаг и запускает phoneBookSpringApplication main

Отладка серверной части:
1) запустите проект в режиме дебаг
2) используйте постман

Отладка клиентской части:
1) запускайте проект в chome
2) используйте инструменты разработчика

Реализованные методы API:
GET {host}/phoneBook/rcp/api/v1/getAllContacts - получения списка контактов

POST {host}//phoneBook/rcp/api/v1/addContact - добавление нового контакта в формате
Тело запроса:
{
 "firstName": "Имя",
 "lastName": "Фамилия",
 "phone": "Телефон"
}

POST {host}//phoneBook/rcp/api/v1/removeContacts - удаление контактов

