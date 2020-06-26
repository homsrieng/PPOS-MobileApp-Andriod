import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mybooklist.api.ApiModelHelper
import com.example.ppos_app.model.BaseModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseActivity: AppCompatActivity() {
    protected var disposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        disposable = CompositeDisposable()
    }
    fun <T>callApi(api: Observable<BaseModel<T>>, onNext:((t:BaseModel<T>) -> Unit), onError:((t:Throwable) -> Unit)): Disposable {
        val apiObservable = ApiModelHelper.observe(api).subscribe(onNext,onError)
        addDisposable(apiObservable)
        return apiObservable
    }
    protected fun addDisposable(d: Disposable) {
        disposable?.add(d)
    }
}