package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void getDataFromSimpleTask() { //Получает данные simpleTask
        SimpleTask simpleTask = new SimpleTask(7, "Прочитать книгу");

        Assertions.assertEquals(7, simpleTask.getId());
        Assertions.assertEquals("Прочитать книгу", simpleTask.getTitle());
    }

    @Test
    public void GetDataFromEpic() { //получает данные Epic
        String[] subtasks = {"Сделать ДЗ в Нетологии", "Забрать детей из детского сада"};
        Epic epic = new Epic(8, subtasks);

        Assertions.assertEquals(8, epic.getId());
        String[] expected = {"Сделать ДЗ в Нетологии", "Забрать детей из детского сада"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void GetDataFromMeeting() { //получает данные Meeting
        Meeting meeting = new Meeting(9, "Встреча с коллегами", "Бар Дикий Койот", "4 марта");

        Assertions.assertEquals(9, meeting.getId());
        Assertions.assertEquals("Встреча с коллегами", meeting.getTopic());
        Assertions.assertEquals("Бар Дикий Койот", meeting.getProject());
        Assertions.assertEquals("4 марта", meeting.getStart());
    }

    @Test
    public void OutputOfMatchesInSimpleTask() { //проверяет совпадения в SimpleTask
        SimpleTask simpleTask = new SimpleTask(10, "Прочитать книгу");

        Assertions.assertEquals(true, simpleTask.matches("Прочитать книгу")); //есть совпадения в title
        Assertions.assertEquals(false, simpleTask.matches("Посмотреть фильм")); //нет совпадений в title
    }

    @Test
    public void OutputOfMatchesInEpic() { //проверяет совпадения в Epic
        String[] subtasks = {"Сделать ДЗ в Нетологии", "Забрать детей из детского сада", "Посмотреть фильм"};
        Epic epic = new Epic(11, subtasks);

        Assertions.assertEquals(true, epic.matches("Посмотреть фильм")); //есть совпадения в subtasks
        Assertions.assertEquals(false, epic.matches("Тренировка")); //нет совпадений в subtasks
    }

    @Test
    public void OutputOfMatchesInMeeting() { //проверяет совпадения в Meeting
        Meeting meeting = new Meeting(12,
                "Встреча с коллегами",
                "Бар Дикий Койот",
                "4 марта");

        Assertions.assertEquals(true, meeting.matches("Встреча")); //есть совпадение в topic
        Assertions.assertEquals(true, meeting.matches("Бар")); //есть совпадение в project
        Assertions.assertEquals(false, meeting.matches("5 марта")); //нет совпадений
    }
}
