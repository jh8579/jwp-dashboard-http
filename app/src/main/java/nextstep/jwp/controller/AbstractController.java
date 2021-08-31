package nextstep.jwp.controller;

import java.io.FileNotFoundException;

import nextstep.jwp.handler.request.HttpRequest;
import nextstep.jwp.handler.response.HttpResponse;

public abstract class AbstractController implements Controller {

    @Override
    public void handle(HttpRequest httpRequest, HttpResponse httpResponse) throws FileNotFoundException {
        if (httpRequest.isGet()) {
            doGet(httpRequest, httpResponse);
        }

        if (httpRequest.isPost()) {
            doPost(httpRequest, httpResponse);
        }
    }

    protected abstract void doGet(HttpRequest httpRequest, HttpResponse httpResponse) throws FileNotFoundException;

    protected abstract void doPost(HttpRequest httpRequest, HttpResponse httpResponse) throws FileNotFoundException;
}
