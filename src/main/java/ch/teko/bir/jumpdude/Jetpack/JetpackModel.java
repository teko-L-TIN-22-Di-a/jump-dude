package ch.teko.bir.jumpdude.Jetpack;

public class JetpackModel {

    private Jetpack jetpack; 
    private final int groundY;
        
    public JetpackModel(int groundY){
        this.groundY = groundY;
        jetpack = new Jetpack(4000, groundY - 80, 70, 70);
    }

    public Jetpack getJetpack() {
        return jetpack;
    }

    public void disposeJetpack()
    {
        jetpack = new Jetpack(0,0, 0, 0);
    }
}
