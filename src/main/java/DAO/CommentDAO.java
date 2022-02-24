package DAO;

import java.time.LocalDateTime;

public class CommentDAO {
    public static int getCount() {
        return count++;
    }

    private static int count = 0;

    // addComment 1
    // set id with getCount
    // set time     //LocalDateTime.now()
}
