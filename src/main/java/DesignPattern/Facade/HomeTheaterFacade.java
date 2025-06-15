package Facade;

public class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Popcorn popcorn;
    private Projector projector;
    private Screen screen;
    private Stereo stereo;
    private TheaterLight theaterLight;

    public HomeTheaterFacade() {
        this.dvdPlayer = DVDPlayer.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.stereo = Stereo.getInstance();
        this.theaterLight = TheaterLight.getInstance();
    }

    public void ready(){
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        dvdPlayer.on();
        theaterLight.dim();
    }

    public void play(){
        dvdPlayer.play();
    }

    public void pause(){

        dvdPlayer.pause();
    }

    public void end(){
        theaterLight.bright();
        dvdPlayer.off();
        projector.off();
        screen.up();
        stereo.off();
        popcorn.off();
    }

}
