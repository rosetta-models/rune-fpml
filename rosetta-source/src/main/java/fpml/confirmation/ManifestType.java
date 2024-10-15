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
import fpml.confirmation.ManifestType;
import fpml.confirmation.ManifestType.ManifestTypeBuilder;
import fpml.confirmation.ManifestType.ManifestTypeBuilderImpl;
import fpml.confirmation.ManifestType.ManifestTypeImpl;
import fpml.confirmation.ReferenceType;
import fpml.confirmation.meta.ManifestTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ManifestType", builder=ManifestType.ManifestTypeBuilderImpl.class, version="${project.version}")
public interface ManifestType extends RosettaModelObject {

	ManifestTypeMeta metaData = new ManifestTypeMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends ReferenceType> getReference();
	String getId();

	/*********************** Build Methods  ***********************/
	ManifestType build();
	
	ManifestType.ManifestTypeBuilder toBuilder();
	
	static ManifestType.ManifestTypeBuilder builder() {
		return new ManifestType.ManifestTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ManifestType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ManifestType> getType() {
		return ManifestType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reference"), processor, ReferenceType.class, getReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ManifestTypeBuilder extends ManifestType, RosettaModelObjectBuilder {
		ReferenceType.ReferenceTypeBuilder getOrCreateReference(int _index);
		List<? extends ReferenceType.ReferenceTypeBuilder> getReference();
		ManifestType.ManifestTypeBuilder addReference(ReferenceType reference0);
		ManifestType.ManifestTypeBuilder addReference(ReferenceType reference1, int _idx);
		ManifestType.ManifestTypeBuilder addReference(List<? extends ReferenceType> reference2);
		ManifestType.ManifestTypeBuilder setReference(List<? extends ReferenceType> reference3);
		ManifestType.ManifestTypeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reference"), processor, ReferenceType.ReferenceTypeBuilder.class, getReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ManifestType.ManifestTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ManifestType  ***********************/
	class ManifestTypeImpl implements ManifestType {
		private final List<? extends ReferenceType> reference;
		private final String id;
		
		protected ManifestTypeImpl(ManifestType.ManifestTypeBuilder builder) {
			this.reference = ofNullable(builder.getReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("reference")
		public List<? extends ReferenceType> getReference() {
			return reference;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ManifestType build() {
			return this;
		}
		
		@Override
		public ManifestType.ManifestTypeBuilder toBuilder() {
			ManifestType.ManifestTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ManifestType.ManifestTypeBuilder builder) {
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ManifestType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(reference, _that.getReference())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ManifestType {" +
				"reference=" + this.reference + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ManifestType  ***********************/
	class ManifestTypeBuilderImpl implements ManifestType.ManifestTypeBuilder {
	
		protected List<ReferenceType.ReferenceTypeBuilder> reference = new ArrayList<>();
		protected String id;
	
		public ManifestTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("reference")
		public List<? extends ReferenceType.ReferenceTypeBuilder> getReference() {
			return reference;
		}
		
		public ReferenceType.ReferenceTypeBuilder getOrCreateReference(int _index) {
		
			if (reference==null) {
				this.reference = new ArrayList<>();
			}
			ReferenceType.ReferenceTypeBuilder result;
			return getIndex(reference, _index, () -> {
						ReferenceType.ReferenceTypeBuilder newReference = ReferenceType.builder();
						return newReference;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ManifestType.ManifestTypeBuilder addReference(ReferenceType reference) {
			if (reference!=null) this.reference.add(reference.toBuilder());
			return this;
		}
		
		@Override
		public ManifestType.ManifestTypeBuilder addReference(ReferenceType reference, int _idx) {
			getIndex(this.reference, _idx, () -> reference.toBuilder());
			return this;
		}
		@Override 
		public ManifestType.ManifestTypeBuilder addReference(List<? extends ReferenceType> references) {
			if (references != null) {
				for (ReferenceType toAdd : references) {
					this.reference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("reference")
		public ManifestType.ManifestTypeBuilder setReference(List<? extends ReferenceType> references) {
			if (references == null)  {
				this.reference = new ArrayList<>();
			}
			else {
				this.reference = references.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public ManifestType.ManifestTypeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ManifestType build() {
			return new ManifestType.ManifestTypeImpl(this);
		}
		
		@Override
		public ManifestType.ManifestTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ManifestType.ManifestTypeBuilder prune() {
			reference = reference.stream().filter(b->b!=null).<ReferenceType.ReferenceTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReference()!=null && getReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ManifestType.ManifestTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ManifestType.ManifestTypeBuilder o = (ManifestType.ManifestTypeBuilder) other;
			
			merger.mergeRosetta(getReference(), o.getReference(), this::getOrCreateReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ManifestType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(reference, _that.getReference())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ManifestTypeBuilder {" +
				"reference=" + this.reference + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
