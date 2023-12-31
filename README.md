# web-lab3
Задание:
- Разработать приложение на базе JavaServer Faces Framework, которое осуществляет проверку попадания точки в заданную область на координатной плоскости.

Условия:
- Приложение должно включать в себя:
  - 2 facelets-шаблона (стартовая страница и основная страница приложения)
  - набор управляемых бинов (managed beans), реализующих логику на стороне сервера
- Стартовая страница должна содержать следующие элементы:
  - "Шапку", содержащую ФИО студента, номер группы и номер варианта.
  - Интерактивные часы, показывающие текущие дату и время, обновляющиеся раз в 7 секунд.
  - Ссылку, позволяющую перейти на основную страницу приложения.
- Основная страница приложения должна содержать следующие элементы:
  - Набор компонентов для задания координат точки и радиуса области в соответствии с вариантом задания (+ библиотека компонентов PrimeFaces).
    - Если компонент допускает ввод заведомо некорректных данных (таких, например, как буквы в координатах точки или отрицательный радиус), то приложение должно осуществлять их валидацию.
  - Динамически обновляемую картинку, изображающую область на координатной плоскости в соответствии с номером варианта и точки, координаты которых были заданы пользователем.
    - Клик по картинке должен инициировать сценарий, осуществляющий определение координат новой точки и отправку их на сервер для проверки её попадания в область.
    - Цвет точек должен зависить от факта попадания / непопадания в область.
    - Смена радиуса также должна инициировать перерисовку картинки.
  - Таблицу со списком результатов предыдущих проверок.
  - Ссылку, позволяющую вернуться на стартовую страницу.

Дополнительные требования к приложению:
- Все результаты проверки должны сохраняться в базе данных под управлением СУБД Oracle.
- Для доступа к БД необходимо использовать ORM Hibernate.
- Для управления списком результатов должен использоваться Application-scoped Managed Bean.
- Конфигурация управляемых бинов должна быть задана с помощью параметров в конфигурационном файле.
- Правила навигации между страницами приложения должны быть заданы в отдельном конфигурационном файле.

<img width="1334" alt="Screenshot 2023-11-21 at 22 03 25" src="https://github.com/niikmynick/web-lab3/assets/76608743/124bc752-9955-42b9-acd1-7a2e5a149fdb">

<img width="1334" alt="Screenshot 2023-11-21 at 22 04 10" src="https://github.com/niikmynick/web-lab3/assets/76608743/846afce9-6f85-4468-a067-30d952de6e40">
