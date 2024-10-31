package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.Sensitivity;
import fpml.confirmation.SensitivitySet;
import fpml.confirmation.SensitivitySet.SensitivitySetBuilder;
import fpml.confirmation.SensitivitySet.SensitivitySetBuilderImpl;
import fpml.confirmation.SensitivitySet.SensitivitySetImpl;
import fpml.confirmation.SensitivitySetDefinitionReference;
import fpml.confirmation.meta.SensitivitySetMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A collection of sensitivities. References a definition that explains the meaning/type of the sensitivities.
 * @version ${project.version}
 */
@RosettaDataType(value="SensitivitySet", builder=SensitivitySet.SensitivitySetBuilderImpl.class, version="${project.version}")
public interface SensitivitySet extends RosettaModelObject {

	SensitivitySetMeta metaData = new SensitivitySetMeta();

	/*********************** Getter Methods  ***********************/
	String getName();
	/**
	 * A reference to a sensitivity set definition.
	 */
	SensitivitySetDefinitionReference getDefinitionReference();
	List<? extends Sensitivity> getSensitivity();
	String getId();

	/*********************** Build Methods  ***********************/
	SensitivitySet build();
	
	SensitivitySet.SensitivitySetBuilder toBuilder();
	
	static SensitivitySet.SensitivitySetBuilder builder() {
		return new SensitivitySet.SensitivitySetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SensitivitySet> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SensitivitySet> getType() {
		return SensitivitySet.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("definitionReference"), processor, SensitivitySetDefinitionReference.class, getDefinitionReference());
		processRosetta(path.newSubPath("sensitivity"), processor, Sensitivity.class, getSensitivity());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivitySetBuilder extends SensitivitySet, RosettaModelObjectBuilder {
		SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder getOrCreateDefinitionReference();
		SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder getDefinitionReference();
		Sensitivity.SensitivityBuilder getOrCreateSensitivity(int _index);
		List<? extends Sensitivity.SensitivityBuilder> getSensitivity();
		SensitivitySet.SensitivitySetBuilder setName(String name);
		SensitivitySet.SensitivitySetBuilder setDefinitionReference(SensitivitySetDefinitionReference definitionReference);
		SensitivitySet.SensitivitySetBuilder addSensitivity(Sensitivity sensitivity0);
		SensitivitySet.SensitivitySetBuilder addSensitivity(Sensitivity sensitivity1, int _idx);
		SensitivitySet.SensitivitySetBuilder addSensitivity(List<? extends Sensitivity> sensitivity2);
		SensitivitySet.SensitivitySetBuilder setSensitivity(List<? extends Sensitivity> sensitivity3);
		SensitivitySet.SensitivitySetBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("definitionReference"), processor, SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder.class, getDefinitionReference());
			processRosetta(path.newSubPath("sensitivity"), processor, Sensitivity.SensitivityBuilder.class, getSensitivity());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SensitivitySet.SensitivitySetBuilder prune();
	}

	/*********************** Immutable Implementation of SensitivitySet  ***********************/
	class SensitivitySetImpl implements SensitivitySet {
		private final String name;
		private final SensitivitySetDefinitionReference definitionReference;
		private final List<? extends Sensitivity> sensitivity;
		private final String id;
		
		protected SensitivitySetImpl(SensitivitySet.SensitivitySetBuilder builder) {
			this.name = builder.getName();
			this.definitionReference = ofNullable(builder.getDefinitionReference()).map(f->f.build()).orElse(null);
			this.sensitivity = ofNullable(builder.getSensitivity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("definitionReference")
		public SensitivitySetDefinitionReference getDefinitionReference() {
			return definitionReference;
		}
		
		@Override
		@RosettaAttribute("sensitivity")
		public List<? extends Sensitivity> getSensitivity() {
			return sensitivity;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SensitivitySet build() {
			return this;
		}
		
		@Override
		public SensitivitySet.SensitivitySetBuilder toBuilder() {
			SensitivitySet.SensitivitySetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivitySet.SensitivitySetBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getDefinitionReference()).ifPresent(builder::setDefinitionReference);
			ofNullable(getSensitivity()).ifPresent(builder::setSensitivity);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivitySet _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(definitionReference, _that.getDefinitionReference())) return false;
			if (!ListEquals.listEquals(sensitivity, _that.getSensitivity())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (definitionReference != null ? definitionReference.hashCode() : 0);
			_result = 31 * _result + (sensitivity != null ? sensitivity.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivitySet {" +
				"name=" + this.name + ", " +
				"definitionReference=" + this.definitionReference + ", " +
				"sensitivity=" + this.sensitivity + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of SensitivitySet  ***********************/
	class SensitivitySetBuilderImpl implements SensitivitySet.SensitivitySetBuilder {
	
		protected String name;
		protected SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder definitionReference;
		protected List<Sensitivity.SensitivityBuilder> sensitivity = new ArrayList<>();
		protected String id;
	
		public SensitivitySetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("definitionReference")
		public SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder getDefinitionReference() {
			return definitionReference;
		}
		
		@Override
		public SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder getOrCreateDefinitionReference() {
			SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder result;
			if (definitionReference!=null) {
				result = definitionReference;
			}
			else {
				result = definitionReference = SensitivitySetDefinitionReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sensitivity")
		public List<? extends Sensitivity.SensitivityBuilder> getSensitivity() {
			return sensitivity;
		}
		
		@Override
		public Sensitivity.SensitivityBuilder getOrCreateSensitivity(int _index) {
		
			if (sensitivity==null) {
				this.sensitivity = new ArrayList<>();
			}
			Sensitivity.SensitivityBuilder result;
			return getIndex(sensitivity, _index, () -> {
						Sensitivity.SensitivityBuilder newSensitivity = Sensitivity.builder();
						return newSensitivity;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		public SensitivitySet.SensitivitySetBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("definitionReference")
		public SensitivitySet.SensitivitySetBuilder setDefinitionReference(SensitivitySetDefinitionReference definitionReference) {
			this.definitionReference = definitionReference==null?null:definitionReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sensitivity")
		public SensitivitySet.SensitivitySetBuilder addSensitivity(Sensitivity sensitivity) {
			if (sensitivity!=null) this.sensitivity.add(sensitivity.toBuilder());
			return this;
		}
		
		@Override
		public SensitivitySet.SensitivitySetBuilder addSensitivity(Sensitivity sensitivity, int _idx) {
			getIndex(this.sensitivity, _idx, () -> sensitivity.toBuilder());
			return this;
		}
		@Override 
		public SensitivitySet.SensitivitySetBuilder addSensitivity(List<? extends Sensitivity> sensitivitys) {
			if (sensitivitys != null) {
				for (Sensitivity toAdd : sensitivitys) {
					this.sensitivity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SensitivitySet.SensitivitySetBuilder setSensitivity(List<? extends Sensitivity> sensitivitys) {
			if (sensitivitys == null)  {
				this.sensitivity = new ArrayList<>();
			}
			else {
				this.sensitivity = sensitivitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public SensitivitySet.SensitivitySetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SensitivitySet build() {
			return new SensitivitySet.SensitivitySetImpl(this);
		}
		
		@Override
		public SensitivitySet.SensitivitySetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivitySet.SensitivitySetBuilder prune() {
			if (definitionReference!=null && !definitionReference.prune().hasData()) definitionReference = null;
			sensitivity = sensitivity.stream().filter(b->b!=null).<Sensitivity.SensitivityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getDefinitionReference()!=null && getDefinitionReference().hasData()) return true;
			if (getSensitivity()!=null && getSensitivity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivitySet.SensitivitySetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivitySet.SensitivitySetBuilder o = (SensitivitySet.SensitivitySetBuilder) other;
			
			merger.mergeRosetta(getDefinitionReference(), o.getDefinitionReference(), this::setDefinitionReference);
			merger.mergeRosetta(getSensitivity(), o.getSensitivity(), this::getOrCreateSensitivity);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivitySet _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(definitionReference, _that.getDefinitionReference())) return false;
			if (!ListEquals.listEquals(sensitivity, _that.getSensitivity())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (definitionReference != null ? definitionReference.hashCode() : 0);
			_result = 31 * _result + (sensitivity != null ? sensitivity.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivitySetBuilder {" +
				"name=" + this.name + ", " +
				"definitionReference=" + this.definitionReference + ", " +
				"sensitivity=" + this.sensitivity + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
