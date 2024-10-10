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
import fpml.confirmation.Frequency;
import fpml.confirmation.Frequency.FrequencyBuilder;
import fpml.confirmation.Frequency.FrequencyBuilderImpl;
import fpml.confirmation.Frequency.FrequencyImpl;
import fpml.confirmation.GenericFrequency;
import fpml.confirmation.GenericFrequency.GenericFrequencyBuilder;
import fpml.confirmation.GenericFrequency.GenericFrequencyBuilderImpl;
import fpml.confirmation.GenericFrequency.GenericFrequencyImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PeriodExtendedEnum;
import fpml.confirmation.UnderlyerReference;
import fpml.confirmation.meta.GenericFrequencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GenericFrequency", builder=GenericFrequency.GenericFrequencyBuilderImpl.class, version="${project.version}")
public interface GenericFrequency extends Frequency {

	GenericFrequencyMeta metaData = new GenericFrequencyMeta();

	/*********************** Getter Methods  ***********************/
	PartyReference getPayerPartyReference();
	UnderlyerReference getUnderlyerReference();

	/*********************** Build Methods  ***********************/
	GenericFrequency build();
	
	GenericFrequency.GenericFrequencyBuilder toBuilder();
	
	static GenericFrequency.GenericFrequencyBuilder builder() {
		return new GenericFrequency.GenericFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericFrequency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericFrequency> getType() {
		return GenericFrequency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("underlyerReference"), processor, UnderlyerReference.class, getUnderlyerReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericFrequencyBuilder extends GenericFrequency, Frequency.FrequencyBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		UnderlyerReference.UnderlyerReferenceBuilder getOrCreateUnderlyerReference();
		UnderlyerReference.UnderlyerReferenceBuilder getUnderlyerReference();
		GenericFrequency.GenericFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		GenericFrequency.GenericFrequencyBuilder setPeriod(PeriodExtendedEnum period);
		GenericFrequency.GenericFrequencyBuilder setId(String id);
		GenericFrequency.GenericFrequencyBuilder setPayerPartyReference(PartyReference payerPartyReference);
		GenericFrequency.GenericFrequencyBuilder setUnderlyerReference(UnderlyerReference underlyerReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("underlyerReference"), processor, UnderlyerReference.UnderlyerReferenceBuilder.class, getUnderlyerReference());
		}
		

		GenericFrequency.GenericFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of GenericFrequency  ***********************/
	class GenericFrequencyImpl extends Frequency.FrequencyImpl implements GenericFrequency {
		private final PartyReference payerPartyReference;
		private final UnderlyerReference underlyerReference;
		
		protected GenericFrequencyImpl(GenericFrequency.GenericFrequencyBuilder builder) {
			super(builder);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.underlyerReference = ofNullable(builder.getUnderlyerReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("underlyerReference")
		public UnderlyerReference getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public GenericFrequency build() {
			return this;
		}
		
		@Override
		public GenericFrequency.GenericFrequencyBuilder toBuilder() {
			GenericFrequency.GenericFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericFrequency.GenericFrequencyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getUnderlyerReference()).ifPresent(builder::setUnderlyerReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericFrequency _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericFrequency {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"underlyerReference=" + this.underlyerReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GenericFrequency  ***********************/
	class GenericFrequencyBuilderImpl extends Frequency.FrequencyBuilderImpl  implements GenericFrequency.GenericFrequencyBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected UnderlyerReference.UnderlyerReferenceBuilder underlyerReference;
	
		public GenericFrequencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerPartyReference")
		public PartyReference.PartyReferenceBuilder getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (payerPartyReference!=null) {
				result = payerPartyReference;
			}
			else {
				result = payerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerReference")
		public UnderlyerReference.UnderlyerReferenceBuilder getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public UnderlyerReference.UnderlyerReferenceBuilder getOrCreateUnderlyerReference() {
			UnderlyerReference.UnderlyerReferenceBuilder result;
			if (underlyerReference!=null) {
				result = underlyerReference;
			}
			else {
				result = underlyerReference = UnderlyerReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public GenericFrequency.GenericFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public GenericFrequency.GenericFrequencyBuilder setPeriod(PeriodExtendedEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public GenericFrequency.GenericFrequencyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerPartyReference")
		public GenericFrequency.GenericFrequencyBuilder setPayerPartyReference(PartyReference payerPartyReference) {
			this.payerPartyReference = payerPartyReference==null?null:payerPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyerReference")
		public GenericFrequency.GenericFrequencyBuilder setUnderlyerReference(UnderlyerReference underlyerReference) {
			this.underlyerReference = underlyerReference==null?null:underlyerReference.toBuilder();
			return this;
		}
		
		@Override
		public GenericFrequency build() {
			return new GenericFrequency.GenericFrequencyImpl(this);
		}
		
		@Override
		public GenericFrequency.GenericFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericFrequency.GenericFrequencyBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (underlyerReference!=null && !underlyerReference.prune().hasData()) underlyerReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getUnderlyerReference()!=null && getUnderlyerReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericFrequency.GenericFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			GenericFrequency.GenericFrequencyBuilder o = (GenericFrequency.GenericFrequencyBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getUnderlyerReference(), o.getUnderlyerReference(), this::setUnderlyerReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericFrequency _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericFrequencyBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"underlyerReference=" + this.underlyerReference +
			'}' + " " + super.toString();
		}
	}
}
