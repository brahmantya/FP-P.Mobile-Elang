package com.workshopkotlin.anggitprayogo.feature

import android.database.sqlite.SQLiteException
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import com.workshopkotlin.anggitprayogo.R
import com.workshopkotlin.anggitprayogo.data.JandaDatabase
import com.workshopkotlin.anggitprayogo.data.entity.ProductEntity
import com.workshopkotlin.anggitprayogo.data.sharedpref.SharedprefUtil
import com.workshopkotlin.anggitprayogo.utils.validator.MinValRule
import kotlinx.android.synthetic.main.activity_create_product.*
import kotlinx.android.synthetic.main.app_bar_create_product.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.toast

class CreateProductActivity : AppCompatActivity() {

    private val database: JandaDatabase by lazy {
        JandaDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_product)

        onClickListener()
    }

    private fun onClickListener() {
        iv_logo.setOnClickListener {
            finish()
        }

        btn_add.setOnClickListener {
            if (isValid()){
                doAddProductProcess()
            }
        }
    }

    private fun doAddProductProcess() {
        val product = ProductEntity(
            et_no_register.text.toString(),
            et_nama_kesatuan.text.toString(),
            et_nama_pelanggar.text.toString(),
            et_jenis_kelamin.text.toString(),
            et_alamat.text.toString(),
            et_no_ktp.text.toString(),
            et_pekerjaan.text.toString(),
            et_pendidikan.text.toString(),
            et_umur.text.toString(),
            et_ttl.text.toString(),
            et_no_kendaraan.text.toString(),
            et_jenis_kendaraan.text.toString(),
            et_merek_kendaraan.text.toString(),
            et_hari.text.toString(),
            et_jam.text.toString(),
            et_jalan.text.toString(),
            et_wilayah.text.toString(),
            et_melanggar_pasal.text.toString(),
            et_jumlah_titipan.text.toString(),
            et_jumlah_angka_pinalti.text.toString(),
            et_nama_petugas.text.toString(),
            et_pangkat.text.toString(),
            et_kesatuan.text.toString(),
            SharedprefUtil.idUser!!
        )

        doAsycAddProduct(product)
    }

    private fun doAsycAddProduct(product: ProductEntity) {
        GlobalScope.launch(Dispatchers.Main) {
            val isSuccess = withContext(Dispatchers.Default) {
                try {
                    addProductToDb(product)
                    return@withContext true
                }catch (e: SQLiteException){
                    e.printStackTrace()
                    return@withContext false
                }
            }

            if (isSuccess){
                toast("Berhasil menambah produk")
                finish()
            }else{
                toast("Gagal menambah produk")
            }
        }
    }

    private fun addProductToDb(product: ProductEntity){
        return database.productDao().insertProduct(product)
    }

    private fun isValid(): Boolean {
        var valid = true

        et_no_register.validator()
            .nonEmpty()
            .onlyNumbers()
            .addRule(MinValRule(1))
            .addErrorCallback {
                et_no_register.error = it
                et_no_register.requestFocus()
                valid = false
            }
            .check()


        et_nama_kesatuan.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_nama_kesatuan.error = it
                et_nama_kesatuan.requestFocus()
                valid = false
            }
            .check()

        et_nama_pelanggar.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_nama_pelanggar.error = it
                et_nama_pelanggar.requestFocus()
                valid = false
            }
            .check()

        et_jenis_kelamin.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_jenis_kelamin.error = it
                et_jenis_kelamin.requestFocus()
                valid = false
            }
            .check()

        et_alamat.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_alamat.error = it
                et_alamat.requestFocus()
                valid = false
            }
            .check()

        et_no_ktp.validator()
            .nonEmpty()
            .onlyNumbers()
            .minLength(1)
            .addErrorCallback {
                et_no_ktp.error = it
                et_no_ktp.requestFocus()
                valid = false
            }
            .check()

        et_pekerjaan.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_pekerjaan.error = it
                et_pekerjaan.requestFocus()
                valid = false
            }
            .check()

        et_pendidikan.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_pendidikan.error = it
                et_pendidikan.requestFocus()
                valid = false
            }
            .check()

        et_umur.validator()
            .nonEmpty()
            .onlyNumbers()
            .minLength(1)
            .addErrorCallback {
                et_umur.error = it
                et_umur.requestFocus()
                valid = false
            }
            .check()

        et_ttl.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_ttl.error = it
                et_ttl.requestFocus()
                valid = false
            }
            .check()

        et_no_kendaraan.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_no_kendaraan.error = it
                et_no_kendaraan.requestFocus()
                valid = false
            }
            .check()

        et_jenis_kendaraan.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_jenis_kendaraan.error = it
                et_jenis_kendaraan.requestFocus()
                valid = false
            }
            .check()

        et_merek_kendaraan.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_merek_kendaraan.error = it
                et_merek_kendaraan.requestFocus()
                valid = false
            }
            .check()

        et_hari.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_hari.error = it
                et_hari.requestFocus()
                valid = false
            }
            .check()

        et_jam.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_jam.error = it
                et_jam.requestFocus()
                valid = false
            }
            .check()

        et_jalan.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_jalan.error = it
                et_jalan.requestFocus()
                valid = false
            }
            .check()

        et_wilayah.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_wilayah.error = it
                et_wilayah.requestFocus()
                valid = false
            }
            .check()

        et_melanggar_pasal.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_melanggar_pasal.error = it
                et_melanggar_pasal.requestFocus()
                valid = false
            }
            .check()

        et_jumlah_titipan.validator()
            .nonEmpty()
            .onlyNumbers()
            .minLength(1)
            .addErrorCallback {
                et_jumlah_titipan.error = it
                et_jumlah_titipan.requestFocus()
                valid = false
            }
            .check()

        et_jumlah_angka_pinalti.validator()
            .nonEmpty()
            .onlyNumbers()
            .minLength(1)
            .addErrorCallback {
                et_jumlah_angka_pinalti.error = it
                et_jumlah_angka_pinalti.requestFocus()
                valid = false
            }
            .check()

        et_nama_petugas.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_nama_petugas.error = it
                et_nama_petugas.requestFocus()
                valid = false
            }
            .check()

        et_pangkat.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_pangkat.error = it
                et_pangkat.requestFocus()
                valid = false
            }
            .check()

        et_kesatuan.validator()
            .nonEmpty()
            .minLength(1)
            .addErrorCallback {
                et_kesatuan.error = it
                et_kesatuan.requestFocus()
                valid = false
            }
            .check()

        return valid
    }
}
