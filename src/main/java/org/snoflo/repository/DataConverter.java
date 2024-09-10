package org.snoflo.repository;

import java.io.IOException;
import java.util.List;

public interface DataConverter<T> {

    <T> List<T> convertData() throws IOException; 

    <T> T createDomainFromRow (String[] row); 

    List<T> getData();
}
