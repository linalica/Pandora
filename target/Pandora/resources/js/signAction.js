$(function () {
    $('#saveSignIn').click(function () {
        var formValid = true;
        $('.inputSignIn').each(function () {
           var formGroup = $(this).parents('.form-group');
            /* glyphicon needs for success or error icon */
            var glyphicon = formGroup.find('.form-control-feedback');
            if (this.checkValidity()) {
                /* mark as success */
                formGroup.addClass('has-success').removeClass('has-error');
                glyphicon.addClass('glyphicon-ok').removeClass('glyphicon-remove');
            } else {
                /* mark as error */
                formGroup.addClass('has-error').removeClass('has-success');
                glyphicon.addClass('glyphicon-remove').removeClass('glyphicon-ok');
                formValid = false;
            }
        });
        if (formValid) {
            /* hide modal window */
            $('#signInModal').modal('hide');
            /* hide sign in message */
            $('#error-alert-sign-in').addClass('hidden');
        } else {
            /* open sign in message */
            $('#error-alert-sign-in').removeClass('hidden');
        }
    });



    $('#saveSignUp').click(function () {
        var formValid = true;
        var passwordsMatch = false;

        if (document.getElementById("signUpPassword").value && document.getElementById("signUpRepeatPassword").value) {
            var passValue = document.getElementById("signUpPassword").value;
            var repPassValue = document.getElementById("signUpRepeatPassword").value;
            if (passValue == repPassValue) {
                passwordsMatch = true;
            } else {
                /* open password match message */
                $('#error-alert-sign-up-passwords-not-match').removeClass('hidden');
            }
        }
        if (passwordsMatch) {
            /* hide password match message */
            $('#error-alert-sign-up-passwords-not-match').addClass('hidden');
        }
        /* sort all input elements */
        $('.inputSignUp').each(function () {
            var formGroup = $(this).parents('.form-group');
            /* glyphicon needs for success or error icon */
            var glyphicon = formGroup.find('.form-control-feedback');

            if (this.checkValidity()) {
                if (this.getAttribute("name") == "signUpPassword") {
                    /* hide password symbols message */
                    $('#error-alert-sign-up-password-symbols').addClass('hidden');
                }
                if (this.getAttribute("name") == "signUpRepeatPassword" && !passwordsMatch) {
                    /* mark as error */
                    formGroup.addClass('has-error').removeClass('has-success');
                    glyphicon.addClass('glyphicon-remove').removeClass('glyphicon-ok');
                    formValid = false;
                } else {
                    /* mark as success */
                    formGroup.addClass('has-success').removeClass('has-error');
                    glyphicon.addClass('glyphicon-ok').removeClass('glyphicon-remove');
                }

            } else {
                if (this.getAttribute("name") == "signUpPassword") {
                    if (document.getElementById("signUpPassword").value) {
                        /* open password symbols message */
                        $('#error-alert-sign-up-password-symbols').removeClass('hidden');
                    }
                }
                /* mark as error */
                formGroup.addClass('has-error').removeClass('has-success');
                glyphicon.addClass('glyphicon-remove').removeClass('glyphicon-ok');
                formValid = false;
            }
        });
        if (formValid) {
            $('#signUpModal').modal('hide');
        }
    });

});