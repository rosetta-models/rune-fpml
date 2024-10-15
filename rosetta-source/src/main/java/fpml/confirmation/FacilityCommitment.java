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
import fpml.confirmation.FacilityCommitment;
import fpml.confirmation.FacilityCommitment.FacilityCommitmentBuilder;
import fpml.confirmation.FacilityCommitment.FacilityCommitmentBuilderImpl;
import fpml.confirmation.FacilityCommitment.FacilityCommitmentImpl;
import fpml.confirmation.FacilityCommitmentSequence;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.meta.FacilityCommitmentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents the commitment amount against a facility or facility portion. Also shows the utilization levels against the total commitment amount (in facility currency).
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityCommitment", builder=FacilityCommitment.FacilityCommitmentBuilderImpl.class, version="${project.version}")
public interface FacilityCommitment extends RosettaModelObject {

	FacilityCommitmentMeta metaData = new FacilityCommitmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The total commitment level associated with the facility or facility portion (in facility currency).
	 */
	MoneyWithParticipantShare getTotalCommitmentAmount();
	FacilityCommitmentSequence getFacilityCommitmentSequence();

	/*********************** Build Methods  ***********************/
	FacilityCommitment build();
	
	FacilityCommitment.FacilityCommitmentBuilder toBuilder();
	
	static FacilityCommitment.FacilityCommitmentBuilder builder() {
		return new FacilityCommitment.FacilityCommitmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityCommitment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityCommitment> getType() {
		return FacilityCommitment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("totalCommitmentAmount"), processor, MoneyWithParticipantShare.class, getTotalCommitmentAmount());
		processRosetta(path.newSubPath("facilityCommitmentSequence"), processor, FacilityCommitmentSequence.class, getFacilityCommitmentSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityCommitmentBuilder extends FacilityCommitment, RosettaModelObjectBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateTotalCommitmentAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getTotalCommitmentAmount();
		FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder getOrCreateFacilityCommitmentSequence();
		FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder getFacilityCommitmentSequence();
		FacilityCommitment.FacilityCommitmentBuilder setTotalCommitmentAmount(MoneyWithParticipantShare totalCommitmentAmount);
		FacilityCommitment.FacilityCommitmentBuilder setFacilityCommitmentSequence(FacilityCommitmentSequence facilityCommitmentSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("totalCommitmentAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getTotalCommitmentAmount());
			processRosetta(path.newSubPath("facilityCommitmentSequence"), processor, FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder.class, getFacilityCommitmentSequence());
		}
		

		FacilityCommitment.FacilityCommitmentBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityCommitment  ***********************/
	class FacilityCommitmentImpl implements FacilityCommitment {
		private final MoneyWithParticipantShare totalCommitmentAmount;
		private final FacilityCommitmentSequence facilityCommitmentSequence;
		
		protected FacilityCommitmentImpl(FacilityCommitment.FacilityCommitmentBuilder builder) {
			this.totalCommitmentAmount = ofNullable(builder.getTotalCommitmentAmount()).map(f->f.build()).orElse(null);
			this.facilityCommitmentSequence = ofNullable(builder.getFacilityCommitmentSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("totalCommitmentAmount")
		public MoneyWithParticipantShare getTotalCommitmentAmount() {
			return totalCommitmentAmount;
		}
		
		@Override
		@RosettaAttribute("facilityCommitmentSequence")
		public FacilityCommitmentSequence getFacilityCommitmentSequence() {
			return facilityCommitmentSequence;
		}
		
		@Override
		public FacilityCommitment build() {
			return this;
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder toBuilder() {
			FacilityCommitment.FacilityCommitmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityCommitment.FacilityCommitmentBuilder builder) {
			ofNullable(getTotalCommitmentAmount()).ifPresent(builder::setTotalCommitmentAmount);
			ofNullable(getFacilityCommitmentSequence()).ifPresent(builder::setFacilityCommitmentSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityCommitment _that = getType().cast(o);
		
			if (!Objects.equals(totalCommitmentAmount, _that.getTotalCommitmentAmount())) return false;
			if (!Objects.equals(facilityCommitmentSequence, _that.getFacilityCommitmentSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (totalCommitmentAmount != null ? totalCommitmentAmount.hashCode() : 0);
			_result = 31 * _result + (facilityCommitmentSequence != null ? facilityCommitmentSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityCommitment {" +
				"totalCommitmentAmount=" + this.totalCommitmentAmount + ", " +
				"facilityCommitmentSequence=" + this.facilityCommitmentSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityCommitment  ***********************/
	class FacilityCommitmentBuilderImpl implements FacilityCommitment.FacilityCommitmentBuilder {
	
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder totalCommitmentAmount;
		protected FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder facilityCommitmentSequence;
	
		public FacilityCommitmentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("totalCommitmentAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getTotalCommitmentAmount() {
			return totalCommitmentAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateTotalCommitmentAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (totalCommitmentAmount!=null) {
				result = totalCommitmentAmount;
			}
			else {
				result = totalCommitmentAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityCommitmentSequence")
		public FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder getFacilityCommitmentSequence() {
			return facilityCommitmentSequence;
		}
		
		@Override
		public FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder getOrCreateFacilityCommitmentSequence() {
			FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder result;
			if (facilityCommitmentSequence!=null) {
				result = facilityCommitmentSequence;
			}
			else {
				result = facilityCommitmentSequence = FacilityCommitmentSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("totalCommitmentAmount")
		public FacilityCommitment.FacilityCommitmentBuilder setTotalCommitmentAmount(MoneyWithParticipantShare totalCommitmentAmount) {
			this.totalCommitmentAmount = totalCommitmentAmount==null?null:totalCommitmentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityCommitmentSequence")
		public FacilityCommitment.FacilityCommitmentBuilder setFacilityCommitmentSequence(FacilityCommitmentSequence facilityCommitmentSequence) {
			this.facilityCommitmentSequence = facilityCommitmentSequence==null?null:facilityCommitmentSequence.toBuilder();
			return this;
		}
		
		@Override
		public FacilityCommitment build() {
			return new FacilityCommitment.FacilityCommitmentImpl(this);
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder prune() {
			if (totalCommitmentAmount!=null && !totalCommitmentAmount.prune().hasData()) totalCommitmentAmount = null;
			if (facilityCommitmentSequence!=null && !facilityCommitmentSequence.prune().hasData()) facilityCommitmentSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTotalCommitmentAmount()!=null && getTotalCommitmentAmount().hasData()) return true;
			if (getFacilityCommitmentSequence()!=null && getFacilityCommitmentSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityCommitment.FacilityCommitmentBuilder o = (FacilityCommitment.FacilityCommitmentBuilder) other;
			
			merger.mergeRosetta(getTotalCommitmentAmount(), o.getTotalCommitmentAmount(), this::setTotalCommitmentAmount);
			merger.mergeRosetta(getFacilityCommitmentSequence(), o.getFacilityCommitmentSequence(), this::setFacilityCommitmentSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityCommitment _that = getType().cast(o);
		
			if (!Objects.equals(totalCommitmentAmount, _that.getTotalCommitmentAmount())) return false;
			if (!Objects.equals(facilityCommitmentSequence, _that.getFacilityCommitmentSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (totalCommitmentAmount != null ? totalCommitmentAmount.hashCode() : 0);
			_result = 31 * _result + (facilityCommitmentSequence != null ? facilityCommitmentSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityCommitmentBuilder {" +
				"totalCommitmentAmount=" + this.totalCommitmentAmount + ", " +
				"facilityCommitmentSequence=" + this.facilityCommitmentSequence +
			'}';
		}
	}
}
