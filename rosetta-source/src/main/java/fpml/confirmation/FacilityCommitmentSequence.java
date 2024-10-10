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
import fpml.confirmation.FacilityCommitmentSequence;
import fpml.confirmation.FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder;
import fpml.confirmation.FacilityCommitmentSequence.FacilityCommitmentSequenceBuilderImpl;
import fpml.confirmation.FacilityCommitmentSequence.FacilityCommitmentSequenceImpl;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.UtilizationModel;
import fpml.confirmation.meta.FacilityCommitmentSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityCommitmentSequence", builder=FacilityCommitmentSequence.FacilityCommitmentSequenceBuilderImpl.class, version="${project.version}")
public interface FacilityCommitmentSequence extends RosettaModelObject {

	FacilityCommitmentSequenceMeta metaData = new FacilityCommitmentSequenceMeta();

	/*********************** Getter Methods  ***********************/
	UtilizationModel getUtilizationModel();
	/**
	 * The portion of the commitment amount which is NOT available for the borrower to draw against.
	 */
	MoneyWithParticipantShare getUnavailableToUtilizeAmount();

	/*********************** Build Methods  ***********************/
	FacilityCommitmentSequence build();
	
	FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder toBuilder();
	
	static FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder builder() {
		return new FacilityCommitmentSequence.FacilityCommitmentSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityCommitmentSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityCommitmentSequence> getType() {
		return FacilityCommitmentSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("utilizationModel"), processor, UtilizationModel.class, getUtilizationModel());
		processRosetta(path.newSubPath("unavailableToUtilizeAmount"), processor, MoneyWithParticipantShare.class, getUnavailableToUtilizeAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityCommitmentSequenceBuilder extends FacilityCommitmentSequence, RosettaModelObjectBuilder {
		UtilizationModel.UtilizationModelBuilder getOrCreateUtilizationModel();
		UtilizationModel.UtilizationModelBuilder getUtilizationModel();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateUnavailableToUtilizeAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getUnavailableToUtilizeAmount();
		FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder setUtilizationModel(UtilizationModel utilizationModel);
		FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder setUnavailableToUtilizeAmount(MoneyWithParticipantShare unavailableToUtilizeAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("utilizationModel"), processor, UtilizationModel.UtilizationModelBuilder.class, getUtilizationModel());
			processRosetta(path.newSubPath("unavailableToUtilizeAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getUnavailableToUtilizeAmount());
		}
		

		FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityCommitmentSequence  ***********************/
	class FacilityCommitmentSequenceImpl implements FacilityCommitmentSequence {
		private final UtilizationModel utilizationModel;
		private final MoneyWithParticipantShare unavailableToUtilizeAmount;
		
		protected FacilityCommitmentSequenceImpl(FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder builder) {
			this.utilizationModel = ofNullable(builder.getUtilizationModel()).map(f->f.build()).orElse(null);
			this.unavailableToUtilizeAmount = ofNullable(builder.getUnavailableToUtilizeAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("utilizationModel")
		public UtilizationModel getUtilizationModel() {
			return utilizationModel;
		}
		
		@Override
		@RosettaAttribute("unavailableToUtilizeAmount")
		public MoneyWithParticipantShare getUnavailableToUtilizeAmount() {
			return unavailableToUtilizeAmount;
		}
		
		@Override
		public FacilityCommitmentSequence build() {
			return this;
		}
		
		@Override
		public FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder toBuilder() {
			FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder builder) {
			ofNullable(getUtilizationModel()).ifPresent(builder::setUtilizationModel);
			ofNullable(getUnavailableToUtilizeAmount()).ifPresent(builder::setUnavailableToUtilizeAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityCommitmentSequence _that = getType().cast(o);
		
			if (!Objects.equals(utilizationModel, _that.getUtilizationModel())) return false;
			if (!Objects.equals(unavailableToUtilizeAmount, _that.getUnavailableToUtilizeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (utilizationModel != null ? utilizationModel.hashCode() : 0);
			_result = 31 * _result + (unavailableToUtilizeAmount != null ? unavailableToUtilizeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityCommitmentSequence {" +
				"utilizationModel=" + this.utilizationModel + ", " +
				"unavailableToUtilizeAmount=" + this.unavailableToUtilizeAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityCommitmentSequence  ***********************/
	class FacilityCommitmentSequenceBuilderImpl implements FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder {
	
		protected UtilizationModel.UtilizationModelBuilder utilizationModel;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder unavailableToUtilizeAmount;
	
		public FacilityCommitmentSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("utilizationModel")
		public UtilizationModel.UtilizationModelBuilder getUtilizationModel() {
			return utilizationModel;
		}
		
		@Override
		public UtilizationModel.UtilizationModelBuilder getOrCreateUtilizationModel() {
			UtilizationModel.UtilizationModelBuilder result;
			if (utilizationModel!=null) {
				result = utilizationModel;
			}
			else {
				result = utilizationModel = UtilizationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unavailableToUtilizeAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getUnavailableToUtilizeAmount() {
			return unavailableToUtilizeAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateUnavailableToUtilizeAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (unavailableToUtilizeAmount!=null) {
				result = unavailableToUtilizeAmount;
			}
			else {
				result = unavailableToUtilizeAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("utilizationModel")
		public FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder setUtilizationModel(UtilizationModel utilizationModel) {
			this.utilizationModel = utilizationModel==null?null:utilizationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("unavailableToUtilizeAmount")
		public FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder setUnavailableToUtilizeAmount(MoneyWithParticipantShare unavailableToUtilizeAmount) {
			this.unavailableToUtilizeAmount = unavailableToUtilizeAmount==null?null:unavailableToUtilizeAmount.toBuilder();
			return this;
		}
		
		@Override
		public FacilityCommitmentSequence build() {
			return new FacilityCommitmentSequence.FacilityCommitmentSequenceImpl(this);
		}
		
		@Override
		public FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder prune() {
			if (utilizationModel!=null && !utilizationModel.prune().hasData()) utilizationModel = null;
			if (unavailableToUtilizeAmount!=null && !unavailableToUtilizeAmount.prune().hasData()) unavailableToUtilizeAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUtilizationModel()!=null && getUtilizationModel().hasData()) return true;
			if (getUnavailableToUtilizeAmount()!=null && getUnavailableToUtilizeAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder o = (FacilityCommitmentSequence.FacilityCommitmentSequenceBuilder) other;
			
			merger.mergeRosetta(getUtilizationModel(), o.getUtilizationModel(), this::setUtilizationModel);
			merger.mergeRosetta(getUnavailableToUtilizeAmount(), o.getUnavailableToUtilizeAmount(), this::setUnavailableToUtilizeAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityCommitmentSequence _that = getType().cast(o);
		
			if (!Objects.equals(utilizationModel, _that.getUtilizationModel())) return false;
			if (!Objects.equals(unavailableToUtilizeAmount, _that.getUnavailableToUtilizeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (utilizationModel != null ? utilizationModel.hashCode() : 0);
			_result = 31 * _result + (unavailableToUtilizeAmount != null ? unavailableToUtilizeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityCommitmentSequenceBuilder {" +
				"utilizationModel=" + this.utilizationModel + ", " +
				"unavailableToUtilizeAmount=" + this.unavailableToUtilizeAmount +
			'}';
		}
	}
}
