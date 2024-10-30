package cdm.product.template.metafields;

import cdm.product.template.SettlementPayout;
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
@RosettaDataType(value="ReferenceWithMetaSettlementPayout", builder=ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilderImpl.class, version="0.0.0")
public interface ReferenceWithMetaSettlementPayout extends RosettaModelObject, ReferenceWithMeta<SettlementPayout> {

	ReferenceWithMetaSettlementPayoutMeta metaData = new ReferenceWithMetaSettlementPayoutMeta();

	/*********************** Getter Methods  ***********************/
	SettlementPayout getValue();
	String getGlobalReference();
	String getExternalReference();
	Reference getReference();

	/*********************** Build Methods  ***********************/
	ReferenceWithMetaSettlementPayout build();
	
	ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder toBuilder();
	
	static ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder builder() {
		return new ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaSettlementPayout> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReferenceWithMetaSettlementPayout> getType() {
		return ReferenceWithMetaSettlementPayout.class;
	}
	
	@Override
	default Class<SettlementPayout> getValueType() {
		return SettlementPayout.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("value"), processor, SettlementPayout.class, getValue());
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceWithMetaSettlementPayoutBuilder extends ReferenceWithMetaSettlementPayout, RosettaModelObjectBuilder, ReferenceWithMeta.ReferenceWithMetaBuilder<SettlementPayout> {
		SettlementPayout.SettlementPayoutBuilder getOrCreateValue();
		SettlementPayout.SettlementPayoutBuilder getValue();
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder setValue(SettlementPayout value);
		ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder setExternalReference(String externalReference);
		ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder setReference(Reference reference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("value"), processor, SettlementPayout.SettlementPayoutBuilder.class, getValue());
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
		}
		

		ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceWithMetaSettlementPayout  ***********************/
	class ReferenceWithMetaSettlementPayoutImpl implements ReferenceWithMetaSettlementPayout {
		private final SettlementPayout value;
		private final String globalReference;
		private final String externalReference;
		private final Reference reference;
		
		protected ReferenceWithMetaSettlementPayoutImpl(ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder builder) {
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
			this.globalReference = builder.getGlobalReference();
			this.externalReference = builder.getExternalReference();
			this.reference = ofNullable(builder.getReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("value")
		public SettlementPayout getValue() {
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
		public ReferenceWithMetaSettlementPayout build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder toBuilder() {
			ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaSettlementPayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaSettlementPayout {" +
				"value=" + this.value + ", " +
				"globalReference=" + this.globalReference + ", " +
				"externalReference=" + this.externalReference + ", " +
				"reference=" + this.reference +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceWithMetaSettlementPayout  ***********************/
	class ReferenceWithMetaSettlementPayoutBuilderImpl implements ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder {
	
		protected SettlementPayout.SettlementPayoutBuilder value;
		protected String globalReference;
		protected String externalReference;
		protected Reference.ReferenceBuilder reference;
	
		public ReferenceWithMetaSettlementPayoutBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public SettlementPayout.SettlementPayoutBuilder getValue() {
			return value;
		}
		
		@Override
		public SettlementPayout.SettlementPayoutBuilder getOrCreateValue() {
			SettlementPayout.SettlementPayoutBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = SettlementPayout.builder();
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
		public ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder setValue(SettlementPayout value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("globalReference")
		public ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		@RosettaAttribute("externalReference")
		public ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		@RosettaAttribute("address")
		public ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaSettlementPayout build() {
			return new ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutImpl(this);
		}
		
		@Override
		public ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder prune() {
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
		public ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder o = (ReferenceWithMetaSettlementPayout.ReferenceWithMetaSettlementPayoutBuilder) other;
			
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
		
			ReferenceWithMetaSettlementPayout _that = getType().cast(o);
		
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
			return "ReferenceWithMetaSettlementPayoutBuilder {" +
				"value=" + this.value + ", " +
				"globalReference=" + this.globalReference + ", " +
				"externalReference=" + this.externalReference + ", " +
				"reference=" + this.reference +
			'}';
		}
	}
}

class ReferenceWithMetaSettlementPayoutMeta extends BasicRosettaMetaData<ReferenceWithMetaSettlementPayout>{

}
