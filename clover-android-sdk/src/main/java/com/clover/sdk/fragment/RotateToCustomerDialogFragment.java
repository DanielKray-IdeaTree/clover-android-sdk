package com.clover.sdk.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.clover.android.sdk.R;
import com.clover.sdk.internal.util.Strings;
import com.clover.sdk.util.Platform;

/**
 * Created by lausier on 10/29/13.
 */
public class RotateToCustomerDialogFragment extends DialogFragment {

  private static final String TAG = RotateToCustomerDialogFragment.class.getSimpleName();
  private static final String EXTRA_INSTRUCTION = "instruction";

  private RotateToCustomerDialogFragment() {
    super();
  }

  public static RotateToCustomerDialogFragment newInstance(String instruction) {
    RotateToCustomerDialogFragment f = new RotateToCustomerDialogFragment();

    Bundle args = new Bundle();
    args.putString(EXTRA_INSTRUCTION, instruction);
    f.setArguments(args);

    return f;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Pick a style based on the num.
    int style = DialogFragment.STYLE_NORMAL, theme = R.style.DialogThemeNoWindow;
    setCancelable(false);
    setStyle(style, theme);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.rotate_to_customer_dialog_fragment, container, false);

    String text = getArguments().getString(EXTRA_INSTRUCTION);
    if (!Strings.isNullOrEmpty(text)) {
      ((TextView) v.findViewById(R.id.instruction)).setText(text);
    }

    v.setTag(TAG);
    return v;
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Override
  public void onStart() {
    if (Platform.get() == Platform.C200) {
      getDialog().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
          WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

      super.onStart();

      int uiOptions = getDialog().getWindow().getDecorView().getSystemUiVisibility();
      getDialog().getWindow().getDecorView().setSystemUiVisibility(uiOptions
          | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
          | 0x00001000); // View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY use constant when compiling with 19 or greater

      // Set the dialog to focusable again.
      getDialog().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    } else {
      // station
      super.onStart();
      getDialog().getWindow().getDecorView().findViewById(android.R.id.content).setSystemUiVisibility(0x10000000);  // magic :)
    }
  }
}

