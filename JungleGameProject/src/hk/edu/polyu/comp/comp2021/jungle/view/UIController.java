package hk.edu.polyu.comp.comp2021.jungle.view;

import hk.edu.polyu.comp.comp2021.jungle.controller.Controller;

/**
 *
 * The UI control module in Singleton form.
 * Provides an UI event tunnel and handles controller-view communications
 */
public class UIController {

    private GamePrepareUI prep;
    private GameUI ui;
    private Controller currentController;

    /**
     * Singleton
     */
    public static final UIController instance=new UIController();

    /**
     *
     * bind the controller to the instance of UIController.
     * must be called before the controller falls into main game loop.
     * @param ctrl controller
     */
    public void setCurrentController(Controller ctrl){
        currentController=ctrl;
    }


    private void createUI(){
        if(ui!=null)
            ui.dispose();
        String title=currentController.getGame().getPlayer(0).getName()+" vs "+currentController.getGame().getPlayer(1).getName();
        ui=new GameUI(title);
    }

    /**
     *
     * get the running GameUI instance
     * @return running instance or null if game is not initiated
     */
    protected GameUI getGameUI(){return ui;}

    /**
     *
     * send an UI event for interactions and notifications
     * @param event UI event
     */
    public void sendEvent(UIEvent event){
        sendEvent(event,null);
    }

    /**
     *
     * send an UI event for interactions and notifications
     * @param event UI event
     * @param extramsg message attached to the event, not null
     */
    public void sendEvent(UIEvent event,String extramsg){
        switch(event){
            case GAME_MODE_SELECT:
                prep=new GamePrepareUI();
            case GAME_SINGLE_PLAYER:
                prep.onEvent(event);
                return;
            case GAME_INITIATED:
                instance.createUI();
            case UI_BOARD_UPDATE:
                ui.updatePawns(currentController.getCheckerBoard());
                return;
            case GAME_SWAP_TURN:
                ui.updateTurnInfo(currentController.getGame().getCurrentTurn(),currentController.getGame().getPlayer(currentController.getGame().getCurrentTurn()));
                return;
        }
        if(extramsg==null){
            sendEvent(UIEvent.UI_ERROR_REPORT,"Event message is null!");
            return;
        }
        switch(event){
            case UI_COMMAND_REJECTED:
                ui.setCmdRejectedMsg(extramsg);
                return;
            case UI_INFO:
                ui.showInfo(extramsg);
                return;
            case UI_ERROR_REPORT:
                ui.showError(extramsg);
                return;
        }
    }
}
