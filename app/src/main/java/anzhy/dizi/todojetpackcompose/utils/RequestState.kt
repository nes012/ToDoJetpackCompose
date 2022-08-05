package anzhy.dizi.todojetpackcompose.utils

//with this sealed class we will wrap response inside VM
//to make sure that it is only returned (produced) from members of RequestState<T>, and never consumed. To do this, use the out modifier:
sealed class RequestState<out T> {
    object Idle : RequestState<Nothing>()
    object Loading: RequestState<Nothing>()
    data class Success<T>(val data: T): RequestState<T>()
    data class Error(val error: Throwable): RequestState<Nothing>()

}
