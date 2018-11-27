# README #

Этот проект - телефонная книга, реализованная на следующих технологиях

клиентская часть: html, css, js, knockout, jquery, jquery-ui, bootstrap, underscore

серверная часть: spring-framework

Связь БД и Java: hibernate

БД: MySQL установленная на компьютере, схема phonebook, логин и пароль root

сборка: spring + maven

запуск: spring + tomcat

Что умеет делать проект:

отображать существующие контакты

добавлять новые контакты

удалять контакты (в БД ставится метка, что контакт удалён)

Как запустить проект:

Run PhoneBookSpringApplication - данная команда собирает проект и запускает PhoneBookSpringApplication main

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

