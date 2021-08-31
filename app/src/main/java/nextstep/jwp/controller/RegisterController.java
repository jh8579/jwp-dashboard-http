package nextstep.jwp.controller;

import java.io.FileNotFoundException;

import nextstep.jwp.db.InMemoryUserRepository;
import nextstep.jwp.handler.HttpBody;
import nextstep.jwp.handler.request.HttpRequest;
import nextstep.jwp.handler.response.HttpResponse;
import nextstep.jwp.model.User;
import nextstep.jwp.util.File;
import nextstep.jwp.util.FileReader;

public class RegisterController extends AbstractController {

    @Override
    protected void doGet(HttpRequest httpRequest, HttpResponse httpResponse) throws FileNotFoundException {
        File file = FileReader.readHtmlFile(httpRequest.getRequestUrl());
        httpResponse.ok(file);
    }

    @Override
    protected void doPost(HttpRequest httpRequest, HttpResponse httpResponse) throws FileNotFoundException {
        HttpBody httpBody = httpRequest.getBody();
        String account = httpBody.getBodyParams("account");
        String email = httpBody.getBodyParams("email");
        String password = httpBody.getBodyParams("password");
        User user = new User(InMemoryUserRepository.assignId(), account, password, email);
        InMemoryUserRepository.save(user);

        File file = FileReader.readFile("/index.html");
        httpResponse.redirect("/index.html", file);
    }
}
