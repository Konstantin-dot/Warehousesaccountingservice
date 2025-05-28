package com.example.logistics;

import com.example.logistics.model.Client;
import com.example.logistics.repository.ClientRepository;

public class AppMain {
    public static void main(String[] args) {
        ClientRepository repo = new ClientRepository();

        // Создаем клиента
        Client client = new Client();
        client.setName("Николай Петров");
        client.setEmail("petr@example.com");
        client.setPhone("+79991234145");
        client.setAddress("Москва, ул. Ленина, д.1");

        repo.save(client);
        System.out.println("Клиент сохранен с ID: " + client.getId());

        // Получаем клиента из базы
        Client fromDb = repo.getById(client.getId());
        System.out.println("Полученный клиент: " + fromDb.getName());

        // Обновим клиента
        fromDb.setPhone("+79997654148");
        repo.update(fromDb);

        // Удалим клиента
        // repo.delete(fromDb);

        // Завершение работы Hibernate
        // HibernateUtil.shutdown(); // вызови при необходимости
    }

}
