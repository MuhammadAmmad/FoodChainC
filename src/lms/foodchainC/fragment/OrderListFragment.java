package lms.foodchainC.fragment;

import java.util.List;

import lms.foodchainC.R;
import lms.foodchainC.dao.Bill_DBHelper;
import lms.foodchainC.data.CaseData;
import lms.foodchainC.widget.OrderAdapter;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * 
 * @author 梦思
 * @description 订单模块
 * @createTime 2014/1/13
 */
public class OrderListFragment extends Fragment implements OnClickListener {
	private Bill_DBHelper bdb;
	private List<CaseData> list;
	private OrderAdapter oa;
	private ListView listView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.orderlist, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		View v = getView();
		listView = (ListView) v.findViewById(R.id.list);
		v.findViewById(R.id.order).setOnClickListener(this);
		new LoadDataTask().execute(getActivity());
		super.onActivityCreated(savedInstanceState);
	}

	private class LoadDataTask extends AsyncTask<Object, Void, String> {
		private Context context;

		@Override
		protected String doInBackground(Object... params) {
			context = (Context) params[0];
			if (bdb == null)
				bdb = new Bill_DBHelper(context);
			list = bdb.getOrderList();
			oa = new OrderAdapter(getActivity(), list);
			listView.setAdapter(oa);
			return null;
		}

	}

	@Override
	public void onClick(View v) {
		sendOrder();
	}

	private void sendOrder() {
		// TODO Auto-generated method stub

	}

	private class SendOrderTask extends AsyncTask<Object, Void, String> {

		@Override
		protected String doInBackground(Object... params) {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
