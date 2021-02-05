package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void replaceItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("text1");
            tracker.add(item);
            tracker.replace(item.getId(), new Item("text1"));
            assertThat(tracker.findById(item.getId()).getName(), is("text1"));
        }
    }

    @Test
    public void deleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("text1");
            tracker.add(item);
            tracker.delete(item.getId());
            assertNull(tracker.findById(item.getId()));
        }
    }

    @Test
    public void findByIdItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("text1");
            tracker.add(item);
            assertThat(tracker.findById(item.getId()), is(item));
        }
    }

    @Test
    public void findNameItems() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("text1");
            Item item2 = new Item("text1");
            tracker.add(item);
            tracker.add(item2);
            List<Item> result = tracker.findByName("text1");
            assertThat(result, is(List.of(item, item2)));
        }
    }
}