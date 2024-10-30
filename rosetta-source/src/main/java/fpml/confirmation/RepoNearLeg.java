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
import fpml.confirmation.Money;
import fpml.confirmation.RepoLegBase;
import fpml.confirmation.RepoLegBase.RepoLegBaseBuilder;
import fpml.confirmation.RepoLegBase.RepoLegBaseBuilderImpl;
import fpml.confirmation.RepoLegBase.RepoLegBaseImpl;
import fpml.confirmation.RepoNearLeg;
import fpml.confirmation.RepoNearLeg.RepoNearLegBuilder;
import fpml.confirmation.RepoNearLeg.RepoNearLegBuilderImpl;
import fpml.confirmation.RepoNearLeg.RepoNearLegImpl;
import fpml.confirmation.RepoNearLegSequence;
import fpml.confirmation.meta.RepoNearLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A transaction leg for a repo is equivalent to a single cash transaction.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RepoNearLeg", builder=RepoNearLeg.RepoNearLegBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RepoNearLeg extends RepoLegBase {

	RepoNearLegMeta metaData = new RepoNearLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Settlement Amount
	 */
	Money getSettlementAmount();
	/**
	 * Indicates the rate of a currency conversion that is used to compute settlement amount for cross-currency transactions.
	 */
	FxRate getFxRate();
	RepoNearLegSequence getRepoNearLegSequence();

	/*********************** Build Methods  ***********************/
	RepoNearLeg build();
	
	RepoNearLeg.RepoNearLegBuilder toBuilder();
	
	static RepoNearLeg.RepoNearLegBuilder builder() {
		return new RepoNearLeg.RepoNearLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RepoNearLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RepoNearLeg> getType() {
		return RepoNearLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementAmount"), processor, Money.class, getSettlementAmount());
		processRosetta(path.newSubPath("fxRate"), processor, FxRate.class, getFxRate());
		processRosetta(path.newSubPath("repoNearLegSequence"), processor, RepoNearLegSequence.class, getRepoNearLegSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepoNearLegBuilder extends RepoNearLeg, RepoLegBase.RepoLegBaseBuilder {
		Money.MoneyBuilder getOrCreateSettlementAmount();
		Money.MoneyBuilder getSettlementAmount();
		FxRate.FxRateBuilder getOrCreateFxRate();
		FxRate.FxRateBuilder getFxRate();
		RepoNearLegSequence.RepoNearLegSequenceBuilder getOrCreateRepoNearLegSequence();
		RepoNearLegSequence.RepoNearLegSequenceBuilder getRepoNearLegSequence();
		RepoNearLeg.RepoNearLegBuilder setId(String id);
		RepoNearLeg.RepoNearLegBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		RepoNearLeg.RepoNearLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		RepoNearLeg.RepoNearLegBuilder setSettlementAmount(Money settlementAmount);
		RepoNearLeg.RepoNearLegBuilder setFxRate(FxRate fxRate);
		RepoNearLeg.RepoNearLegBuilder setRepoNearLegSequence(RepoNearLegSequence repoNearLegSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementAmount"), processor, Money.MoneyBuilder.class, getSettlementAmount());
			processRosetta(path.newSubPath("fxRate"), processor, FxRate.FxRateBuilder.class, getFxRate());
			processRosetta(path.newSubPath("repoNearLegSequence"), processor, RepoNearLegSequence.RepoNearLegSequenceBuilder.class, getRepoNearLegSequence());
		}
		

		RepoNearLeg.RepoNearLegBuilder prune();
	}

	/*********************** Immutable Implementation of RepoNearLeg  ***********************/
	class RepoNearLegImpl extends RepoLegBase.RepoLegBaseImpl implements RepoNearLeg {
		private final Money settlementAmount;
		private final FxRate fxRate;
		private final RepoNearLegSequence repoNearLegSequence;
		
		protected RepoNearLegImpl(RepoNearLeg.RepoNearLegBuilder builder) {
			super(builder);
			this.settlementAmount = ofNullable(builder.getSettlementAmount()).map(f->f.build()).orElse(null);
			this.fxRate = ofNullable(builder.getFxRate()).map(f->f.build()).orElse(null);
			this.repoNearLegSequence = ofNullable(builder.getRepoNearLegSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		public Money getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		public FxRate getFxRate() {
			return fxRate;
		}
		
		@Override
		@RosettaAttribute("repoNearLegSequence")
		public RepoNearLegSequence getRepoNearLegSequence() {
			return repoNearLegSequence;
		}
		
		@Override
		public RepoNearLeg build() {
			return this;
		}
		
		@Override
		public RepoNearLeg.RepoNearLegBuilder toBuilder() {
			RepoNearLeg.RepoNearLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RepoNearLeg.RepoNearLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementAmount()).ifPresent(builder::setSettlementAmount);
			ofNullable(getFxRate()).ifPresent(builder::setFxRate);
			ofNullable(getRepoNearLegSequence()).ifPresent(builder::setRepoNearLegSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RepoNearLeg _that = getType().cast(o);
		
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(fxRate, _that.getFxRate())) return false;
			if (!Objects.equals(repoNearLegSequence, _that.getRepoNearLegSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			_result = 31 * _result + (repoNearLegSequence != null ? repoNearLegSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoNearLeg {" +
				"settlementAmount=" + this.settlementAmount + ", " +
				"fxRate=" + this.fxRate + ", " +
				"repoNearLegSequence=" + this.repoNearLegSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RepoNearLeg  ***********************/
	class RepoNearLegBuilderImpl extends RepoLegBase.RepoLegBaseBuilderImpl  implements RepoNearLeg.RepoNearLegBuilder {
	
		protected Money.MoneyBuilder settlementAmount;
		protected FxRate.FxRateBuilder fxRate;
		protected RepoNearLegSequence.RepoNearLegSequenceBuilder repoNearLegSequence;
	
		public RepoNearLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementAmount")
		public Money.MoneyBuilder getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateSettlementAmount() {
			Money.MoneyBuilder result;
			if (settlementAmount!=null) {
				result = settlementAmount;
			}
			else {
				result = settlementAmount = Money.builder();
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
		@RosettaAttribute("repoNearLegSequence")
		public RepoNearLegSequence.RepoNearLegSequenceBuilder getRepoNearLegSequence() {
			return repoNearLegSequence;
		}
		
		@Override
		public RepoNearLegSequence.RepoNearLegSequenceBuilder getOrCreateRepoNearLegSequence() {
			RepoNearLegSequence.RepoNearLegSequenceBuilder result;
			if (repoNearLegSequence!=null) {
				result = repoNearLegSequence;
			}
			else {
				result = repoNearLegSequence = RepoNearLegSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public RepoNearLeg.RepoNearLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public RepoNearLeg.RepoNearLegBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public RepoNearLeg.RepoNearLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementAmount")
		public RepoNearLeg.RepoNearLegBuilder setSettlementAmount(Money settlementAmount) {
			this.settlementAmount = settlementAmount==null?null:settlementAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxRate")
		public RepoNearLeg.RepoNearLegBuilder setFxRate(FxRate fxRate) {
			this.fxRate = fxRate==null?null:fxRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("repoNearLegSequence")
		public RepoNearLeg.RepoNearLegBuilder setRepoNearLegSequence(RepoNearLegSequence repoNearLegSequence) {
			this.repoNearLegSequence = repoNearLegSequence==null?null:repoNearLegSequence.toBuilder();
			return this;
		}
		
		@Override
		public RepoNearLeg build() {
			return new RepoNearLeg.RepoNearLegImpl(this);
		}
		
		@Override
		public RepoNearLeg.RepoNearLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoNearLeg.RepoNearLegBuilder prune() {
			super.prune();
			if (settlementAmount!=null && !settlementAmount.prune().hasData()) settlementAmount = null;
			if (fxRate!=null && !fxRate.prune().hasData()) fxRate = null;
			if (repoNearLegSequence!=null && !repoNearLegSequence.prune().hasData()) repoNearLegSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementAmount()!=null && getSettlementAmount().hasData()) return true;
			if (getFxRate()!=null && getFxRate().hasData()) return true;
			if (getRepoNearLegSequence()!=null && getRepoNearLegSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepoNearLeg.RepoNearLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RepoNearLeg.RepoNearLegBuilder o = (RepoNearLeg.RepoNearLegBuilder) other;
			
			merger.mergeRosetta(getSettlementAmount(), o.getSettlementAmount(), this::setSettlementAmount);
			merger.mergeRosetta(getFxRate(), o.getFxRate(), this::setFxRate);
			merger.mergeRosetta(getRepoNearLegSequence(), o.getRepoNearLegSequence(), this::setRepoNearLegSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RepoNearLeg _that = getType().cast(o);
		
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(fxRate, _that.getFxRate())) return false;
			if (!Objects.equals(repoNearLegSequence, _that.getRepoNearLegSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			_result = 31 * _result + (repoNearLegSequence != null ? repoNearLegSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoNearLegBuilder {" +
				"settlementAmount=" + this.settlementAmount + ", " +
				"fxRate=" + this.fxRate + ", " +
				"repoNearLegSequence=" + this.repoNearLegSequence +
			'}' + " " + super.toString();
		}
	}
}
