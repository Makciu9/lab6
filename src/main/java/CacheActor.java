import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;


import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static akka.actor.TypedActor.self;

public class CacheActor extends AbstractActor {

    private List<String> serversList;

    public static Props props() {
        return Props.create(CacheActor.class);
    }

    @Override
        public Receive createReceive() {
            return ReceiveBuilder.create()
                    .match(Servers.class, m -> {
                        System.out.println("Servers updated");
                        serversList = m.getSeverList();
                    })
                    .match(CacheActor.class, m -> {
                        int randServerIdx = new Random().nextInt(serversList.size());
                        String randServer = serversList.get(randServerIdx);
                        System.out.println(randServer);
                        sender().tell(randServer, self());
                    })
            .build();

    }


    public class GetRandomServer {
    }
}
