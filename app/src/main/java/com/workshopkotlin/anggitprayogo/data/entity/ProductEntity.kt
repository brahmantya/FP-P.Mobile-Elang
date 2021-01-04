package com.workshopkotlin.anggitprayogo.data.entity

import android.arch.persistence.room.*
import android.arch.persistence.room.ForeignKey.CASCADE
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Entity(
    tableName = "produk",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["id_user"],
        childColumns = ["id_owner"],
        onDelete = CASCADE
    )],
    indices = [
        Index(value = ["id_owner"])
    ]
)
@Parcelize
data class ProductEntity(
    @ColumnInfo(name = "no_register") var noRegister: String? = null,
    @ColumnInfo(name = "nama_kesatuan") var namaKesatuan: String? = null,
    @ColumnInfo(name = "nama_pelanggar") var namaPelanggar: String? = null,
    @ColumnInfo(name = "jenis_kelamin") var jenisKelamin: String? = null,
    @ColumnInfo(name = "alamat") var alamat: String? = null,
    @ColumnInfo(name = "no_ktp") var noKtp: String? = null,
    @ColumnInfo(name = "pekerjaan")var pekerjaan: String? = null,
    @ColumnInfo(name = "pendidikan") var pendidikan: String? = null,
    @ColumnInfo(name = "umur") var umur: String? = null,
    @ColumnInfo(name = "ttl") var ttl: String? = null,
    @ColumnInfo(name = "no_kendaraan") var noKendaraan: String? = null,
    @ColumnInfo(name = "jenis_kendaraan") var jenisKendaraan: String? = null,
    @ColumnInfo(name = "merek_kendaraan") var merekKendaraan: String? = null,
    @ColumnInfo(name = "hari") var hari: String? = null,
    @ColumnInfo(name = "jam") var jam: String? = null,
    @ColumnInfo(name = "jalan") var jalan: String? = null,
    @ColumnInfo(name = "wilayah") var wilayah: String? = null,
    @ColumnInfo(name = "melanggar_pasal") var melanggarPasal: String? = null,
    @ColumnInfo(name = "jumlah_titipan") var jumlahTitipan: String? = null,
    @ColumnInfo(name = "jumlah_angka_pinalti") var jumlahAngkaPinalti: String? = null,
    @ColumnInfo(name = "nama_petugas") var namaPetugas: String? = null,
    @ColumnInfo(name = "pangkat") var pangkat: String? = null,
    @ColumnInfo(name = "kesatuan") var kesatuan : String? = null,
    @ColumnInfo(name = "id_owner") var idUser: Long? = null
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_produk")
    var idProduk: Long? = null
}