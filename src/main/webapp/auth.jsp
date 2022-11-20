<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="quest.com.controller.Route" %>
<jsp:include page="templates/head.jsp"/>
<jsp:include page="templates/header.jsp"/>

<div class="container">
    <ul class="nav nav-tabs mt-5" is="auth-tabs" role="tablist">
        <li class="nav-item" role="presintation">
            <button class="nav-link active" id="sign-up-tab" data-bs-toggle="tab" data-bs-target="#sign-up-tab-pane" type="button" role="tab">
                Регистрация
            </button>
        </li>
        <li class="nav-item" role="presintation">
            <button class="nav-link" id="sign-in-tab" data-bs-toggle="tab" data-bs-target="#sign-in-tab-pane" type="button" role="tab">
                Войти
            </button>
        </li>
    </ul>
    <div class="tab-content" id="auth-content" style="width: 500px;">
        <div class="tab-pane fade show active p-3" id="sign-up-tab-pane" role="tabpanel" tabindex="0">
            <form action="<%=Route.SIGN_UP%>" method="post">
                <div class="mb-3">
                    <label for="sign-up-name" class="form-label">Имя</label>
                    <input type="text" name="name" class="form-control" id="sign-up-name" required>
                </div>
                <div class="mb-3">
                    <label for="sign-up-password" class="form-label">Пароль</label>
                    <input type="password" name="password" class="form-control" id="sign-up-password" required>
                </div>

                <button type="submit" class="btn btn-primary">Регистрация</button>
            </form>
        </div>

        <div class="tab-pane fade p-3" id="sign-in-tab-pane" role="tabpanel" tabindex="0">
            <form action="<%=Route.SIGN_IN%>" method="post">
                <div class="mb-3">
                    <label for="sign-in-name" class="form-label">Имя</label>
                    <input type="text" name="name" class="form-control" id="sign-in-name" required>
                </div>
                <div class="mb-3">
                    <label for="sign-in-password" class="form-label">Пароль</label>
                    <input type="password" name="password" class="form-control" id="sign-in-password" required>
                </div>
                <button type="submit" class="btn btn-primary">Войти</button>
            </form>
        </div>
    </div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<jsp:include page="templates/footer.jsp"/>
