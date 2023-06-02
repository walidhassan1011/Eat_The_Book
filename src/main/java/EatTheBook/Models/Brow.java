package EatTheBook.Models;

import org.bson.types.ObjectId;

public class Brow {
    private ObjectId _id;
    private ObjectId bookId;
    private ObjectId userId;

    public Brow(ObjectId bookId, ObjectId userId) {
        this.bookId = bookId;
        this.userId = userId;
    }
}
