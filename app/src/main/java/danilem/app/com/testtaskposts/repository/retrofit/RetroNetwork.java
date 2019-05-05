package danilem.app.com.testtaskposts.repository.retrofit;

import java.io.IOException;

import danilem.app.com.testtaskposts.repository.models.responses.model.Model;
import danilem.app.com.testtaskposts.repository.models.responses.post_model.Post;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroNetwork {
    private OkHttpClient client;
    private Retrofit retrofit;
    private InratingApi mInrating_api;

    public static final String id = "254";
    public static final String slug = "59b674fc2647b";
    private static final String BASE_URL = "https://api.inrating.top/v1/";
    private static final String token =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjJmNGU5ZDA1MzU3MDI3MmFlMGZhZTMzM2Y4ZTY4" +
            "ZWVlMWNiMzc0NmM0Mjg5NzI0ZTExNzJjM2Q4ODYzNDNkNDkyY2ZjZjI4Njg0NzQ0MGEwIn0.eyJhdWQiOiIy" +
            "IiwianRpIjoiMmY0ZTlkMDUzNTcwMjcyYWUwZmFlMzMzZjhlNjhlZWUxY2IzNzQ2YzQyODk3MjRlMTE3MmMz" +
            "ZDg4NjM0M2Q0OTJjZmNmMjg2ODQ3NDQwYTAiLCJpYXQiOjE1MzY4MzE4ODcsIm5iZiI6MTUzNjgzMTg4Nywi" +
            "ZXhwIjoxNTY4MzY3ODg3LCJzdWIiOiIzOCIsInNjb3BlcyI6W119.dRitRnoqNFS3xUgtLdLiDjDVVe7ZFNr" +
            "h24Qm2ML9m-V7kZpgQgajArYoS44kMa1dz_MHUhq3pqk8SnAYIsULgfrOvewTUzmH1C92-yL64Uqnv7lqWiz" +
            "ldX2fbJ2IbB8khOCtQ-CCNA_fGY_zEBJXLsOqr4Z00tbZE6fa0PX4Mu0SsuUakLeygXbXnKOmFyZmLJZWoXK" +
            "pbqiSBU239nrcyqJftBon8DL1BAUuFiadap-gpVSXj8h6BX-FsJx5cgPHFiijIalcEgzOq4VCMkwbQE8xbTs" +
            "mmxkZUOnM7oKab5inzl8EV5iUgcExeSbHT6k_phOkA7XUaR6PhVoKrSQTPcfdijhME1IHfPVDPGO0vhd6hKs" +
            "zRrhjEPEpoothBoB8ss0lmuCFURdxFv17q97rfpDn1OfO_Y3wYuRW2lqFAnw7sLd92CHjfONwQKswLDzwE4h" +
            "iQhB8iS_UEbuL_UamNOiCLfjNnVWbVc9BvoReEa8jG4coc0Kv9VNJVWh3D_hGf8dLRZBd1a7zB6-nSpKGf0e" +
            "AzB0_rBXsyBepjudC-5EFDjloJOxy1Mdruoq6mQa_tFcO99JRteUSd0CXHZO-CN4Bp4xND9kstdutjBn2UWT" +
            "5xhNq_QRBmBsBDAwp647dUCyQofutN9GUlu2LxmhL0ojydazdND_d9rHtY9t-ndw";

    public RetroNetwork() {
        clientCreator();
        retrofitCreator();
    }

    private void clientCreator(){
        client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
    }

    private void retrofitCreator(){
        retrofit = new Retrofit
                .Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mInrating_api = retrofit.create(InratingApi.class);
    }

    public Call<Post> getPost(String slug){
        return mInrating_api.getPost(slug);
    }

    public Call<Model> getLikers(String id){
        return mInrating_api.getLikers(id);
    }

    public Call<Model> getReposters(String id){
        return mInrating_api.getReposters(id);
    }

    public Call<Model> getCommentators(String id){
        return mInrating_api.getCommentators(id);
    }

    public Call<Model> getMentions(String id){
        return mInrating_api.getMentions(id);
    }

}
