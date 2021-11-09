package fr.uge.jee.servlet.hellosession;

import java.util.HashMap;
import java.util.UUID;

public class SessionTokens {
    private final Object lock = new Object();
    private final HashMap<UUID, Integer> map = new HashMap<>();

    public UUID addToken() {
        var uuid = UUID.randomUUID();
        synchronized (lock) {
            while (map.get(uuid) != null) {
                uuid = UUID.randomUUID();
            }
            map.put(uuid, 0);
        }
        return uuid;
    }

    public int modifyToken(UUID session) {
        synchronized (lock) {
            map.put(session, map.get(session) + 1);
        }
        return map.get(session);
    }
}
