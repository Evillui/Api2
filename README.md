Бузанов Никита Вячеславович
ПИКД Б9123-09.03.03 6 подгруппа



VariantCode: HNALG-SHOWHN-MOD_D19_LAST_REQUEST_LOG



Модификатор варианта: MOD_D19_LAST_REQUEST_LOG
Отображение на экране информации о последнем успешном запросе
Как реализовано:
1. После каждого успешного сетевого запроса сохраняется строка последнего запроса
2. Внизу экрана показывается блок Last request.
Это позволяет увидеть, какой запрос был выполнен последним и успешно завершился



Использованные endpoints (HN Algolia API)
URL: https://hn.algolia.com/api/v1
1. Список Show HN (List)
GET /search_by_date?tags=story,show_hn
Используется для загрузки списка постов Show HN на главном экране
2. Детали элемента (Detail)
GET /items/{id}
Используется для загрузки деталей выбранного поста по id после нажатия на элемент списка



Скриншоты:

Экран контента:
https://raw.githubusercontent.com/Evillui/Api2/b1702d643a3302171c813a9d8fc2197f75fe82a2/%D0%AD%D0%BA%D1%80%D0%B0%D0%BD%20%D0%BA%D0%BE%D0%BD%D1%82%D0%B5%D0%BD%D1%82%D0%B0%20%D0%B8%D0%B7%2020%20%D0%BF%D0%BE%D0%BB%D1%81%D0%B5%D0%B4%D0%BD%D0%B8%D1%85%20%D0%BD%D0%BE%D0%B2%D0%BE%D1%81%D1%82%D0%B5%D0%B9.png

Экран деталей:
https://raw.githubusercontent.com/Evillui/Api2/b1702d643a3302171c813a9d8fc2197f75fe82a2/%D0%AD%D0%BA%D1%80%D0%B0%D0%BD%20%D0%B4%D0%B5%D1%82%D0%B0%D0%BB%D0%B5%D0%B9.png

Экран загрузки:
https://raw.githubusercontent.com/Evillui/Api2/b1702d643a3302171c813a9d8fc2197f75fe82a2/%D0%AD%D0%BA%D1%80%D0%B0%D0%BD%20%D0%B7%D0%B0%D0%B3%D1%80%D1%83%D0%B7%D0%BA%D0%B8.png

Экран ретрая:
https://raw.githubusercontent.com/Evillui/Api2/b1702d643a3302171c813a9d8fc2197f75fe82a2/%D0%AD%D0%BA%D1%80%D0%B0%D0%BD%20%D1%80%D0%B5%D1%82%D1%80%D0%B0%D0%B9.png