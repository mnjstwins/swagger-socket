/**
 *  Copyright 2016 SmartBear Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.swagger.swaggersocket.protocol;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Response extends ProtocolBase {
    private String uuid;
    private boolean last;
    private String path;
    private int status;
    private String reasonPhrase;

    public Response() {}

    private Response(Builder b) {
        uuid = b.uuid;
        last = b.last;
        path = b.path;
        status = b.status;
        headers = b.headers;
        messageBody = b.messageBody;
        reasonPhrase = b.reasonPhrase;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getStatusCode() {
        return status;
    }

    public void setStatusCode(int status) {
        this.status = status;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public final static class Builder {
        private String uuid = UUID.randomUUID().toString();
        private boolean last;
        private String path = "/";
        private String reasonPhrase;
        private int status;
        private final List<Header> headers = new ArrayList<Header>();
        private Object messageBody;

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder last(boolean last) {
            this.last = last;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder status(int status, String reasonPhrase) {
            this.status = status;
            this.reasonPhrase = reasonPhrase;
            return this;
        }

        public Builder header(Header header) {
            headers.add(header);
            return this;
        }

        public Builder body(Object messageBody) {
            this.messageBody = messageBody;
            return this;
        }

        public Response build() {
            return new Response(this);
        }
    }
}
