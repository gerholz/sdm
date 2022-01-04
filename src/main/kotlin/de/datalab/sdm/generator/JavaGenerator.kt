package de.datalab.sdm.generator

import de.datalab.sdm.model.*


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

class JavaGenerator(val service: Service) {


    fun generate(): List<String> {
        val modules: List<Module> = service.stream().toList()
        val namespaces: List<Namespace> = modules.stream().flatMap { module -> module.stream() }.toList()
        val namespaceGenerators: List<JavaNamespaceGenerator> = namespaces.stream().map { namespace -> JavaNamespaceGenerator(namespace) }.toList()
        val filenames = namespaceGenerators.stream().flatMap { generator -> generator.generateAndReturnFilename().stream() } .toList()
        return filenames
    }
}