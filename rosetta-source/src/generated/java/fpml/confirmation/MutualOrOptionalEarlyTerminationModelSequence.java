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
import fpml.confirmation.EarlyTerminationDateEnum;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequence;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilderImpl;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceImpl;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequenceSequence;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.MutualOrOptionalEarlyTerminationModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="MutualOrOptionalEarlyTerminationModelSequence", builder=MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilderImpl.class, version="${project.version}")
public interface MutualOrOptionalEarlyTerminationModelSequence extends RosettaModelObject {

	MutualOrOptionalEarlyTerminationModelSequenceMeta metaData = new MutualOrOptionalEarlyTerminationModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A Boolean element used for specifying whether the Optional Early Termination clause detailed in the agreement will apply.
	 */
	Boolean getOptionalEarlyTermination();
	/**
	 * Optional Early Termination Date
	 */
	EarlyTerminationDateEnum getOptionalEarlyTerminationDate();
	/**
	 * Optional Early Termination Electing Party Reference
	 */
	PartyReference getOptionalEarlyTerminationElectingPartyReference();
	/**
	 * A Boolean element used for specifying whether the Break Funding Recovery detailed in the agreement will apply.
	 */
	Boolean getBreakFundingRecovery();
	MutualOrOptionalEarlyTerminationModelSequenceSequence getMutualOrOptionalEarlyTerminationModelSequenceSequence();

	/*********************** Build Methods  ***********************/
	MutualOrOptionalEarlyTerminationModelSequence build();
	
	MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder toBuilder();
	
	static MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder builder() {
		return new MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MutualOrOptionalEarlyTerminationModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MutualOrOptionalEarlyTerminationModelSequence> getType() {
		return MutualOrOptionalEarlyTerminationModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("optionalEarlyTermination"), Boolean.class, getOptionalEarlyTermination(), this);
		processor.processBasic(path.newSubPath("optionalEarlyTerminationDate"), EarlyTerminationDateEnum.class, getOptionalEarlyTerminationDate(), this);
		processRosetta(path.newSubPath("optionalEarlyTerminationElectingPartyReference"), processor, PartyReference.class, getOptionalEarlyTerminationElectingPartyReference());
		processor.processBasic(path.newSubPath("breakFundingRecovery"), Boolean.class, getBreakFundingRecovery(), this);
		processRosetta(path.newSubPath("mutualOrOptionalEarlyTerminationModelSequenceSequence"), processor, MutualOrOptionalEarlyTerminationModelSequenceSequence.class, getMutualOrOptionalEarlyTerminationModelSequenceSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MutualOrOptionalEarlyTerminationModelSequenceBuilder extends MutualOrOptionalEarlyTerminationModelSequence, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateOptionalEarlyTerminationElectingPartyReference();
		PartyReference.PartyReferenceBuilder getOptionalEarlyTerminationElectingPartyReference();
		MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder getOrCreateMutualOrOptionalEarlyTerminationModelSequenceSequence();
		MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder getMutualOrOptionalEarlyTerminationModelSequenceSequence();
		MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder setOptionalEarlyTermination(Boolean optionalEarlyTermination);
		MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder setOptionalEarlyTerminationDate(EarlyTerminationDateEnum optionalEarlyTerminationDate);
		MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder setOptionalEarlyTerminationElectingPartyReference(PartyReference optionalEarlyTerminationElectingPartyReference);
		MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder setBreakFundingRecovery(Boolean breakFundingRecovery);
		MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder setMutualOrOptionalEarlyTerminationModelSequenceSequence(MutualOrOptionalEarlyTerminationModelSequenceSequence mutualOrOptionalEarlyTerminationModelSequenceSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("optionalEarlyTermination"), Boolean.class, getOptionalEarlyTermination(), this);
			processor.processBasic(path.newSubPath("optionalEarlyTerminationDate"), EarlyTerminationDateEnum.class, getOptionalEarlyTerminationDate(), this);
			processRosetta(path.newSubPath("optionalEarlyTerminationElectingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getOptionalEarlyTerminationElectingPartyReference());
			processor.processBasic(path.newSubPath("breakFundingRecovery"), Boolean.class, getBreakFundingRecovery(), this);
			processRosetta(path.newSubPath("mutualOrOptionalEarlyTerminationModelSequenceSequence"), processor, MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder.class, getMutualOrOptionalEarlyTerminationModelSequenceSequence());
		}
		

		MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of MutualOrOptionalEarlyTerminationModelSequence  ***********************/
	class MutualOrOptionalEarlyTerminationModelSequenceImpl implements MutualOrOptionalEarlyTerminationModelSequence {
		private final Boolean optionalEarlyTermination;
		private final EarlyTerminationDateEnum optionalEarlyTerminationDate;
		private final PartyReference optionalEarlyTerminationElectingPartyReference;
		private final Boolean breakFundingRecovery;
		private final MutualOrOptionalEarlyTerminationModelSequenceSequence mutualOrOptionalEarlyTerminationModelSequenceSequence;
		
		protected MutualOrOptionalEarlyTerminationModelSequenceImpl(MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder builder) {
			this.optionalEarlyTermination = builder.getOptionalEarlyTermination();
			this.optionalEarlyTerminationDate = builder.getOptionalEarlyTerminationDate();
			this.optionalEarlyTerminationElectingPartyReference = ofNullable(builder.getOptionalEarlyTerminationElectingPartyReference()).map(f->f.build()).orElse(null);
			this.breakFundingRecovery = builder.getBreakFundingRecovery();
			this.mutualOrOptionalEarlyTerminationModelSequenceSequence = ofNullable(builder.getMutualOrOptionalEarlyTerminationModelSequenceSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		public Boolean getOptionalEarlyTermination() {
			return optionalEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationDate")
		public EarlyTerminationDateEnum getOptionalEarlyTerminationDate() {
			return optionalEarlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationElectingPartyReference")
		public PartyReference getOptionalEarlyTerminationElectingPartyReference() {
			return optionalEarlyTerminationElectingPartyReference;
		}
		
		@Override
		@RosettaAttribute("breakFundingRecovery")
		public Boolean getBreakFundingRecovery() {
			return breakFundingRecovery;
		}
		
		@Override
		@RosettaAttribute("mutualOrOptionalEarlyTerminationModelSequenceSequence")
		public MutualOrOptionalEarlyTerminationModelSequenceSequence getMutualOrOptionalEarlyTerminationModelSequenceSequence() {
			return mutualOrOptionalEarlyTerminationModelSequenceSequence;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModelSequence build() {
			return this;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder toBuilder() {
			MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder builder) {
			ofNullable(getOptionalEarlyTermination()).ifPresent(builder::setOptionalEarlyTermination);
			ofNullable(getOptionalEarlyTerminationDate()).ifPresent(builder::setOptionalEarlyTerminationDate);
			ofNullable(getOptionalEarlyTerminationElectingPartyReference()).ifPresent(builder::setOptionalEarlyTerminationElectingPartyReference);
			ofNullable(getBreakFundingRecovery()).ifPresent(builder::setBreakFundingRecovery);
			ofNullable(getMutualOrOptionalEarlyTerminationModelSequenceSequence()).ifPresent(builder::setMutualOrOptionalEarlyTerminationModelSequenceSequence);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MutualOrOptionalEarlyTerminationModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(optionalEarlyTermination, _that.getOptionalEarlyTermination())) return false;
			if (!Objects.equals(optionalEarlyTerminationDate, _that.getOptionalEarlyTerminationDate())) return false;
			if (!Objects.equals(optionalEarlyTerminationElectingPartyReference, _that.getOptionalEarlyTerminationElectingPartyReference())) return false;
			if (!Objects.equals(breakFundingRecovery, _that.getBreakFundingRecovery())) return false;
			if (!Objects.equals(mutualOrOptionalEarlyTerminationModelSequenceSequence, _that.getMutualOrOptionalEarlyTerminationModelSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionalEarlyTermination != null ? optionalEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationDate != null ? optionalEarlyTerminationDate.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationElectingPartyReference != null ? optionalEarlyTerminationElectingPartyReference.hashCode() : 0);
			_result = 31 * _result + (breakFundingRecovery != null ? breakFundingRecovery.hashCode() : 0);
			_result = 31 * _result + (mutualOrOptionalEarlyTerminationModelSequenceSequence != null ? mutualOrOptionalEarlyTerminationModelSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutualOrOptionalEarlyTerminationModelSequence {" +
				"optionalEarlyTermination=" + this.optionalEarlyTermination + ", " +
				"optionalEarlyTerminationDate=" + this.optionalEarlyTerminationDate + ", " +
				"optionalEarlyTerminationElectingPartyReference=" + this.optionalEarlyTerminationElectingPartyReference + ", " +
				"breakFundingRecovery=" + this.breakFundingRecovery + ", " +
				"mutualOrOptionalEarlyTerminationModelSequenceSequence=" + this.mutualOrOptionalEarlyTerminationModelSequenceSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of MutualOrOptionalEarlyTerminationModelSequence  ***********************/
	class MutualOrOptionalEarlyTerminationModelSequenceBuilderImpl implements MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder {
	
		protected Boolean optionalEarlyTermination;
		protected EarlyTerminationDateEnum optionalEarlyTerminationDate;
		protected PartyReference.PartyReferenceBuilder optionalEarlyTerminationElectingPartyReference;
		protected Boolean breakFundingRecovery;
		protected MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder mutualOrOptionalEarlyTerminationModelSequenceSequence;
	
		public MutualOrOptionalEarlyTerminationModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		public Boolean getOptionalEarlyTermination() {
			return optionalEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationDate")
		public EarlyTerminationDateEnum getOptionalEarlyTerminationDate() {
			return optionalEarlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationElectingPartyReference")
		public PartyReference.PartyReferenceBuilder getOptionalEarlyTerminationElectingPartyReference() {
			return optionalEarlyTerminationElectingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOptionalEarlyTerminationElectingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (optionalEarlyTerminationElectingPartyReference!=null) {
				result = optionalEarlyTerminationElectingPartyReference;
			}
			else {
				result = optionalEarlyTerminationElectingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("breakFundingRecovery")
		public Boolean getBreakFundingRecovery() {
			return breakFundingRecovery;
		}
		
		@Override
		@RosettaAttribute("mutualOrOptionalEarlyTerminationModelSequenceSequence")
		public MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder getMutualOrOptionalEarlyTerminationModelSequenceSequence() {
			return mutualOrOptionalEarlyTerminationModelSequenceSequence;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder getOrCreateMutualOrOptionalEarlyTerminationModelSequenceSequence() {
			MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder result;
			if (mutualOrOptionalEarlyTerminationModelSequenceSequence!=null) {
				result = mutualOrOptionalEarlyTerminationModelSequenceSequence;
			}
			else {
				result = mutualOrOptionalEarlyTerminationModelSequenceSequence = MutualOrOptionalEarlyTerminationModelSequenceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		public MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder setOptionalEarlyTermination(Boolean optionalEarlyTermination) {
			this.optionalEarlyTermination = optionalEarlyTermination==null?null:optionalEarlyTermination;
			return this;
		}
		@Override
		@RosettaAttribute("optionalEarlyTerminationDate")
		public MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder setOptionalEarlyTerminationDate(EarlyTerminationDateEnum optionalEarlyTerminationDate) {
			this.optionalEarlyTerminationDate = optionalEarlyTerminationDate==null?null:optionalEarlyTerminationDate;
			return this;
		}
		@Override
		@RosettaAttribute("optionalEarlyTerminationElectingPartyReference")
		public MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder setOptionalEarlyTerminationElectingPartyReference(PartyReference optionalEarlyTerminationElectingPartyReference) {
			this.optionalEarlyTerminationElectingPartyReference = optionalEarlyTerminationElectingPartyReference==null?null:optionalEarlyTerminationElectingPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("breakFundingRecovery")
		public MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder setBreakFundingRecovery(Boolean breakFundingRecovery) {
			this.breakFundingRecovery = breakFundingRecovery==null?null:breakFundingRecovery;
			return this;
		}
		@Override
		@RosettaAttribute("mutualOrOptionalEarlyTerminationModelSequenceSequence")
		public MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder setMutualOrOptionalEarlyTerminationModelSequenceSequence(MutualOrOptionalEarlyTerminationModelSequenceSequence mutualOrOptionalEarlyTerminationModelSequenceSequence) {
			this.mutualOrOptionalEarlyTerminationModelSequenceSequence = mutualOrOptionalEarlyTerminationModelSequenceSequence==null?null:mutualOrOptionalEarlyTerminationModelSequenceSequence.toBuilder();
			return this;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModelSequence build() {
			return new MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceImpl(this);
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder prune() {
			if (optionalEarlyTerminationElectingPartyReference!=null && !optionalEarlyTerminationElectingPartyReference.prune().hasData()) optionalEarlyTerminationElectingPartyReference = null;
			if (mutualOrOptionalEarlyTerminationModelSequenceSequence!=null && !mutualOrOptionalEarlyTerminationModelSequenceSequence.prune().hasData()) mutualOrOptionalEarlyTerminationModelSequenceSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOptionalEarlyTermination()!=null) return true;
			if (getOptionalEarlyTerminationDate()!=null) return true;
			if (getOptionalEarlyTerminationElectingPartyReference()!=null && getOptionalEarlyTerminationElectingPartyReference().hasData()) return true;
			if (getBreakFundingRecovery()!=null) return true;
			if (getMutualOrOptionalEarlyTerminationModelSequenceSequence()!=null && getMutualOrOptionalEarlyTerminationModelSequenceSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder o = (MutualOrOptionalEarlyTerminationModelSequence.MutualOrOptionalEarlyTerminationModelSequenceBuilder) other;
			
			merger.mergeRosetta(getOptionalEarlyTerminationElectingPartyReference(), o.getOptionalEarlyTerminationElectingPartyReference(), this::setOptionalEarlyTerminationElectingPartyReference);
			merger.mergeRosetta(getMutualOrOptionalEarlyTerminationModelSequenceSequence(), o.getMutualOrOptionalEarlyTerminationModelSequenceSequence(), this::setMutualOrOptionalEarlyTerminationModelSequenceSequence);
			
			merger.mergeBasic(getOptionalEarlyTermination(), o.getOptionalEarlyTermination(), this::setOptionalEarlyTermination);
			merger.mergeBasic(getOptionalEarlyTerminationDate(), o.getOptionalEarlyTerminationDate(), this::setOptionalEarlyTerminationDate);
			merger.mergeBasic(getBreakFundingRecovery(), o.getBreakFundingRecovery(), this::setBreakFundingRecovery);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MutualOrOptionalEarlyTerminationModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(optionalEarlyTermination, _that.getOptionalEarlyTermination())) return false;
			if (!Objects.equals(optionalEarlyTerminationDate, _that.getOptionalEarlyTerminationDate())) return false;
			if (!Objects.equals(optionalEarlyTerminationElectingPartyReference, _that.getOptionalEarlyTerminationElectingPartyReference())) return false;
			if (!Objects.equals(breakFundingRecovery, _that.getBreakFundingRecovery())) return false;
			if (!Objects.equals(mutualOrOptionalEarlyTerminationModelSequenceSequence, _that.getMutualOrOptionalEarlyTerminationModelSequenceSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionalEarlyTermination != null ? optionalEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationDate != null ? optionalEarlyTerminationDate.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationElectingPartyReference != null ? optionalEarlyTerminationElectingPartyReference.hashCode() : 0);
			_result = 31 * _result + (breakFundingRecovery != null ? breakFundingRecovery.hashCode() : 0);
			_result = 31 * _result + (mutualOrOptionalEarlyTerminationModelSequenceSequence != null ? mutualOrOptionalEarlyTerminationModelSequenceSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutualOrOptionalEarlyTerminationModelSequenceBuilder {" +
				"optionalEarlyTermination=" + this.optionalEarlyTermination + ", " +
				"optionalEarlyTerminationDate=" + this.optionalEarlyTerminationDate + ", " +
				"optionalEarlyTerminationElectingPartyReference=" + this.optionalEarlyTerminationElectingPartyReference + ", " +
				"breakFundingRecovery=" + this.breakFundingRecovery + ", " +
				"mutualOrOptionalEarlyTerminationModelSequenceSequence=" + this.mutualOrOptionalEarlyTerminationModelSequenceSequence +
			'}';
		}
	}
}
