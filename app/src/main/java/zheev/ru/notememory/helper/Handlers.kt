package zheev.ru.notememory.helper

import android.content.Context
import androidx.fragment.app.FragmentActivity
import zheev.ru.notememory.dialogs.DialogAddNote

class Handlers : FragmentActivity() {

    public fun note(context: Context)
    {
        val dialog = DialogAddNote()
        dialog.show(supportFragmentManager, "custom")

    }
}