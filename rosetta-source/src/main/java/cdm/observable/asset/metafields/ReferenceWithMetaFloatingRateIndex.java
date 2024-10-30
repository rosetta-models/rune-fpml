package cdm.observable.asset.metafields;

import cdm.observable.asset.FloatingRateIndex;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.BasicRosettaMetaData;
import com.rosetta.model.lib.meta.Reference;
import com.rosetta.model.lib.meta.ReferenceWithMeta;
import com.rosetta.model.lib.meta.ReferenceWithMeta.ReferenceWithMetaBuilder;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaDataType(value="ReferenceWithMetaFloatingRateIndex", builder=ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilderImpl.class, version="0.0.0")
public interface ReferenceWithMetaFloatingRateIndex extends RosettaModelObject, ReferenceWithMeta<FloatingRateIndex> {

	ReferenceWithMetaFloatingRateIndexMeta metaData = new ReferenceWithMetaFloatingRateIndexMeta();

	/*********************** Getter Methods  ***********************/
	FloatingRateIndex getValue();
	String getGlobalReference();
	String getExternalReference();
	Reference getReference();

	/*********************** Build Methods  ***********************/
	ReferenceWithMetaFloatingRateIndex build();
	
	ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder toBuilder();
	
	static ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder builder() {
		return new ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaFloatingRateIndex> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReferenceWithMetaFloatingRateIndex> getType() {
		return ReferenceWithMetaFloatingRateIndex.class;
	}
	
	@Override
	default Class<FloatingRateIndex> getValueType() {
		return FloatingRateIndex.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("value"), processor, FloatingRateIndex.class, getValue());
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceWithMetaFloatingRateIndexBuilder extends ReferenceWithMetaFloatingRateIndex, RosettaModelObjectBuilder, ReferenceWithMeta.ReferenceWithMetaBuilder<FloatingRateIndex> {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateValue();
		FloatingRateIndex.FloatingRateIndexBuilder getValue();
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder setValue(FloatingRateIndex value);
		ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder setExternalReference(String externalReference);
		ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder setReference(Reference reference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("value"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getValue());
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
		}
		

		ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceWithMetaFloatingRateIndex  ***********************/
	class ReferenceWithMetaFloatingRateIndexImpl implements ReferenceWithMetaFloatingRateIndex {
		private final FloatingRateIndex value;
		private final String globalReference;
		private final String externalReference;
		private final Reference reference;
		
		protected ReferenceWithMetaFloatingRateIndexImpl(ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder builder) {
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
			this.globalReference = builder.getGlobalReference();
			this.externalReference = builder.getExternalReference();
			this.reference = ofNullable(builder.getReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("value")
		public FloatingRateIndex getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("globalReference")
		public String getGlobalReference() {
			return globalReference;
		}
		
		@Override
		@RosettaAttribute("externalReference")
		public String getExternalReference() {
			return externalReference;
		}
		
		@Override
		@RosettaAttribute("address")
		public Reference getReference() {
			return reference;
		}
		
		@Override
		public ReferenceWithMetaFloatingRateIndex build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder toBuilder() {
			ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaFloatingRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(globalReference, _that.getGlobalReference())) return false;
			if (!Objects.equals(externalReference, _that.getExternalReference())) return false;
			if (!Objects.equals(reference, _that.getReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (globalReference != null ? globalReference.hashCode() : 0);
			_result = 31 * _result + (externalReference != null ? externalReference.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceWithMetaFloatingRateIndex {" +
				"value=" + this.value + ", " +
				"globalReference=" + this.globalReference + ", " +
				"externalReference=" + this.externalReference + ", " +
				"reference=" + this.reference +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceWithMetaFloatingRateIndex  ***********************/
	class ReferenceWithMetaFloatingRateIndexBuilderImpl implements ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder {
	
		protected FloatingRateIndex.FloatingRateIndexBuilder value;
		protected String globalReference;
		protected String externalReference;
		protected Reference.ReferenceBuilder reference;
	
		public ReferenceWithMetaFloatingRateIndexBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public FloatingRateIndex.FloatingRateIndexBuilder getValue() {
			return value;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateValue() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = FloatingRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("globalReference")
		public String getGlobalReference() {
			return globalReference;
		}
		
		@Override
		@RosettaAttribute("externalReference")
		public String getExternalReference() {
			return externalReference;
		}
		
		@Override
		@RosettaAttribute("address")
		public Reference.ReferenceBuilder getReference() {
			return reference;
		}
		
		@Override
		public Reference.ReferenceBuilder getOrCreateReference() {
			Reference.ReferenceBuilder result;
			if (reference!=null) {
				result = reference;
			}
			else {
				result = reference = Reference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("value")
		public ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder setValue(FloatingRateIndex value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("globalReference")
		public ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		@RosettaAttribute("externalReference")
		public ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		@RosettaAttribute("address")
		public ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaFloatingRateIndex build() {
			return new ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexImpl(this);
		}
		
		@Override
		public ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder prune() {
			if (value!=null && !value.prune().hasData()) value = null;
			if (reference!=null && !reference.prune().hasData()) reference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null && getValue().hasData()) return true;
			if (getGlobalReference()!=null) return true;
			if (getExternalReference()!=null) return true;
			if (getReference()!=null && getReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder o = (ReferenceWithMetaFloatingRateIndex.ReferenceWithMetaFloatingRateIndexBuilder) other;
			
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			merger.mergeRosetta(getReference(), o.getReference(), this::setReference);
			
			merger.mergeBasic(getGlobalReference(), o.getGlobalReference(), this::setGlobalReference);
			merger.mergeBasic(getExternalReference(), o.getExternalReference(), this::setExternalReference);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaFloatingRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(globalReference, _that.getGlobalReference())) return false;
			if (!Objects.equals(externalReference, _that.getExternalReference())) return false;
			if (!Objects.equals(reference, _that.getReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (globalReference != null ? globalReference.hashCode() : 0);
			_result = 31 * _result + (externalReference != null ? externalReference.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceWithMetaFloatingRateIndexBuilder {" +
				"value=" + this.value + ", " +
				"globalReference=" + this.globalReference + ", " +
				"externalReference=" + this.externalReference + ", " +
				"reference=" + this.reference +
			'}';
		}
	}
}

class ReferenceWithMetaFloatingRateIndexMeta extends BasicRosettaMetaData<ReferenceWithMetaFloatingRateIndex>{

}
