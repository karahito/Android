import com.japanmicrosystem.eqms.domain.InventoriesService
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET

interface GetAllService {
    @GET("inventories/?einfo=1")
    fun getInventoriesAll(): Single<ResponseBody>
}