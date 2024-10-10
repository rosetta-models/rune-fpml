package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.Manifest;
import fpml.confirmation.Manifest.ManifestBuilder;
import fpml.confirmation.Manifest.ManifestBuilderImpl;
import fpml.confirmation.Manifest.ManifestImpl;
import fpml.confirmation.ManifestType;
import fpml.confirmation.ManifestType.ManifestTypeBuilder;
import fpml.confirmation.ManifestType.ManifestTypeBuilderImpl;
import fpml.confirmation.ManifestType.ManifestTypeImpl;
import fpml.confirmation.ReferenceType;
import fpml.confirmation.meta.ManifestMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="Manifest", builder=Manifest.ManifestBuilderImpl.class, version="${project.version}")
public interface Manifest extends ManifestType {

	ManifestMeta metaData = new ManifestMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Manifest build();
	
	Manifest.ManifestBuilder toBuilder();
	
	static Manifest.ManifestBuilder builder() {
		return new Manifest.ManifestBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Manifest> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Manifest> getType() {
		return Manifest.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reference"), processor, ReferenceType.class, getReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ManifestBuilder extends Manifest, ManifestType.ManifestTypeBuilder {
		Manifest.ManifestBuilder addReference(ReferenceType reference0);
		Manifest.ManifestBuilder addReference(ReferenceType reference1, int _idx);
		Manifest.ManifestBuilder addReference(List<? extends ReferenceType> reference2);
		Manifest.ManifestBuilder setReference(List<? extends ReferenceType> reference3);
		Manifest.ManifestBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reference"), processor, ReferenceType.ReferenceTypeBuilder.class, getReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Manifest.ManifestBuilder prune();
	}

	/*********************** Immutable Implementation of Manifest  ***********************/
	class ManifestImpl extends ManifestType.ManifestTypeImpl implements Manifest {
		
		protected ManifestImpl(Manifest.ManifestBuilder builder) {
			super(builder);
		}
		
		@Override
		public Manifest build() {
			return this;
		}
		
		@Override
		public Manifest.ManifestBuilder toBuilder() {
			Manifest.ManifestBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Manifest.ManifestBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Manifest {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Manifest  ***********************/
	class ManifestBuilderImpl extends ManifestType.ManifestTypeBuilderImpl  implements Manifest.ManifestBuilder {
	
	
		public ManifestBuilderImpl() {
		}
	
		@Override
		public Manifest.ManifestBuilder addReference(ReferenceType reference) {
			if (reference!=null) this.reference.add(reference.toBuilder());
			return this;
		}
		
		@Override
		public Manifest.ManifestBuilder addReference(ReferenceType reference, int _idx) {
			getIndex(this.reference, _idx, () -> reference.toBuilder());
			return this;
		}
		@Override 
		public Manifest.ManifestBuilder addReference(List<? extends ReferenceType> references) {
			if (references != null) {
				for (ReferenceType toAdd : references) {
					this.reference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("reference")
		public Manifest.ManifestBuilder setReference(List<? extends ReferenceType> references) {
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
		public Manifest.ManifestBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Manifest build() {
			return new Manifest.ManifestImpl(this);
		}
		
		@Override
		public Manifest.ManifestBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Manifest.ManifestBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Manifest.ManifestBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Manifest.ManifestBuilder o = (Manifest.ManifestBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ManifestBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
