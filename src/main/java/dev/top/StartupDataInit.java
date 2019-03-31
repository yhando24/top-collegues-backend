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
        this.collegueRepo.save(new Collegue(1,200,"https://media.licdn.com/dms/image/C4E03AQFlHrZpdWLrCg/profile-displayphoto-shrink_200_200/0?e=1559174400&v=beta&t=x_w8Y3288kZDjGLS-Yhs9TTQpy25iOBynGdwhZga69A","youcef", "8b2d3ac7"));
        this.collegueRepo.save(new Collegue(2, 200, "https://media.licdn.com/dms/image/C4D03AQGbtRrqkhoGCA/profile-displayphoto-shrink_800_800/0?e=1559174400&v=beta&t=M9y5GcnnnFNfSst9CUZsB8ZLmuFaiYtamA-psGaeDWI", "yoann", "6c8be60e"));

    }
}
