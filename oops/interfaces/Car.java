

public class Car implements Engine, Brake, Media {
    
    @Override
    public void start(){
        System.out.println("start from car");
    }
    @Override
    public void stop(){
        System.out.println("stop from car");
    }
    @Override
    public void acc(){
        System.out.println("acc from car");
    }
    @Override
    public void brake(){
        System.out.println("brake from car");
    }
    @Override
    public void play(){
        System.out.println("play from car");
    }
    @Override
    public void resume(){
        System.out.println("resume from car");
    }
}
