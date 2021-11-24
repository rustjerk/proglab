package me.rustjerk.itmo.lab3.goal;

import me.rustjerk.itmo.lab3.item.Book;
import me.rustjerk.itmo.lab3.item.Item;
import me.rustjerk.itmo.lab3.person.trait.Trait;
import me.rustjerk.itmo.lab3.person.trait.Traits;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class ReadBook extends Goal {
    private final Book book;

    public ReadBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public List<Item> getRequiredItems() {
        return Collections.singletonList(book);
    }

    public List<Trait> getRequiredTraits() {
        return Collections.singletonList(Traits.WELL_READ);
    }

    @Override
    public float getChanceOfSuccess() {
        return 0.9f;
    }

    @Override
    public Duration getRequiredTime() {
        return Duration.ofMinutes((long) Math.ceil(((float) book.getDescription().length()) / 1250f));
    }

    @Override
    public String getDescription() {
        return "Необходимо прочитать книгу, которую мы нашли в секретном бункере.";
    }
}
