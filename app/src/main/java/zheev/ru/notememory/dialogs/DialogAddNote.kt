package zheev.ru.notememory.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import zheev.ru.notememory.R
import java.lang.IllegalStateException


class DialogAddNote : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
              AlertDialog.Builder(activity)
                    .setView(R.layout.dialog_add_note)
                    .create()

        } ?: throw IllegalStateException("Activity cannot be null")

    }
}