package com.regnosys.runefpml;

import com.google.common.collect.ImmutableList;
import com.regnosys.rosetta.common.util.ClassPathUtils;
import com.regnosys.rosetta.common.util.UrlUtils;
import com.regnosys.rosetta.rosetta.RosettaModel;
import com.regnosys.rosetta.rosetta.simple.Data;
import com.regnosys.rosetta.transgest.ModelLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Util to help create comparison of types/attributes between model versions, for example DRR 5.x.x and 6-dev.
 */
public class ChoiceTypeGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChoiceTypeGenerator.class);

    private final ModelLoader modelLoader;

    @Inject
    public ChoiceTypeGenerator(ModelLoader modelLoader) {
        this.modelLoader = modelLoader;
    }

    public static void main(String[] args) {
        RuneFpmlTestRuntimeModule.InjectorProvider injectorProvider = new RuneFpmlTestRuntimeModule.InjectorProvider();
        ChoiceTypeGenerator instance = injectorProvider.getInjector().getInstance(ChoiceTypeGenerator.class);
        instance.findAllSubTypes();
    }

    public void findAllSubTypes() {
        List<RosettaModel> models = getModels("fpml/rosetta");

        Set<Data> dataTypes = getDataTypes(models);
        Data leg = findDataType(dataTypes, "Product");

        Node parent = new Node(leg, null);
        findSubTypes(dataTypes, leg, parent);
        printHierarchies(parent, "  ");
    }


    private List<RosettaModel> getModels(String classpathDir) {
        List<URL> urls = ClassPathUtils
                .findPathsFromClassPath(ImmutableList.of("model", classpathDir),
                        ".*\\.rosetta",
                        Optional.empty(),
                        this.getClass().getClassLoader())
                .stream()
                .map(UrlUtils::toUrl)
                .collect(Collectors.toList());
        List<RosettaModel> models = modelLoader.loadRosettaModels(urls.stream());
        if (models.size() <= 2) {
            throw new IllegalArgumentException("No model rosetta files found.  Only found basic types and annotations rosetta files.");
        }
        return models;
    }

    private Set<Data> getDataTypes(List<RosettaModel> models) {
        return models.stream()
                .map(RosettaModel::getElements)
                .flatMap(Collection::stream)
                .filter(Data.class::isInstance)
                .map(Data.class::cast)
                .collect(Collectors.toSet());
    }

    private Data findDataType(Set<Data> dataTypes, String typeName) {
        return dataTypes.stream()
                .filter(d -> typeName.equals(d.getName()))
                .findFirst().orElseThrow();
    }

    private void findSubTypes(Set<Data> dataTypes, Data superType, Node parent) {
        dataTypes.stream()
                .filter(Data::hasSuperType)
                .forEach(d -> {
                    if (d.getSuperType().equals(superType)) {
                        Node child = parent.addChild(d);
                        findSubTypes(dataTypes, d, child);
                    }
                });
    }

    private void printHierarchies(Node node, String indent) {
        StringBuilder hierarchy = new StringBuilder();
        Node current = node;
        while (current != null) {
            if (!current.equals(node)) {
                hierarchy.append(current.parent.getName());
            }
            if (current.parentNode != null) {
                hierarchy.append(" extends ");
            }

            current = current.parentNode;
        }

        if (node.children.isEmpty()) {
            System.out.println(indent + node.parent.getName() + " // " + hierarchy);    
        }
        
        for (Node child : node.children) {
            printHierarchies(child, indent + "  ");
        }
    }

    static class Node {
        final Data parent;
        final Node parentNode; // Added parent node reference
        final List<Node> children = new ArrayList<>();

        Node(Data parent, Node parentNode) { // Updated constructor
            this.parent = parent;
            this.parentNode = parentNode;
        }

        Node addChild(Data child) {
            Node childNode = new Node(child, this); // Updated constructor
            children.add(childNode);
            return childNode;
        }
    }

}
