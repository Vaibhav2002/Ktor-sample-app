package com.example.repo

import com.example.models.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonRepo {

    val list = mutableListOf<Person>()

    fun getPerson(id: String): Person {
        for (person in list) {
            if (person.id == id)
                return person
        }
        return Person();
    }

    fun insertPerson(person: Person) {
        CoroutineScope(Dispatchers.IO).launch {
            list.add(person)
        }
    }

    fun getAllPersons() = list

    fun deletePerson(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            list.removeIf {
                it.id == id
            }
        }
    }



}