package io.hotmoka.android.mokito.view

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import io.hotmoka.android.mokito.controller.Controller
import io.hotmoka.android.mokito.model.Model

abstract class AbstractDialogFragment: DialogFragment() {

    companion object {
        const val TAG = "AbstractDialogFragment"
    }

    override fun getContext(): Mokito {
        return super.getContext() as Mokito
    }

    protected fun getController(): Controller {
        return context.applicationContext.controller
    }

    protected fun getModel(): Model {
        return context.applicationContext.model
    }

    protected fun notifyException(t: Throwable) {
        var t2: Throwable = t
        var cause = t2.cause
        while (cause != null) {
            t2 = cause
            cause = t2.cause
        }

        Log.d(TAG, "action failed with the following exception", t)
        Toast.makeText(context, t2.message, Toast.LENGTH_LONG).show()
    }

    protected fun notifyUser(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}