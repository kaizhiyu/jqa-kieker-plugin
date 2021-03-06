package org.jqassistant.contrib.plugin.kieker.api.model;

import com.buschmais.jqassistant.core.store.api.model.FullQualifiedNameDescriptor;
import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import java.util.List;

/**
 * Defines the node for a type.
 */
@Label(value = "Type", usingIndexedPropertyOf = FullQualifiedNameDescriptor.class)
public interface TypeDescriptor extends KiekerDescriptor, FullQualifiedNameDescriptor {

    @Relation("DECLARES")
    List<MethodDescriptor> getDeclaredMethods();

    @Relation.Outgoing
    List<TypeDependsOnDescriptor> getDependencies();

    @Relation.Incoming
    List<TypeDependsOnDescriptor> getDependents();

    void setName(String name);

    String getName();

}
