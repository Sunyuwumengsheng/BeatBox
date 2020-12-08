package com.example.beatbox.api.intercepts;

import androidx.annotation.NonNull;

import com.example.beatbox.mmkv.MmkvTools;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.beatbox.global.GlobalData.COOKIE;


/**
 * @author STY
 */
public class SaveLoginInterceptor implements Interceptor {


    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request req = chain.request();

        Response response = chain.proceed(req);
        if (!response.headers(COOKIE).isEmpty()){
            List<String> cookies = response.headers("Set-Cookie");
            MmkvTools.getInstance().setString(COOKIE,encodeCookie(cookies));
        }
        return response;
    }
    private String encodeCookie(List<String> cookies) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (String cookie : cookies) {
            String[] arr = cookie.split(";");
            for (String s : arr) {
                if (set.contains(s)) {
                    continue;
                }
                set.add(s);

            }
        }

        for (String cookie : set) {
            sb.append(cookie).append(";");
        }

        int last = sb.lastIndexOf(";");
        if (sb.length() - 1 == last) {
            sb.deleteCharAt(last);
        }

        return sb.toString();
    }
}
