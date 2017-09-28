<header class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand pandora-brand-logo" href="${contextPath}/main">Pandora</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <%--locale--%>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"><fmt:message key="locale.name.language"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="text-center"><a
                                href="${contextPath}/locale?locale=en_US"><fmt:message
                                key="label.language.english"/></a></li>
                        <li class="text-center"><a
                                href="${contextPath}/locale?locale=ru_RU"><fmt:message
                                key="label.language.russian"/></a></li>
                    </ul>
                </li>
            </ul>

            <%--theme--%>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"><fmt:message key="label.theme"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="text-center"><a
                                href="${contextPath}/theme?theme=light"><fmt:message key="label.theme.light"/></a></li>
                        <li class="text-center"><a
                                href="${contextPath}/theme?theme=dark"><fmt:message key="label.theme.dark"/></a></li>
                    </ul>
                </li>
            </ul>

            <%--sign out--%>
            <roles:notguest principal="${pageContext.request.userPrincipal}">
                <form class="navbar-form navbar-right" id="logoutForm" method="POST" action="${contextPath}/logout">
                    <button type="submit" class="btn btn-default"><fmt:message key="label.sign.out"/></button>
                </form>
            </roles:notguest>


            <%--sign in & sign up--%>
            <roles:guest principal="${pageContext.request.userPrincipal}">
                <form class="navbar-form navbar-right">
                    <button type="button" class="btn btn-default"
                            onclick="location.href = '${contextPath}/registration'">
                        <fmt:message key="label.sign.up"/>
                    </button>

                    <button type="button" class="btn btn-default" id="signInButton"
                            data-toggle="modal" data-target="#signInModal">
                        <fmt:message key="label.sign.in"/>
                    </button>
                </form>
            </roles:guest>

            <%--options--%>
            <roles:notguest principal="${pageContext.request.userPrincipal}">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false"><fmt:message key="label.options"/><span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <roles:user principal="${pageContext.request.userPrincipal}">
                                <li class="text-center">
                                    <a href="${contextPath}/verifyAccount"><fmt:message key="label.verify.account"/></a>
                                </li>
                                <li role="separator" class="divider"></li>
                            </roles:user>
                            <li class="text-center">
                                <a href="${contextPath}/logout"><fmt:message key="label.sign.out"/></a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </roles:notguest>

            <%--project--%>
            <roles:verified principal="${pageContext.request.userPrincipal}">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false"><fmt:message key="label.projects"/><span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li class="text-center">
                                <a href="${contextPath}/newProject"><fmt:message key="label.project.new"/></a>
                            </li>
                            <li class="text-center">
                                <a href="${contextPath}/myProjects"><fmt:message key="label.projects.mine"/></a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </roles:verified>

            <%--username--%>
            <roles:notguest principal="${pageContext.request.userPrincipal}">
                <ul class="nav navbar-nav navbar-right">
                    <li class="text-center">
                        <a href="${contextPath}/main">${pageContext.request.userPrincipal.getName()}</a>
                    </li>
                </ul>
            </roles:notguest>


            <%--avatar--%>
            <roles:notguest principal="${pageContext.request.userPrincipal}">
                <ul class="nav navbar-nav navbar-right">
                    <a class="head" data-toggle="modal" data-target="#changeAvatarModal">
                        <img class="img-circle" height="45" width="45"
                             src="${contextPath}/user/loadAvatar"
                             alt="Avatar">
                    </a>
                </ul>
            </roles:notguest>

            <%--admin page--%>
            <roles:admin principal="${pageContext.request.userPrincipal}">
                <ul class="nav navbar-nav navbar-left">
                    <li class="text-center">
                        <a href="${contextPath}/admin"><fmt:message key="label.admin.page"/></a>
                    </li>
                </ul>
            </roles:admin>


        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</header>
<roles:guest principal="${pageContext.request.userPrincipal}">
    <div class="modal fade" id="signInModal" tabindex="-1" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="POST" action="${contextPath}/login" class="form-signin">
                        <h2 class="form-heading"><fmt:message key="label.sign.in"/></h2>
                        <div class="form-group ${error != null ? 'has-error' : ''}">
                                <%--<span>${message}</span>--%>
                            <input name="username"
                                   type="email"
                                   class="form-control"
                                   placeholder="<fmt:message key="label.email.example"/>"/>
                            <input name="password"
                                   type="password"
                                   class="form-control"
                                <%--pattern="^.*(?=^.{6,}$)(?=.*[a-zа-яё]+)(?=.*[0-9]+).*$"--%>
                                   placeholder="<fmt:message key="label.password"/>"/>
                            <span>${error}</span>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                <fmt:message key="label.sign.in"/>
                            </button>
                        </div>
                    </form>
                        <%--(?=.*[A-ZА-ЯЁ]+)--%>
                </div>
            </div>
        </div>
    </div>
</roles:guest>

<roles:notguest principal="${pageContext.request.userPrincipal}">
    <div class="modal fade" id="changeAvatarModal" tabindex="-1" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title"><fmt:message key="label.avatar"/></h4>
                </div>
                <div class="modal-body">
                    <h4 class="text-center">
                        <img class="img-circle" height="300" width="300"
                             src="${contextPath}/user/loadAvatar"
                             alt="Avatar">
                    </h4>
                    <h4 class="text-center">
                        <form id="changeAvatarForm" action="${contextPath}/user/changeAvatar" method="post"
                              enctype="multipart/form-data">
                            <div class="form-group-lg">
                                <input id="changeAvatar" type="file" name="avatar" class="form-control">
                            </div>
                        </form>
                    </h4>
                </div>
                <div class="modal-footer">
                    <form id="resetAvatarForm" action="${contextPath}/user/resetAvatar" method="post">
                        <button type="submit" class="btn btn-default pull-left">
                            <fmt:message key="label.reset"/></button>
                        <button type="submit" form="changeAvatarForm"
                                class="btn btn-primary pull-right"><fmt:message
                                key="label.submit"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</roles:notguest>

<%---------------%>
<%--
<div class="modal fade" id="signUpModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title"><fmt:message key="label.sign.up"/></h4>
            </div>
            <div class="modal-body">
                <form id="signUpForm" class="form-horizontal" action="${context}/controller" method="post">
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-4"><fmt:message key="label.first.name"/></label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control inputSignUp" required="required"
                                       name="signUpName"
                                       pattern="^([A-Za-zА-Яа-яЁё]|[0-9])([A-Za-zА-Яа-яЁё]|[0-9]|[_`\s])*$"
                                       placeholder="<fmt:message key="label.first.name"/>">
                            </div>
                            <span class="glyphicon form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-4"><fmt:message key="label.last.name"/></label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control inputSignUp" required="required"
                                       name="signUpSurname"
                                       pattern="^([A-Za-zА-Яа-яЁё]|[0-9])([A-Za-zА-Яа-яЁё]|[0-9]|[_`\s])*$"
                                       placeholder="<fmt:message key="label.last.name"/>">
                            </div>
                            <span class="glyphicon form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-4"><fmt:message key="label.username"/></label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control inputSignUp" required="required"
                                       name="signUpUsername"
                                       pattern="^[A-Za-zА-Яа-яЁё]([A-Za-zА-Яа-яЁё]|[0-9]|[_])*$"
                                       placeholder="Username_007">
                            </div>
                            <span class="glyphicon form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-4"><fmt:message key="label.email"/></label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="email" class="form-control inputSignUp" required="required"
                                       name="signUpEmail"
                                       placeholder="example@mail.com">
                            </div>
                            <span class="glyphicon form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-4"><fmt:message key="label.password"/></label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="password" class="form-control inputSignUp " required="required"
                                       name="signUpPassword"
                                       id="signUpPassword"
                                       pattern="^.*(?=^.{6,}$)(?=.*[A-ZА-ЯЁ]+)(?=.*[a-zа-яё]+)(?=.*[0-9]+).*$"
                                       placeholder="Password1234">
                            </div>
                            <span class="glyphicon form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-4"><fmt:message key="label.confirm.password"/></label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="password" class="form-control inputSignUp" required="required"
                                       name="signUpRepeatPassword"
                                       id="signUpRepeatPassword"
                                       pattern="^.*(?=^.{6,}$)(?=.*[A-ZА-ЯЁ]+)(?=.*[a-zа-яё]+)(?=.*[0-9]+).*$"
                                       placeholder="Password1234">
                            </div>
                            <span class="glyphicon form-control-feedback"></span>
                        </div>
                    </div>
                    <input type="hidden" name="command" value="signUp">
                </form>
            </div>
            <div class="modal-footer">
                <div class="alert alert-danger hidden" id="error-alert-sign-up-passwords-not-match">
                    <div><fmt:message key="message.sign.up.passwords.not.match"/></div>
                </div>
                <div class="alert alert-danger hidden" id="error-alert-sign-up-password-symbols">
                    <div><fmt:message key="message.sign.up.password.symbols"/></div>
                </div>
                <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message
                        key="label.close"/></button>
                <button type="submit" id="saveSignUp" form="signUpForm" class="btn btn-primary"><fmt:message
                        key="label.sign.up"/></button>
            </div>
        </div>
    </div>
</div>--%>