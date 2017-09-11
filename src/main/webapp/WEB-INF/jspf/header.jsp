<header class="navbar navbar-default navbar-fixed-top">
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
            <a class="navbar-brand total-brand-logo" href="${context}/index.jsp"><fmt:message
                    key="label.main.title"/></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <%--locale--%>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"><fmt:message key="label.lang"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="text-center"><a
                                href="${context}/controller?command=changeLocale&locale=en_US"><fmt:message
                                key="label.language.english"/></a></li>
                        <li class="text-center"><a
                                href="${context}/controller?command=changeLocale&locale=ru_RU"><fmt:message
                                key="label.language.russian"/></a></li>
                    </ul>
                </li>
            </ul>

            <%--sign in & sign up--%>
            <total:guest role="${visitor.role}">
                <form class="navbar-form navbar-right">
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#signUpModal">
                        <fmt:message key="label.sign.up"/>
                    </button>
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#signInModal">
                        <fmt:message key="label.sign.in"/>
                    </button>
                </form>
            </total:guest>

            <total:notguest role="${visitor.role}">

                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false"><fmt:message key="label.settings"/><span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <total:user role="${visitor.role}">
                                <li class="text-center"><a href="${context}/jsp/user/addMoney.jsp"><fmt:message
                                        key="label.add.money"/></a>
                                </li>
                                <li class="text-center"><a href="${context}/jsp/user/betList.jsp"><fmt:message
                                        key="label.my.bets"/></a>
                                </li>
                            </total:user>
                            <li class="text-center"><a href="${context}/jsp/user/editProfile.jsp"><fmt:message
                                    key="label.edit.profile"/></a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li class="text-center"><a href="${context}/controller?command=signOut"><fmt:message
                                    key="label.sign.out"/></a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <total:user role="${visitor.role}">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${context}/jsp/user/addMoney.jsp">${account.money}</a></li>
                    </ul>
                </total:user>

                <ul class="nav navbar-nav navbar-right">
                    <a class="head" data-toggle="modal" data-target="#changeAvatarModal">
                        <img class="img-circle" height="45" width="45"
                             src="${context}/controller?command=loadImage&src=account"
                             alt="Avatar">
                    </a>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${context}/jsp/user/profile.jsp">${account.name} ${account.surname}</a></li>
                </ul>

                <total:admin role="${visitor.role}">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false"><fmt:message key="label.race"/><span
                                    class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="text-center"><a href="${context}/jsp/admin/createRace.jsp"><fmt:message
                                        key="label.create.race"/></a></li>
                            </ul>
                        </li>
                    </ul>
                </total:admin>
            </total:notguest>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</header>

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
                        <label class="control-label col-xs-4"><fmt:message key="label.name"/></label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control inputSignUp" required="required"
                                       name="signUpName"
                                       pattern="^([A-Za-zА-Яа-яЁё]|[0-9])([A-Za-zА-Яа-яЁё]|[0-9]|[_`\s])*$"
                                       placeholder="<fmt:message key="label.name"/>">
                            </div>
                            <span class="glyphicon form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-4"><fmt:message key="label.surname"/></label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control inputSignUp" required="required"
                                       name="signUpSurname"
                                       pattern="^([A-Za-zА-Яа-яЁё]|[0-9])([A-Za-zА-Яа-яЁё]|[0-9]|[_`\s])*$"
                                       placeholder="<fmt:message key="label.surname"/>">
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
                        <label class="control-label col-xs-4"><fmt:message key="label.repeat.password"/></label>
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
</div>

<div class="modal fade" id="signInModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title"><fmt:message key="label.sign.in"/></h4>
            </div>
            <div class="modal-body">
                <form id="signInForm" class="form-horizontal" action="${context}/controller" method="post">
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-4"><fmt:message key="label.username"/></label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control inputSignIn" required="required"
                                       name="signInUsername"
                                       pattern="^[A-Za-zА-Яа-яЁё]([A-Za-zА-Яа-яЁё]|[0-9]|[_])*$"
                                       placeholder="<fmt:message key="label.username"/>">
                            </div>
                            <span class="glyphicon form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-4"><fmt:message key="label.password"/></label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="password" class="form-control inputSignIn" required="required"
                                       name="signInPassword"
                                       pattern="^.*(?=^.{6,}$)(?=.*[A-ZА-ЯЁ]+)(?=.*[a-zа-яё]+)(?=.*[0-9]+).*$"
                                       placeholder="<fmt:message key="label.password"/>">
                            </div>
                            <span class="glyphicon form-control-feedback"></span>
                        </div>
                    </div>
                    <input type="hidden" name="command" value="signIn">
                </form>
            </div>
            <div class="modal-footer">
                <div class="alert alert-danger hidden" id="error-alert-sign-in">
                    <div><fmt:message key="message.sign.in.incorrect.username.or.password"/></div>
                </div>
                <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message
                        key="label.close"/></button>
                <button type="submit" id="saveSignIn" form="signInForm" class="btn btn-primary"><fmt:message
                        key="label.sign.in"/></button>
            </div>
        </div>
    </div>
</div>

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
                         src="${context}/controller?command=loadImage&src=account"
                         alt="Avatar">
                </h4>
                <h4 class="text-center">
                    <form id="changeAvatarForm" action="${context}/controller" method="post"
                          enctype="multipart/form-data">
                        <div class="form-group-lg">
                            <input id="changeAvatar" type="file" name="avatar" class="form-control">
                        </div>
                        <input type="hidden" name="command" value="changeAvatar">
                    </form>
                </h4>
            </div>
            <div class="modal-footer">
                <form id="resetAvatarForm" action="${context}/controller" method="post">
                    <button type="submit" class="btn btn-default pull-left" name="command"
                            value="resetAvatar">
                        <fmt:message key="label.reset"/></button>
                    <button type="submit" form="changeAvatarForm" name="command" value="changeAvatar"
                            class="btn btn-primary pull-right"><fmt:message
                            key="label.submit"/></button>
                </form>
            </div>
        </div>
    </div>
</div>
