package co.shrey.fireapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

/**
 * Created by shrey on 05-06-2018.
 */

public class Recyclerclick extends AppCompatActivity{
    private static final String TAG = "Recyclerclick";
    UserInformation userInformation=new UserInformation();
    TextView name_tv,address_tv,age_tv;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    static Bundle mBundleRecyclerViewState;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    LinearLayoutManager mLayoutmanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        name_tv = (TextView) findViewById(R.id.name);
        address_tv = (TextView) findViewById(R.id.address);
        age_tv = (TextView) findViewById(R.id.age);
        userInformation= (UserInformation) getIntent().getSerializableExtra("data");
        initView();
    }


    private void initView() {
        name_tv.setText(userInformation.getName());
        address_tv.setText(userInformation.getAddress());
        age_tv.setText(userInformation.getAge());
    }

}



