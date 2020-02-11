import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;


import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static akka.actor.TypedActor.self;

public class CacheActor extends AbstractActor {

    private List<String> serversList;
        @Override
        public Receive createReceive() {
            return ReceiveBuilder.create()
                    .match(Servers.class, m -> {
                        System.out.println("Servers updated");
                        serversList = m.getSeverList();
                    })
                    .match(CacheActor.class, m -> {
                        int randServerIdx = new Random().nextInt(serversList.size());

                    })
            .build();

    }

    


}
