import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;


import java.util.HashMap;

import static akka.actor.TypedActor.self;

public class CacheActor extends AbstractActor {

        private HashMap  <String, Long> store = new HashMap<>();
        //id res
    //создаем в actorSystem — актор который принимает две команды — поиск
        //уже готового результата тестирования и результат тестрования.
        @Override
        public AbstractActor.Receive createReceive() {
            return ReceiveBuilder.create()
                    .match(SearchResult.class, m -> {
                        String url = m.getURL();
                        Long count = (long) m.getCount();
                        if (store.containsKey(m.getURL())) {
                            sender().tell(new TestResult(m.getURL(), count), self());
                        }
                        else sender().tell(new TestResult(m.getURL(), -1l), self());

                    })
                    .match(TestResult.class, m -> {
                        store.put(m.getURL(), m.getTime());
                    })
            .build();

    }

    


}
