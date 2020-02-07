package uk.gov.dwp.jsa.officesearch.service.models.http.api;

import java.net.URI;

public class ApiSuccess<T> {
    private URI path;
    private T data;

    public ApiSuccess(final URI path, final T data) {
        this.path = path;
        this.data = data;
    }

    public URI getPath() {
        return path;
    }

    public void setPath(final URI path) {
        this.path = path;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }
}
