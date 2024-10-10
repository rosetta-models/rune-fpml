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
import fpml.confirmation.CommitmentSchedule;
import fpml.confirmation.FacilityCommitment;
import fpml.confirmation.FacilityCommitmentModel;
import fpml.confirmation.FacilityCommitmentModel.FacilityCommitmentModelBuilder;
import fpml.confirmation.FacilityCommitmentModel.FacilityCommitmentModelBuilderImpl;
import fpml.confirmation.FacilityCommitmentModel.FacilityCommitmentModelImpl;
import fpml.confirmation.FxTerms;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.meta.FacilityCommitmentModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that describes facility commitment information together with any schedule associated with the commitment.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityCommitmentModel", builder=FacilityCommitmentModel.FacilityCommitmentModelBuilderImpl.class, version="${project.version}")
public interface FacilityCommitmentModel extends RosettaModelObject {

	FacilityCommitmentModelMeta metaData = new FacilityCommitmentModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The current global/lender share commitment amount. This defines the current limit against which the borrower may draw funds.
	 */
	FacilityCommitment getCurrentCommitment();
	/**
	 * The original global commitment amount. This defines the limit, as of the start date, against which the borrower may draw funds.
	 */
	MoneyWithParticipantShare getOriginalCommitment();
	/**
	 * The commitment schedule associated with the facility.
	 */
	CommitmentSchedule getCommitmentSchedule();
	/**
	 * Defines the exchange rate between the facility and deal denomination currencies (only required if the currencies are different).
	 */
	FxTerms getDealFxRate();

	/*********************** Build Methods  ***********************/
	FacilityCommitmentModel build();
	
	FacilityCommitmentModel.FacilityCommitmentModelBuilder toBuilder();
	
	static FacilityCommitmentModel.FacilityCommitmentModelBuilder builder() {
		return new FacilityCommitmentModel.FacilityCommitmentModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityCommitmentModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityCommitmentModel> getType() {
		return FacilityCommitmentModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currentCommitment"), processor, FacilityCommitment.class, getCurrentCommitment());
		processRosetta(path.newSubPath("originalCommitment"), processor, MoneyWithParticipantShare.class, getOriginalCommitment());
		processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.class, getCommitmentSchedule());
		processRosetta(path.newSubPath("dealFxRate"), processor, FxTerms.class, getDealFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityCommitmentModelBuilder extends FacilityCommitmentModel, RosettaModelObjectBuilder {
		FacilityCommitment.FacilityCommitmentBuilder getOrCreateCurrentCommitment();
		FacilityCommitment.FacilityCommitmentBuilder getCurrentCommitment();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateOriginalCommitment();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOriginalCommitment();
		CommitmentSchedule.CommitmentScheduleBuilder getOrCreateCommitmentSchedule();
		CommitmentSchedule.CommitmentScheduleBuilder getCommitmentSchedule();
		FxTerms.FxTermsBuilder getOrCreateDealFxRate();
		FxTerms.FxTermsBuilder getDealFxRate();
		FacilityCommitmentModel.FacilityCommitmentModelBuilder setCurrentCommitment(FacilityCommitment currentCommitment);
		FacilityCommitmentModel.FacilityCommitmentModelBuilder setOriginalCommitment(MoneyWithParticipantShare originalCommitment);
		FacilityCommitmentModel.FacilityCommitmentModelBuilder setCommitmentSchedule(CommitmentSchedule commitmentSchedule);
		FacilityCommitmentModel.FacilityCommitmentModelBuilder setDealFxRate(FxTerms dealFxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currentCommitment"), processor, FacilityCommitment.FacilityCommitmentBuilder.class, getCurrentCommitment());
			processRosetta(path.newSubPath("originalCommitment"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getOriginalCommitment());
			processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.CommitmentScheduleBuilder.class, getCommitmentSchedule());
			processRosetta(path.newSubPath("dealFxRate"), processor, FxTerms.FxTermsBuilder.class, getDealFxRate());
		}
		

		FacilityCommitmentModel.FacilityCommitmentModelBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityCommitmentModel  ***********************/
	class FacilityCommitmentModelImpl implements FacilityCommitmentModel {
		private final FacilityCommitment currentCommitment;
		private final MoneyWithParticipantShare originalCommitment;
		private final CommitmentSchedule commitmentSchedule;
		private final FxTerms dealFxRate;
		
		protected FacilityCommitmentModelImpl(FacilityCommitmentModel.FacilityCommitmentModelBuilder builder) {
			this.currentCommitment = ofNullable(builder.getCurrentCommitment()).map(f->f.build()).orElse(null);
			this.originalCommitment = ofNullable(builder.getOriginalCommitment()).map(f->f.build()).orElse(null);
			this.commitmentSchedule = ofNullable(builder.getCommitmentSchedule()).map(f->f.build()).orElse(null);
			this.dealFxRate = ofNullable(builder.getDealFxRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currentCommitment")
		public FacilityCommitment getCurrentCommitment() {
			return currentCommitment;
		}
		
		@Override
		@RosettaAttribute("originalCommitment")
		public MoneyWithParticipantShare getOriginalCommitment() {
			return originalCommitment;
		}
		
		@Override
		@RosettaAttribute("commitmentSchedule")
		public CommitmentSchedule getCommitmentSchedule() {
			return commitmentSchedule;
		}
		
		@Override
		@RosettaAttribute("dealFxRate")
		public FxTerms getDealFxRate() {
			return dealFxRate;
		}
		
		@Override
		public FacilityCommitmentModel build() {
			return this;
		}
		
		@Override
		public FacilityCommitmentModel.FacilityCommitmentModelBuilder toBuilder() {
			FacilityCommitmentModel.FacilityCommitmentModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityCommitmentModel.FacilityCommitmentModelBuilder builder) {
			ofNullable(getCurrentCommitment()).ifPresent(builder::setCurrentCommitment);
			ofNullable(getOriginalCommitment()).ifPresent(builder::setOriginalCommitment);
			ofNullable(getCommitmentSchedule()).ifPresent(builder::setCommitmentSchedule);
			ofNullable(getDealFxRate()).ifPresent(builder::setDealFxRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityCommitmentModel _that = getType().cast(o);
		
			if (!Objects.equals(currentCommitment, _that.getCurrentCommitment())) return false;
			if (!Objects.equals(originalCommitment, _that.getOriginalCommitment())) return false;
			if (!Objects.equals(commitmentSchedule, _that.getCommitmentSchedule())) return false;
			if (!Objects.equals(dealFxRate, _that.getDealFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currentCommitment != null ? currentCommitment.hashCode() : 0);
			_result = 31 * _result + (originalCommitment != null ? originalCommitment.hashCode() : 0);
			_result = 31 * _result + (commitmentSchedule != null ? commitmentSchedule.hashCode() : 0);
			_result = 31 * _result + (dealFxRate != null ? dealFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityCommitmentModel {" +
				"currentCommitment=" + this.currentCommitment + ", " +
				"originalCommitment=" + this.originalCommitment + ", " +
				"commitmentSchedule=" + this.commitmentSchedule + ", " +
				"dealFxRate=" + this.dealFxRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityCommitmentModel  ***********************/
	class FacilityCommitmentModelBuilderImpl implements FacilityCommitmentModel.FacilityCommitmentModelBuilder {
	
		protected FacilityCommitment.FacilityCommitmentBuilder currentCommitment;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder originalCommitment;
		protected CommitmentSchedule.CommitmentScheduleBuilder commitmentSchedule;
		protected FxTerms.FxTermsBuilder dealFxRate;
	
		public FacilityCommitmentModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currentCommitment")
		public FacilityCommitment.FacilityCommitmentBuilder getCurrentCommitment() {
			return currentCommitment;
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder getOrCreateCurrentCommitment() {
			FacilityCommitment.FacilityCommitmentBuilder result;
			if (currentCommitment!=null) {
				result = currentCommitment;
			}
			else {
				result = currentCommitment = FacilityCommitment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originalCommitment")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOriginalCommitment() {
			return originalCommitment;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateOriginalCommitment() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (originalCommitment!=null) {
				result = originalCommitment;
			}
			else {
				result = originalCommitment = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commitmentSchedule")
		public CommitmentSchedule.CommitmentScheduleBuilder getCommitmentSchedule() {
			return commitmentSchedule;
		}
		
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder getOrCreateCommitmentSchedule() {
			CommitmentSchedule.CommitmentScheduleBuilder result;
			if (commitmentSchedule!=null) {
				result = commitmentSchedule;
			}
			else {
				result = commitmentSchedule = CommitmentSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealFxRate")
		public FxTerms.FxTermsBuilder getDealFxRate() {
			return dealFxRate;
		}
		
		@Override
		public FxTerms.FxTermsBuilder getOrCreateDealFxRate() {
			FxTerms.FxTermsBuilder result;
			if (dealFxRate!=null) {
				result = dealFxRate;
			}
			else {
				result = dealFxRate = FxTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currentCommitment")
		public FacilityCommitmentModel.FacilityCommitmentModelBuilder setCurrentCommitment(FacilityCommitment currentCommitment) {
			this.currentCommitment = currentCommitment==null?null:currentCommitment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originalCommitment")
		public FacilityCommitmentModel.FacilityCommitmentModelBuilder setOriginalCommitment(MoneyWithParticipantShare originalCommitment) {
			this.originalCommitment = originalCommitment==null?null:originalCommitment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commitmentSchedule")
		public FacilityCommitmentModel.FacilityCommitmentModelBuilder setCommitmentSchedule(CommitmentSchedule commitmentSchedule) {
			this.commitmentSchedule = commitmentSchedule==null?null:commitmentSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dealFxRate")
		public FacilityCommitmentModel.FacilityCommitmentModelBuilder setDealFxRate(FxTerms dealFxRate) {
			this.dealFxRate = dealFxRate==null?null:dealFxRate.toBuilder();
			return this;
		}
		
		@Override
		public FacilityCommitmentModel build() {
			return new FacilityCommitmentModel.FacilityCommitmentModelImpl(this);
		}
		
		@Override
		public FacilityCommitmentModel.FacilityCommitmentModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityCommitmentModel.FacilityCommitmentModelBuilder prune() {
			if (currentCommitment!=null && !currentCommitment.prune().hasData()) currentCommitment = null;
			if (originalCommitment!=null && !originalCommitment.prune().hasData()) originalCommitment = null;
			if (commitmentSchedule!=null && !commitmentSchedule.prune().hasData()) commitmentSchedule = null;
			if (dealFxRate!=null && !dealFxRate.prune().hasData()) dealFxRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrentCommitment()!=null && getCurrentCommitment().hasData()) return true;
			if (getOriginalCommitment()!=null && getOriginalCommitment().hasData()) return true;
			if (getCommitmentSchedule()!=null && getCommitmentSchedule().hasData()) return true;
			if (getDealFxRate()!=null && getDealFxRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityCommitmentModel.FacilityCommitmentModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityCommitmentModel.FacilityCommitmentModelBuilder o = (FacilityCommitmentModel.FacilityCommitmentModelBuilder) other;
			
			merger.mergeRosetta(getCurrentCommitment(), o.getCurrentCommitment(), this::setCurrentCommitment);
			merger.mergeRosetta(getOriginalCommitment(), o.getOriginalCommitment(), this::setOriginalCommitment);
			merger.mergeRosetta(getCommitmentSchedule(), o.getCommitmentSchedule(), this::setCommitmentSchedule);
			merger.mergeRosetta(getDealFxRate(), o.getDealFxRate(), this::setDealFxRate);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityCommitmentModel _that = getType().cast(o);
		
			if (!Objects.equals(currentCommitment, _that.getCurrentCommitment())) return false;
			if (!Objects.equals(originalCommitment, _that.getOriginalCommitment())) return false;
			if (!Objects.equals(commitmentSchedule, _that.getCommitmentSchedule())) return false;
			if (!Objects.equals(dealFxRate, _that.getDealFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currentCommitment != null ? currentCommitment.hashCode() : 0);
			_result = 31 * _result + (originalCommitment != null ? originalCommitment.hashCode() : 0);
			_result = 31 * _result + (commitmentSchedule != null ? commitmentSchedule.hashCode() : 0);
			_result = 31 * _result + (dealFxRate != null ? dealFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityCommitmentModelBuilder {" +
				"currentCommitment=" + this.currentCommitment + ", " +
				"originalCommitment=" + this.originalCommitment + ", " +
				"commitmentSchedule=" + this.commitmentSchedule + ", " +
				"dealFxRate=" + this.dealFxRate +
			'}';
		}
	}
}
