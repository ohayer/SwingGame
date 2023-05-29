package start;

import repository.UserRepository;

public class Running {

    public static void main(String[] args) {
        //new MenuSwitch();
       UserRepository userRepo = new UserRepository();
       String name = "Mariola";
       int points = 0;
       userRepo.createNewUser(name, points);
        System.out.println("XD");
    }
}
