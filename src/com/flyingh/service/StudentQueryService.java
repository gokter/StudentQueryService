package com.flyingh.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;

import com.flyingh.aidl.StudentQuery;

public class StudentQueryService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new StudentQuery.Stub() {
			private final SparseArray<String> sa = new SparseArray<String>();
			{
				sa.put(1, "A");
				sa.put(2, "B");
				sa.put(3, "C");
				sa.put(4, "D");
				sa.put(5, "E");
			}

			@Override
			public String query(int id) throws RemoteException {
				return sa.get(id);
			}
		};
	}

}
