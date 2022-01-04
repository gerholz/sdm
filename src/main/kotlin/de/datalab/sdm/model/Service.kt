package de.datalab.sdm.model


/*
Copyright 2022 Gerhard Holzmeister

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

class Service(val model: Model, val name: String) {

    val path = calculatePath(model, name)

    private val modules = mutableListOf<Module>()

    fun add(module: Module) = modules.add(module)

    fun stream() = modules.stream()

    private fun calculatePath(model: Model, name: String) = Path(listOf(model.path.pathString, name))
}