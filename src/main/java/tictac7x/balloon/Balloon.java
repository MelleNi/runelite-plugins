package tictac7x.balloon;

import com.google.common.collect.ImmutableSet;
import net.runelite.api.GameState;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import tictac7x.balloon.api.ObjectId;

import java.util.Set;

public class Balloon {
    private final Set<Integer> BALLOON_OBJECT_IDS = ImmutableSet.of(
        ObjectId.BALLOON_ENTRANA,
        ObjectId.BALLOON_TAVERN,
        ObjectId.BALLOON_CASTLE_WARS,
        ObjectId.BALLOON_TREE_GNOME_STRONGHOLD,
        ObjectId.BALLOON_CRAFTING_GUILD,
        ObjectId.BALLOON_VARROCK
    );
    private boolean visible = false;

    public void onGameObjectSpawned(final GameObjectSpawned event) {
        if (BALLOON_OBJECT_IDS.contains(event.getGameObject().getId())) {
            visible = true;
        }
    }

    public void onGameStateChanged(final GameStateChanged event) {
        if (event.getGameState() == GameState.LOADING) {
            visible = false;
        }
    }

    public boolean isVisible() {
        return visible;
    }
}
