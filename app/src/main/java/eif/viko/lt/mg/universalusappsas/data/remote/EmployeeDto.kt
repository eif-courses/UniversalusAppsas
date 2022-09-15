package eif.viko.lt.mg.universalusappsas.data.remote

import eif.viko.lt.mg.universalusappsas.domain.model.Employee

data class EmployeeDto(
    val address: String = "",
    val age: Int = 0,
    val name: String = "",
){
    // Galima pasirinkti mažiau parametrų ir Employee klasėje nurodyti pvz. tik age, kurį atvaizduosime UI
    fun toEmployee(): Employee{
        return Employee(
            address = address,
            age = age,
            name = name
        )
    }
}