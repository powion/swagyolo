package biz.swagyolo.mail.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface CrewDAO {

    @SqlQuery("select swagmail from crew where id = :id")
    String findSwagMailById(@Bind("id") String id);

}
