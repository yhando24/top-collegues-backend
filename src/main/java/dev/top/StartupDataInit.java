package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VersionRepo;

@Component
public class StartupDataInit {

    @Autowired
    VersionRepo versionRepo;

    @Autowired
    CollegueRepo collegueRepo;
    
    @EventListener(ContextRefreshedEvent.class)
    public void init() {

        
        this.versionRepo.save(new Version("v1"));
        this.versionRepo.save(new Version("v2"));
        this.versionRepo.save(new Version("v3"));
        this.versionRepo.save(new Version("v5"));
        
        this.collegueRepo.save(new Collegue(1,500,"https://media.licdn.com/dms/image/C4E03AQFlHrZpdWLrCg/profile-displayphoto-shrink_200_200/0?e=1559174400&v=beta&t=x_w8Y3288kZDjGLS-Yhs9TTQpy25iOBynGdwhZga69A","Handoura", "8b2d3ac7", "Youcef", "Youcef.handoura@gmail.com", "1 rue des flamants roses 34000 Montpellier"));
        this.collegueRepo.save(new Collegue(2, 500, "https://media.licdn.com/dms/image/C4D03AQGbtRrqkhoGCA/profile-displayphoto-shrink_800_800/0?e=1559174400&v=beta&t=M9y5GcnnnFNfSst9CUZsB8ZLmuFaiYtamA-psGaeDWI", "Mercadier", "6c8be60e", "yoaan", "PLop.plop@gmail.com", "1 rue des plop plopeur 34000 Quelquepart"));

    }
}
