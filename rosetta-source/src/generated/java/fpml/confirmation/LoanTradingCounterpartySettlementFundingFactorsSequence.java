package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.LoanTradingCostOfCarry;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactorsSequence;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilderImpl;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceImpl;
import fpml.confirmation.LoanTradingDelayedCompensation;
import fpml.confirmation.LoanTradingEconomicBenefit;
import fpml.confirmation.meta.LoanTradingCounterpartySettlementFundingFactorsSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradingCounterpartySettlementFundingFactorsSequence", builder=LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilderImpl.class, version="${project.version}")
public interface LoanTradingCounterpartySettlementFundingFactorsSequence extends RosettaModelObject {

	LoanTradingCounterpartySettlementFundingFactorsSequenceMeta metaData = new LoanTradingCounterpartySettlementFundingFactorsSequenceMeta();

	/*********************** Getter Methods  ***********************/
	LoanTradingDelayedCompensation getDelayedCompensation();
	LoanTradingCostOfCarry getCostOfCarry();
	/**
	 * The total economic benefit, based on facility-level activity between trade and settlement date, payable to the buyer of the asset.
	 */
	List<? extends LoanTradingEconomicBenefit> getEconomicBenefit();

	/*********************** Build Methods  ***********************/
	LoanTradingCounterpartySettlementFundingFactorsSequence build();
	
	LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder toBuilder();
	
	static LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder builder() {
		return new LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingCounterpartySettlementFundingFactorsSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingCounterpartySettlementFundingFactorsSequence> getType() {
		return LoanTradingCounterpartySettlementFundingFactorsSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("delayedCompensation"), processor, LoanTradingDelayedCompensation.class, getDelayedCompensation());
		processRosetta(path.newSubPath("costOfCarry"), processor, LoanTradingCostOfCarry.class, getCostOfCarry());
		processRosetta(path.newSubPath("economicBenefit"), processor, LoanTradingEconomicBenefit.class, getEconomicBenefit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder extends LoanTradingCounterpartySettlementFundingFactorsSequence, RosettaModelObjectBuilder {
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder getOrCreateDelayedCompensation();
		LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder getDelayedCompensation();
		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder getOrCreateCostOfCarry();
		LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder getCostOfCarry();
		LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder getOrCreateEconomicBenefit(int _index);
		List<? extends LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder> getEconomicBenefit();
		LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder setDelayedCompensation(LoanTradingDelayedCompensation delayedCompensation);
		LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder setCostOfCarry(LoanTradingCostOfCarry costOfCarry);
		LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder addEconomicBenefit(LoanTradingEconomicBenefit economicBenefit0);
		LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder addEconomicBenefit(LoanTradingEconomicBenefit economicBenefit1, int _idx);
		LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder addEconomicBenefit(List<? extends LoanTradingEconomicBenefit> economicBenefit2);
		LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder setEconomicBenefit(List<? extends LoanTradingEconomicBenefit> economicBenefit3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("delayedCompensation"), processor, LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder.class, getDelayedCompensation());
			processRosetta(path.newSubPath("costOfCarry"), processor, LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder.class, getCostOfCarry());
			processRosetta(path.newSubPath("economicBenefit"), processor, LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder.class, getEconomicBenefit());
		}
		

		LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingCounterpartySettlementFundingFactorsSequence  ***********************/
	class LoanTradingCounterpartySettlementFundingFactorsSequenceImpl implements LoanTradingCounterpartySettlementFundingFactorsSequence {
		private final LoanTradingDelayedCompensation delayedCompensation;
		private final LoanTradingCostOfCarry costOfCarry;
		private final List<? extends LoanTradingEconomicBenefit> economicBenefit;
		
		protected LoanTradingCounterpartySettlementFundingFactorsSequenceImpl(LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder builder) {
			this.delayedCompensation = ofNullable(builder.getDelayedCompensation()).map(f->f.build()).orElse(null);
			this.costOfCarry = ofNullable(builder.getCostOfCarry()).map(f->f.build()).orElse(null);
			this.economicBenefit = ofNullable(builder.getEconomicBenefit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("delayedCompensation")
		public LoanTradingDelayedCompensation getDelayedCompensation() {
			return delayedCompensation;
		}
		
		@Override
		@RosettaAttribute("costOfCarry")
		public LoanTradingCostOfCarry getCostOfCarry() {
			return costOfCarry;
		}
		
		@Override
		@RosettaAttribute("economicBenefit")
		public List<? extends LoanTradingEconomicBenefit> getEconomicBenefit() {
			return economicBenefit;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactorsSequence build() {
			return this;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder toBuilder() {
			LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder builder) {
			ofNullable(getDelayedCompensation()).ifPresent(builder::setDelayedCompensation);
			ofNullable(getCostOfCarry()).ifPresent(builder::setCostOfCarry);
			ofNullable(getEconomicBenefit()).ifPresent(builder::setEconomicBenefit);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCounterpartySettlementFundingFactorsSequence _that = getType().cast(o);
		
			if (!Objects.equals(delayedCompensation, _that.getDelayedCompensation())) return false;
			if (!Objects.equals(costOfCarry, _that.getCostOfCarry())) return false;
			if (!ListEquals.listEquals(economicBenefit, _that.getEconomicBenefit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (delayedCompensation != null ? delayedCompensation.hashCode() : 0);
			_result = 31 * _result + (costOfCarry != null ? costOfCarry.hashCode() : 0);
			_result = 31 * _result + (economicBenefit != null ? economicBenefit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCounterpartySettlementFundingFactorsSequence {" +
				"delayedCompensation=" + this.delayedCompensation + ", " +
				"costOfCarry=" + this.costOfCarry + ", " +
				"economicBenefit=" + this.economicBenefit +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingCounterpartySettlementFundingFactorsSequence  ***********************/
	class LoanTradingCounterpartySettlementFundingFactorsSequenceBuilderImpl implements LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder {
	
		protected LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder delayedCompensation;
		protected LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder costOfCarry;
		protected List<LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder> economicBenefit = new ArrayList<>();
	
		public LoanTradingCounterpartySettlementFundingFactorsSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("delayedCompensation")
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder getDelayedCompensation() {
			return delayedCompensation;
		}
		
		@Override
		public LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder getOrCreateDelayedCompensation() {
			LoanTradingDelayedCompensation.LoanTradingDelayedCompensationBuilder result;
			if (delayedCompensation!=null) {
				result = delayedCompensation;
			}
			else {
				result = delayedCompensation = LoanTradingDelayedCompensation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("costOfCarry")
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder getCostOfCarry() {
			return costOfCarry;
		}
		
		@Override
		public LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder getOrCreateCostOfCarry() {
			LoanTradingCostOfCarry.LoanTradingCostOfCarryBuilder result;
			if (costOfCarry!=null) {
				result = costOfCarry;
			}
			else {
				result = costOfCarry = LoanTradingCostOfCarry.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("economicBenefit")
		public List<? extends LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder> getEconomicBenefit() {
			return economicBenefit;
		}
		
		public LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder getOrCreateEconomicBenefit(int _index) {
		
			if (economicBenefit==null) {
				this.economicBenefit = new ArrayList<>();
			}
			LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder result;
			return getIndex(economicBenefit, _index, () -> {
						LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder newEconomicBenefit = LoanTradingEconomicBenefit.builder();
						return newEconomicBenefit;
					});
		}
		
		@Override
		@RosettaAttribute("delayedCompensation")
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder setDelayedCompensation(LoanTradingDelayedCompensation delayedCompensation) {
			this.delayedCompensation = delayedCompensation==null?null:delayedCompensation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("costOfCarry")
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder setCostOfCarry(LoanTradingCostOfCarry costOfCarry) {
			this.costOfCarry = costOfCarry==null?null:costOfCarry.toBuilder();
			return this;
		}
		@Override
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder addEconomicBenefit(LoanTradingEconomicBenefit economicBenefit) {
			if (economicBenefit!=null) this.economicBenefit.add(economicBenefit.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder addEconomicBenefit(LoanTradingEconomicBenefit economicBenefit, int _idx) {
			getIndex(this.economicBenefit, _idx, () -> economicBenefit.toBuilder());
			return this;
		}
		@Override 
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder addEconomicBenefit(List<? extends LoanTradingEconomicBenefit> economicBenefits) {
			if (economicBenefits != null) {
				for (LoanTradingEconomicBenefit toAdd : economicBenefits) {
					this.economicBenefit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("economicBenefit")
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder setEconomicBenefit(List<? extends LoanTradingEconomicBenefit> economicBenefits) {
			if (economicBenefits == null)  {
				this.economicBenefit = new ArrayList<>();
			}
			else {
				this.economicBenefit = economicBenefits.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactorsSequence build() {
			return new LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceImpl(this);
		}
		
		@Override
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder prune() {
			if (delayedCompensation!=null && !delayedCompensation.prune().hasData()) delayedCompensation = null;
			if (costOfCarry!=null && !costOfCarry.prune().hasData()) costOfCarry = null;
			economicBenefit = economicBenefit.stream().filter(b->b!=null).<LoanTradingEconomicBenefit.LoanTradingEconomicBenefitBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDelayedCompensation()!=null && getDelayedCompensation().hasData()) return true;
			if (getCostOfCarry()!=null && getCostOfCarry().hasData()) return true;
			if (getEconomicBenefit()!=null && getEconomicBenefit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder o = (LoanTradingCounterpartySettlementFundingFactorsSequence.LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder) other;
			
			merger.mergeRosetta(getDelayedCompensation(), o.getDelayedCompensation(), this::setDelayedCompensation);
			merger.mergeRosetta(getCostOfCarry(), o.getCostOfCarry(), this::setCostOfCarry);
			merger.mergeRosetta(getEconomicBenefit(), o.getEconomicBenefit(), this::getOrCreateEconomicBenefit);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCounterpartySettlementFundingFactorsSequence _that = getType().cast(o);
		
			if (!Objects.equals(delayedCompensation, _that.getDelayedCompensation())) return false;
			if (!Objects.equals(costOfCarry, _that.getCostOfCarry())) return false;
			if (!ListEquals.listEquals(economicBenefit, _that.getEconomicBenefit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (delayedCompensation != null ? delayedCompensation.hashCode() : 0);
			_result = 31 * _result + (costOfCarry != null ? costOfCarry.hashCode() : 0);
			_result = 31 * _result + (economicBenefit != null ? economicBenefit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCounterpartySettlementFundingFactorsSequenceBuilder {" +
				"delayedCompensation=" + this.delayedCompensation + ", " +
				"costOfCarry=" + this.costOfCarry + ", " +
				"economicBenefit=" + this.economicBenefit +
			'}';
		}
	}
}
