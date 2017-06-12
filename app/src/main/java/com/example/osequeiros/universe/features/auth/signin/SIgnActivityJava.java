package com.example.osequeiros.universe.features.auth.signin;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.osequeiros.universe.R;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.regex.Pattern;

import io.reactivex.Observable;


/**
 * Created by osequeiros on 11/06/17.
 * Java Rx
 */

public class SIgnActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        /*EditText editUser = (EditText) findViewById(R.id.edit_login_user);
        EditText editPass = (EditText) findViewById(R.id.edit_login_password);
        Button btnSignIn = (Button) findViewById(R.id.btn_login_mail);

        Observable<CharSequence> userNameText = RxTextView.textChanges(editUser);

        userNameText.filter( e -> e.toString().length() > 4)
                .subscribe( e -> Log.d("[Rx]", e.toString()));

        final Pattern emailPattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); // ..... [1]

        Observable<Boolean> emailValid = RxTextView.textChanges(editUser)
                .map(t -> emailPattern.matcher(t).matches());

        emailValid.distinctUntilChanged()
                .doOnNext( b -> Log.d("[Rx]", "Email " + (b ? "Valid" : "Invalid")))
                .map(b -> b ? Color.BLACK : Color.RED)
                .subscribe( color -> editUser.setTextColor(color));     // ... [3]

        Observable<Boolean> userPassValid = RxTextView.textChanges(editPass) //  [2]
                .map(t -> t.length() > 4);

        userPassValid.distinctUntilChanged()
                .doOnNext( b -> Log.d("[Rx]", "pass " + (b ? "Valid" : "Invalid")))
                .map( b -> b ? Color.BLACK : Color.RED)
                .subscribe(color -> editPass.setTextColor(color));

        Observable<Boolean> signInEnabled =
                Observable.combineLatest(emailValid, userPassValid, (a,b) -> a && b);

        signInEnabled.distinctUntilChanged()
                .doOnNext( b -> Log.d("[Rx]", "Button " + (b ? "Valid" : "Invalid")))
                .subscribe( enabled -> btnSignIn.setEnabled(enabled));*/
    }
}
