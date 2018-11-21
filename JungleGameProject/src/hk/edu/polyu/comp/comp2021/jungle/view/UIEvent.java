package hk.edu.polyu.comp.comp2021.jungle.view;

/**
 * Types of UI events
 */
public enum UIEvent {
    /**
     * on controller awaiting game mode input
     */
    GAME_MODE_SELECT,
    /**
     * on singleplayer game initializing
     */
    GAME_SINGLE_PLAYER,
    /**
     * we spend all time writing javadoc and have little left for online mode
     */
    GAME_ONLINE,
    /**
     * on game initialized or loaded
     */
    GAME_INITIATED,
    /**
     * on next player started turn
     */
    GAME_SWAP_TURN,
    /**
     * on board printed or updated
     */
    UI_BOARD_UPDATE,
    /**
     * on move command invalid
     */
    UI_COMMAND_REJECTED,
    /**
     * on neutral info posted
     */
    UI_INFO,
    /**
     * on unrecoveralbe error caught
     */
    UI_ERROR_REPORT,
}
