const days = ['Понедельник', 'Вторник', 'Среда', 'Четверг', 'Пятница', 'Суббота', 'Воскресенье'];
let dayN = 0;

while (confirm(`${days[dayN]}. Хотите увидеть следующий день?`)) {
    dayN = (dayN+ 1) % days.length;
}