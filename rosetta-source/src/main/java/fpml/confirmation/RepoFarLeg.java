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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FxRate;
import fpml.confirmation.RepoFarLeg;
import fpml.confirmation.RepoFarLeg.RepoFarLegBuilder;
import fpml.confirmation.RepoFarLeg.RepoFarLegBuilderImpl;
import fpml.confirmation.RepoFarLeg.RepoFarLegImpl;
import fpml.confirmation.RepoFarLegSequence;
import fpml.confirmation.RepoLegBase;
import fpml.confirmation.RepoLegBase.RepoLegBaseBuilder;
import fpml.confirmation.RepoLegBase.RepoLegBaseBuilderImpl;
import fpml.confirmation.RepoLegBase.RepoLegBaseImpl;
import fpml.confirmation.SettlementAmountOrCurrencyModel;
import fpml.confirmation.meta.RepoFarLegMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A transaction leg for a repo is equivalent to a single cash transaction. It is augmented here to carry some values that are of interest for the repo. Also note that the BuyerSeller model in this transaction must be the exact opposite of the one found in the near leg.
 * @version ${project.version}
 */
@RosettaDataType(value="RepoFarLeg", builder=RepoFarLeg.RepoFarLegBuilderImpl.class, version="${project.version}")
public interface RepoFarLeg extends RepoLegBase {

	RepoFarLegMeta metaData = new RepoFarLegMeta();

	/*********************** Getter Methods  ***********************/
	SettlementAmountOrCurrencyModel getSettlementAmountOrCurrencyModel();
	/**
	 * Indicates the rate of a currency conversion that is used to compute settlement amount for cross-currency transactions.
	 */
	FxRate getFxRate();
	RepoFarLegSequence getRepoFarLegSequence();
	/**
	 * The repo interest is basically the difference between the settlement amounts at spot and forward date. It is a fully figured amount, but it does not have to be specified in the message. It is not a &#39;Money&#39; amount as it is implicitly expressed in the settlement currency.
	 */
	BigDecimal getRepoInterest();

	/*********************** Build Methods  ***********************/
	RepoFarLeg build();
	
	RepoFarLeg.RepoFarLegBuilder toBuilder();
	
	static RepoFarLeg.RepoFarLegBuilder builder() {
		return new RepoFarLeg.RepoFarLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RepoFarLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RepoFarLeg> getType() {
		return RepoFarLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementAmountOrCurrencyModel"), processor, SettlementAmountOrCurrencyModel.class, getSettlementAmountOrCurrencyModel());
		processRosetta(path.newSubPath("fxRate"), processor, FxRate.class, getFxRate());
		processRosetta(path.newSubPath("repoFarLegSequence"), processor, RepoFarLegSequence.class, getRepoFarLegSequence());
		processor.processBasic(path.newSubPath("repoInterest"), BigDecimal.class, getRepoInterest(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepoFarLegBuilder extends RepoFarLeg, RepoLegBase.RepoLegBaseBuilder {
		SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder getOrCreateSettlementAmountOrCurrencyModel();
		SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder getSettlementAmountOrCurrencyModel();
		FxRate.FxRateBuilder getOrCreateFxRate();
		FxRate.FxRateBuilder getFxRate();
		RepoFarLegSequence.RepoFarLegSequenceBuilder getOrCreateRepoFarLegSequence();
		RepoFarLegSequence.RepoFarLegSequenceBuilder getRepoFarLegSequence();
		RepoFarLeg.RepoFarLegBuilder setId(String id);
		RepoFarLeg.RepoFarLegBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		RepoFarLeg.RepoFarLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		RepoFarLeg.RepoFarLegBuilder setSettlementAmountOrCurrencyModel(SettlementAmountOrCurrencyModel settlementAmountOrCurrencyModel);
		RepoFarLeg.RepoFarLegBuilder setFxRate(FxRate fxRate);
		RepoFarLeg.RepoFarLegBuilder setRepoFarLegSequence(RepoFarLegSequence repoFarLegSequence);
		RepoFarLeg.RepoFarLegBuilder setRepoInterest(BigDecimal repoInterest);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementAmountOrCurrencyModel"), processor, SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder.class, getSettlementAmountOrCurrencyModel());
			processRosetta(path.newSubPath("fxRate"), processor, FxRate.FxRateBuilder.class, getFxRate());
			processRosetta(path.newSubPath("repoFarLegSequence"), processor, RepoFarLegSequence.RepoFarLegSequenceBuilder.class, getRepoFarLegSequence());
			processor.processBasic(path.newSubPath("repoInterest"), BigDecimal.class, getRepoInterest(), this);
		}
		

		RepoFarLeg.RepoFarLegBuilder prune();
	}

	/*********************** Immutable Implementation of RepoFarLeg  ***********************/
	class RepoFarLegImpl extends RepoLegBase.RepoLegBaseImpl implements RepoFarLeg {
		private final SettlementAmountOrCurrencyModel settlementAmountOrCurrencyModel;
		private final FxRate fxRate;
		private final RepoFarLegSequence repoFarLegSequence;
		private final BigDecimal repoInterest;
		
		protected RepoFarLegImpl(RepoFarLeg.RepoFarLegBuilder builder) {
			super(builder);
			this.settlementAmountOrCurrencyModel = ofNullable(builder.getSettlementAmountOrCurrencyModel()).map(f->f.build()).orElse(null);
			this.fxRate = ofNullable(builder.getFxRate()).map(f->f.build()).orElse(null);
			this.repoFarLegSequence = ofNullable(builder.getRepoFarLegSequence()).map(f->f.build()).orElse(null);
			this.repoInterest = builder.getRepoInterest();
		}
		
		@Override
		@RosettaAttribute("settlementAmountOrCurrencyModel")
		public SettlementAmountOrCurrencyModel getSettlementAmountOrCurrencyModel() {
			return settlementAmountOrCurrencyModel;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		public FxRate getFxRate() {
			return fxRate;
		}
		
		@Override
		@RosettaAttribute("repoFarLegSequence")
		public RepoFarLegSequence getRepoFarLegSequence() {
			return repoFarLegSequence;
		}
		
		@Override
		@RosettaAttribute("repoInterest")
		public BigDecimal getRepoInterest() {
			return repoInterest;
		}
		
		@Override
		public RepoFarLeg build() {
			return this;
		}
		
		@Override
		public RepoFarLeg.RepoFarLegBuilder toBuilder() {
			RepoFarLeg.RepoFarLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RepoFarLeg.RepoFarLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementAmountOrCurrencyModel()).ifPresent(builder::setSettlementAmountOrCurrencyModel);
			ofNullable(getFxRate()).ifPresent(builder::setFxRate);
			ofNullable(getRepoFarLegSequence()).ifPresent(builder::setRepoFarLegSequence);
			ofNullable(getRepoInterest()).ifPresent(builder::setRepoInterest);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RepoFarLeg _that = getType().cast(o);
		
			if (!Objects.equals(settlementAmountOrCurrencyModel, _that.getSettlementAmountOrCurrencyModel())) return false;
			if (!Objects.equals(fxRate, _that.getFxRate())) return false;
			if (!Objects.equals(repoFarLegSequence, _that.getRepoFarLegSequence())) return false;
			if (!Objects.equals(repoInterest, _that.getRepoInterest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementAmountOrCurrencyModel != null ? settlementAmountOrCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			_result = 31 * _result + (repoFarLegSequence != null ? repoFarLegSequence.hashCode() : 0);
			_result = 31 * _result + (repoInterest != null ? repoInterest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoFarLeg {" +
				"settlementAmountOrCurrencyModel=" + this.settlementAmountOrCurrencyModel + ", " +
				"fxRate=" + this.fxRate + ", " +
				"repoFarLegSequence=" + this.repoFarLegSequence + ", " +
				"repoInterest=" + this.repoInterest +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RepoFarLeg  ***********************/
	class RepoFarLegBuilderImpl extends RepoLegBase.RepoLegBaseBuilderImpl  implements RepoFarLeg.RepoFarLegBuilder {
	
		protected SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder settlementAmountOrCurrencyModel;
		protected FxRate.FxRateBuilder fxRate;
		protected RepoFarLegSequence.RepoFarLegSequenceBuilder repoFarLegSequence;
		protected BigDecimal repoInterest;
	
		public RepoFarLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementAmountOrCurrencyModel")
		public SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder getSettlementAmountOrCurrencyModel() {
			return settlementAmountOrCurrencyModel;
		}
		
		@Override
		public SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder getOrCreateSettlementAmountOrCurrencyModel() {
			SettlementAmountOrCurrencyModel.SettlementAmountOrCurrencyModelBuilder result;
			if (settlementAmountOrCurrencyModel!=null) {
				result = settlementAmountOrCurrencyModel;
			}
			else {
				result = settlementAmountOrCurrencyModel = SettlementAmountOrCurrencyModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		public FxRate.FxRateBuilder getFxRate() {
			return fxRate;
		}
		
		@Override
		public FxRate.FxRateBuilder getOrCreateFxRate() {
			FxRate.FxRateBuilder result;
			if (fxRate!=null) {
				result = fxRate;
			}
			else {
				result = fxRate = FxRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("repoFarLegSequence")
		public RepoFarLegSequence.RepoFarLegSequenceBuilder getRepoFarLegSequence() {
			return repoFarLegSequence;
		}
		
		@Override
		public RepoFarLegSequence.RepoFarLegSequenceBuilder getOrCreateRepoFarLegSequence() {
			RepoFarLegSequence.RepoFarLegSequenceBuilder result;
			if (repoFarLegSequence!=null) {
				result = repoFarLegSequence;
			}
			else {
				result = repoFarLegSequence = RepoFarLegSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("repoInterest")
		public BigDecimal getRepoInterest() {
			return repoInterest;
		}
		
		@Override
		@RosettaAttribute("id")
		public RepoFarLeg.RepoFarLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public RepoFarLeg.RepoFarLegBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public RepoFarLeg.RepoFarLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementAmountOrCurrencyModel")
		public RepoFarLeg.RepoFarLegBuilder setSettlementAmountOrCurrencyModel(SettlementAmountOrCurrencyModel settlementAmountOrCurrencyModel) {
			this.settlementAmountOrCurrencyModel = settlementAmountOrCurrencyModel==null?null:settlementAmountOrCurrencyModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxRate")
		public RepoFarLeg.RepoFarLegBuilder setFxRate(FxRate fxRate) {
			this.fxRate = fxRate==null?null:fxRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("repoFarLegSequence")
		public RepoFarLeg.RepoFarLegBuilder setRepoFarLegSequence(RepoFarLegSequence repoFarLegSequence) {
			this.repoFarLegSequence = repoFarLegSequence==null?null:repoFarLegSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("repoInterest")
		public RepoFarLeg.RepoFarLegBuilder setRepoInterest(BigDecimal repoInterest) {
			this.repoInterest = repoInterest==null?null:repoInterest;
			return this;
		}
		
		@Override
		public RepoFarLeg build() {
			return new RepoFarLeg.RepoFarLegImpl(this);
		}
		
		@Override
		public RepoFarLeg.RepoFarLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoFarLeg.RepoFarLegBuilder prune() {
			super.prune();
			if (settlementAmountOrCurrencyModel!=null && !settlementAmountOrCurrencyModel.prune().hasData()) settlementAmountOrCurrencyModel = null;
			if (fxRate!=null && !fxRate.prune().hasData()) fxRate = null;
			if (repoFarLegSequence!=null && !repoFarLegSequence.prune().hasData()) repoFarLegSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementAmountOrCurrencyModel()!=null && getSettlementAmountOrCurrencyModel().hasData()) return true;
			if (getFxRate()!=null && getFxRate().hasData()) return true;
			if (getRepoFarLegSequence()!=null && getRepoFarLegSequence().hasData()) return true;
			if (getRepoInterest()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoFarLeg.RepoFarLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RepoFarLeg.RepoFarLegBuilder o = (RepoFarLeg.RepoFarLegBuilder) other;
			
			merger.mergeRosetta(getSettlementAmountOrCurrencyModel(), o.getSettlementAmountOrCurrencyModel(), this::setSettlementAmountOrCurrencyModel);
			merger.mergeRosetta(getFxRate(), o.getFxRate(), this::setFxRate);
			merger.mergeRosetta(getRepoFarLegSequence(), o.getRepoFarLegSequence(), this::setRepoFarLegSequence);
			
			merger.mergeBasic(getRepoInterest(), o.getRepoInterest(), this::setRepoInterest);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RepoFarLeg _that = getType().cast(o);
		
			if (!Objects.equals(settlementAmountOrCurrencyModel, _that.getSettlementAmountOrCurrencyModel())) return false;
			if (!Objects.equals(fxRate, _that.getFxRate())) return false;
			if (!Objects.equals(repoFarLegSequence, _that.getRepoFarLegSequence())) return false;
			if (!Objects.equals(repoInterest, _that.getRepoInterest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementAmountOrCurrencyModel != null ? settlementAmountOrCurrencyModel.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			_result = 31 * _result + (repoFarLegSequence != null ? repoFarLegSequence.hashCode() : 0);
			_result = 31 * _result + (repoInterest != null ? repoInterest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoFarLegBuilder {" +
				"settlementAmountOrCurrencyModel=" + this.settlementAmountOrCurrencyModel + ", " +
				"fxRate=" + this.fxRate + ", " +
				"repoFarLegSequence=" + this.repoFarLegSequence + ", " +
				"repoInterest=" + this.repoInterest +
			'}' + " " + super.toString();
		}
	}
}
