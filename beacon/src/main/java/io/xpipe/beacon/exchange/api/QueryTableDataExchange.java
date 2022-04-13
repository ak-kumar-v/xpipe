package io.xpipe.beacon.exchange.api;

import io.xpipe.beacon.exchange.MessageExchange;
import io.xpipe.beacon.message.RequestMessage;
import io.xpipe.beacon.message.ResponseMessage;
import io.xpipe.core.source.DataSourceReference;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/**
 * Queries data of a table data source in the xpbt format.
 */
public class QueryTableDataExchange implements MessageExchange<QueryTableDataExchange.Request, QueryTableDataExchange.Response> {

    @Override
    public String getId() {
        return "queryTableData";
    }

    @Override
    public Class<QueryTableDataExchange.Request> getRequestClass() {
        return QueryTableDataExchange.Request.class;
    }

    @Override
    public Class<QueryTableDataExchange.Response> getResponseClass() {
        return QueryTableDataExchange.Response.class;
    }

    @Jacksonized
    @Builder
    @Value
    public static class Request implements RequestMessage {
        @NonNull
        DataSourceReference ref;

        int maxRows;
    }

    @Jacksonized
    @Builder
    @Value
    public static class Response implements ResponseMessage {
    }
}
