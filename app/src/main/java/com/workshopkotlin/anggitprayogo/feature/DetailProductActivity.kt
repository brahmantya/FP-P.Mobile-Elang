package com.workshopkotlin.anggitprayogo.feature

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.workshopkotlin.anggitprayogo.Config
import com.workshopkotlin.anggitprayogo.R
import com.workshopkotlin.anggitprayogo.data.entity.ProductEntity
import com.workshopkotlin.anggitprayogo.data.entity.UserEntity
import kotlinx.android.synthetic.main.activity_detail_product.*
import org.jetbrains.anko.startActivity

class DetailProductActivity : AppCompatActivity() {

    private var items: ProductEntity? = null
    private var items2: UserEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        extractIntentAndBindView()

        onClickListener()
    }

    private fun onClickListener() {
        iv_back.setOnClickListener {
            finish()
        }

    }

    private fun extractIntentAndBindView() {
        items = intent?.getParcelableExtra(Config.ITEMS)
        items2 = intent?.getParcelableExtra(Config.ITEMS2)
        bindView(items, items2)
    }

    @SuppressLint("SetTextI18n")
    private fun bindView(
        items: ProductEntity?,
        items2: UserEntity?
    ) {
        tv_no_register.text = "No Register : ${items?.noRegister}"
        tv_nama_kesatuan.text = "Nama Kesatuan : ${items?.namaKesatuan}"
        tv_nama_pelanggar.text = "Nama Pelanggar : ${items?.namaPelanggar}"
        tv_jenis_kelamin.text = "Jenis Kelamin : ${items?.jenisKelamin}"
        tv_alamat.text = "Alamat : ${items?.alamat}"
        tv_no_ktp.text = " No KTP s: ${items?.noKtp}"
        tv_pekerjaan.text = "Pekerjaan : ${items?.pekerjaan}"
        tv_pendidikan.text = "Pendidikan : ${items?.pendidikan}"
        tv_umur.text = "Umur : ${items?.umur}"
        tv_ttl.text = "Tempat dan Tanggal Lahir : ${items?.ttl}"
        tv_no_kendaraan.text = "No Kendaraan : ${items?.noKendaraan}"
        tv_jenis_kendaraan.text = "Jenis Kendaraan : ${items?.jenisKendaraan}"
        tv_merek_kendaraan.text = "Merek Kendaraan : ${items?.merekKendaraan}"
        tv_hari.text = "Hari dan Tanggal : ${items?.hari}"
        tv_jam.text = "Jam : ${items?.jam}"
        tv_jalan.text = "Jalan : ${items?.jalan}"
        tv_wilayah.text = "Wilayah : ${items?.wilayah}"
        tv_melanggar_pasal.text = "Melanggar Pasal : ${items?.melanggarPasal}"
        tv_jumlah_titipan.text = "Jumlah Titipan : Rp.${items?.jumlahTitipan}"
        tv_jumlah_angka_pinalti.text = "Jumlah Angka Pinalti : Rp.${items?.jumlahAngkaPinalti}"
        tv_nama_petugas.text = "Nama Petugas : ${items?.namaPetugas}"
        tv_pangkat.text = "Pangkat : ${items?.pangkat}"
        tv_kesatuan.text = "Kesatuan : ${items?.kesatuan}"
    }
}
