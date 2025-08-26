package org.persistence.htcl;

import org.hibernate.event.spi.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionListeners implements PostInsertEventListener, PostUpdateEventListener, PostDeleteEventListener {

    private static Logger logger = Logger.getLogger(TransactionListeners.class.getName());

    @Override
    public void onPostDelete(PostDeleteEvent postDeleteEvent) {
        logger.log(Level.INFO, postDeleteEvent.toString()+" deletion done");
    }

    @Override
    public void onPostInsert(PostInsertEvent postInsertEvent) {
        logger.log(Level.INFO, postInsertEvent.toString()+" insertion done");
    }

    @Override
    public void onPostUpdate(PostUpdateEvent postUpdateEvent) {
        logger.log(Level.INFO, postUpdateEvent.toString()+" update done");
    }
}
